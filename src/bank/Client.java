package bank;

import java.util.ArrayList;

public class Client {

	private String name;
	private String address;
	private double cash;
	private double monthlySalary;
	private ArrayList<BankAccount.Deposit> bankDeposit;
	private ArrayList<BankAccount.Credit> bankCredit;

	
	public Client(String name, String address, double cash, double monthlySalary) {
		this.name = name;
		this.address = address;
		this.cash = cash;
		this.monthlySalary = monthlySalary;
		this.bankCredit = new ArrayList<BankAccount.Credit>();
		this.bankDeposit = new ArrayList<BankAccount.Deposit>();
	}

	
	public void makeDeposit(double sum, Bank bank, BankAccount.Deposit deposit){
		try{
			if(sum < 0 && this.cash < sum){
				throw new DepositException(this.name + " doesn't have enough money to make a deposit");
			} else { 
				bank.makeDeposit(sum, deposit);
				this.cash -= sum;
				this.bankDeposit.add(deposit);
				this.bankDeposit.get(this.bankDeposit.indexOf(deposit)).changeAvailability(sum);
				System.out.println(this.name + " made a deposit | sum available: " + this.cash + " | deposite made: " + sum);
			}
		} catch (DepositException e) {
			e.getMessage();
		}
	}
	
	
	public void takeCredit(double sum, Bank bank, BankAccount.Credit credit, int period){
		double monthlyPaymentOnAllCredits = 0;
		credit.setPeriod(period);
		credit.setMonthlyPayment(sum, period);
		this.bankCredit.add(credit);
		for(BankAccount.Credit takedCredit : this.bankCredit){
			monthlyPaymentOnAllCredits += takedCredit.getMonthlyPayment();
		}
		try{
			if(monthlyPaymentOnAllCredits > 50 * this.monthlySalary / 100){
				throw new CreditException(this.name + "'s payments on all credits are bigger than his monthly salary");
			}
			try{
				bank.giveCredit(sum, credit, this);
				this.cash += sum;
				credit.changeAvailability(sum);
				System.out.println(this.name + " take a credit | sum available: " + this.cash + " | taked credit: " + sum);
			} catch (CreditException e){
				System.out.println(e.getMessage());
			}
		} catch (CreditException e){
			System.out.println(e.getMessage());
		}
	}
	
	public void payCredit(BankAccount.Credit credit){
		double creditInterest = credit.calculateInterest(credit.getInterest(), credit.getMonthlyPayment(), credit.getPeriodOfMonths());
		
		try{
			if(this.cash < credit.getMonthlyPayment() + creditInterest){
				throw new CreditException(this.name + " doesn't have enough money to pay the credit");
				
			} 
			this.cash -= creditInterest + credit.getMonthlyPayment();
			
		} catch (CreditException e) {
			e.getMessage();
		}
	}
	
	
	public double getMoney() {
		return this.cash;
	}

	
	public String getName() {
		return name;
	}

	
	public double getMonthlySalary() {
		return monthlySalary;
	}
	

	@Override
	public String toString() {
		System.out.println( "\n-------" + this.name + "--------");
		System.out.println("#credits:");
		for(BankAccount.Credit credit : this.bankCredit){
			System.out.println(credit);
		}
		System.out.println("\n#deposits:");
		for(BankAccount.Deposit deposit : this.bankDeposit){
			System.out.println(deposit);
		}
		return "cash: " + this.cash + "\n";
	}
	


}

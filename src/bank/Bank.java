package bank;

import java.util.ArrayList;

public class Bank {

	private String name;
	private String address;
	private ArrayList<BankAccount> bankAccount;
	private double moneyAvailability;
	private double bankReserve;

	
	public Bank(String name, String address, double moneyAvailability) {
		this.name = name;
		this.address = address;
		this.moneyAvailability = moneyAvailability;
		this.bankAccount = new ArrayList<BankAccount>();
	}

	
	public void makeDeposit(double sum, BankAccount.Deposit deposit) {
		this.moneyAvailability += sum;
		this.bankReserve += 90 * sum / 100;
		this.bankAccount.add(deposit);
	}

	
	public void giveCredit(double sum, BankAccount.Credit credit, Client client) throws CreditException {
		if (credit.getMonthlyPayment() > 50 * client.getMonthlySalary() / 100) {
			throw new CreditException(
					client.getName() + "'s salary is shorter than 50% of the credit's monthly payment");
		}
		if (sum > this.bankReserve) {
			throw new CreditException("Bank has no enough reserv");
		}
		this.moneyAvailability -= sum;
	}

	
	public void payAllInterests() {
		for (BankAccount account : this.bankAccount) {
			if (account instanceof BankAccount.Deposit) {
				double interest = calculateInterest(account.getInterest(), account.getAvailability(),
						account.getPeriodOfMonths());
				account.changeAvailability(interest);
				try {
					if (moneyAvailability < 0 || this.moneyAvailability < interest) {
						throw new DepositException(this.name + " falira. Mnogo tyjno...");
					}
					this.moneyAvailability -= interest;
				} catch (DepositException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}

	
	private double calculateInterest(double interestRate, double initialCapital, int period) {
		double annualPeriod = (double) period / 12;
		return initialCapital * annualPeriod * interestRate / 100;
	}

	
	@Override
	public String toString() {
		return "------" + this.name + "------\n" + "Money availability: " + this.moneyAvailability + "\nBank reserve: "
				+ this.bankReserve + "\n---------------------------\n";
	}

}

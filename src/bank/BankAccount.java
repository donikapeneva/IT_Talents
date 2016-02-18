package bank;

public abstract class BankAccount {

	private String name;
	private double interest;
	private int periodOfMonths;
	private double availability;
	
	
	protected BankAccount(String name, double interest, int periodOfMonths) {
		this(name, interest);
		this.periodOfMonths = periodOfMonths;
	}
	
	
	protected BankAccount(String name, double interest) {
		this.name = name;
		this.interest = interest;
	}
	
	
	public abstract void changeAvailability(double sum);
	
	
	public static class Deposit extends BankAccount{

		public Deposit(String name, double annualRate, int periodOfMonths) {
			super(name, annualRate, periodOfMonths);
		}
		
		@Override
		public void changeAvailability(double sum){
			if (sum >= 0) {
				super.setAvailability(super.getAvailability() + sum);
			} else {
				System.out.println("Are you trying to steal??");
			}
		}
	}
	
	
	public static class Credit extends BankAccount{
		
		private double monthlyPayment;
		
		public Credit(String name, double interest) {
			super(name, interest);
			this.monthlyPayment = 0 ;
		}
		
		@Override
		public void changeAvailability(double sum){
			super.setAvailability(super.getAvailability() - sum);
		}
		
		public double getMonthlyPayment(){
			return this.monthlyPayment;
		}
		
		public double calculateInterest(double interestRate, double initialCapital, int period){
			return initialCapital * interestRate * period / 100 ;
		}

		public void setMonthlyPayment(double sum, int period) {
			this.monthlyPayment = sum / ((double)period);
		}
	}
	
	
	public double getInterest() {
		return interest;
	}
	
	
	public void setAvailability(double availability){
		this.availability = availability;
	}

	
	public double getAvailability() {
		return availability;
	}
	
	
	public int getPeriodOfMonths() {
		return periodOfMonths;
	}

	
	public void setPeriod(int period) {
		this.periodOfMonths = period;
	}
	
	
	@Override
	public String toString() {
		return this.name + "\nperiod: " + this.periodOfMonths + " interest: " + this.interest + "%" + "\navailability in account: " + this.availability;
	}
	
}

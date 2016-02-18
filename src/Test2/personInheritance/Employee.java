package personInheritance;

public class Employee extends Person{

	private double daySalary;
	private double overtime;
	
	
	Employee(String name, int age, boolean isMale, double daySalary){
		super(name, age, isMale);
		setDaySalary(daySalary);
	}
	
	public void setDaySalary(double daySalary){
		if(daySalary > 0){
			this.daySalary = daySalary;
		}
	}
	
	public double getDaySalary(){
		return this.daySalary;
	}
	
	public double getOvertime(){
		return this.overtime;
	}
	
	public double calculateOvertime(double hours){
		if(super.age < 18){
			this.overtime = 0;
		} else {
			this.overtime = 1.5 * getDaySalary() * hours;
		}
		
		return getOvertime();
	}
	
	public void showEmployeeInfo(){
		super.showPersonInfo();
		System.out.println("day salary: " + getDaySalary());
	}
	
}

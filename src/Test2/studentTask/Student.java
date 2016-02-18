package studentTask;

public class Student {

	String name;
	String subject;
	double grade;
	int yearInCollege;
	int age;
	boolean isDegree;
	double money; 
	
	Student(){
		this.grade = 4.0;
		this.yearInCollege = 1;
		this.isDegree = false;
		this.money = 0;
	}
	
	Student(String name, String subject, int age){
		this();
		this.name = name;
		this.subject = subject;
		this.age = age;
	}
	
	void upYear(){
		if(!this.isDegree){
			if(this.yearInCollege < 4){
				this.yearInCollege += 1;
			} else {
				this.isDegree = true;
			}
		} else { 
			this.yearInCollege = 0;
		}
	}
	
	double receiveScholarship(double min, double amount){
		if(!isDegree && this.grade >= min && this.age < 30){
			this.money += amount;
		}
		return this.money;
	}
	
	
}

package personInheritance;

public class Demo {

	public static void main(String[] args) {

		Person[] person = new Person[10];
		
		person[0] = new Person("Pesho", 32, true);
		person[1] = new Person("Ivan", 21, true);
		person[2] = new Employee("Mariq", 18, false, 5);
		person[3] = new Employee("Nikolai", 21, true, 8);
		person[4] = new Student("Andrei", 21, true, 4.30);
		person[5] = new Student("Nataliq", 19, false, 5.00);
		int freePlaces = 4;

		for(int i = 0; i < person.length - freePlaces; i++){
			if (person[i] instanceof Employee) {
				((Employee)person[i]).showEmployeeInfo();
			} else if (person[i] instanceof Student){
				((Student)person[i]).showStudentInfo();
			} else {
				person[i].showPersonInfo();
			}
			System.out.println("-----------");
		}
		
		for(int i = 0; i < person.length - freePlaces; i++){
			if(person[i] instanceof Employee){
				System.out.println(((Employee)person[i]).name + ": " + ((Employee)person[i]).calculateOvertime(2));
			}
		}
		
	}

}

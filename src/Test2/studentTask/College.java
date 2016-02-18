package studentTask;

public class College {

	public static void main(String[] args) {

		Student pesho = new Student("Pesho", "Bio", 20);
		pesho.grade = 5.50;
		pesho.money = 30;
		
		Student chavdar = new Student("Chavdar", "Mat", 20);
		
		Student mariq = new Student("Mariq", "Bio", 30);
		mariq.grade = 5.60;
		mariq.isDegree = true;
		
		Student nadq = new Student("Nadq", "Bio", 20);
		nadq.grade = 5.40;
		
		Student nikola = new Student("Nikola", "Mat", 25);
		nikola.grade = 5.00;
		nikola.yearInCollege = 3;
		
		
		Student ivan = new Student("Ivan", "Mat", 21);
		ivan.yearInCollege = 4;
		
		ivan.upYear();
		nikola.upYear();
		
		mariq.upYear();
		
		StudentGroup mathClass = new StudentGroup("Mat");
		StudentGroup bioClass = new StudentGroup("Bio");
		
		mathClass.addStudent(mariq);
		mathClass.addStudent(chavdar);
		mathClass.addStudent(nikola);
		mathClass.addStudent(ivan);
		
		bioClass.addStudent(pesho);
		bioClass.addStudent(mariq);
		bioClass.addStudent(nadq);

		for(int i = 0; i < mathClass.students.length - mathClass.freePlaces; i++){
			mathClass.students[i].receiveScholarship(4.50, 25);
			bioClass.students[i].receiveScholarship(5.00, 25);
		}
		
		bioClass.printStudentsInGroup();
		mathClass.printStudentsInGroup();
		
		bioClass.emptyGroup();
		
		System.out.println();
		System.out.println();
		bioClass.printStudentsInGroup();
		mathClass.printStudentsInGroup();
		
		System.out.println("Free places in bio class: " + bioClass.freePlaces);
		System.out.println("The best student of math clas is: " + mathClass.theBestStudent());
		
	}

}

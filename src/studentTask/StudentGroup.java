package studentTask;


public class StudentGroup {

	String groupSubject;
	Student[] students;
	int freePlaces;
	
	StudentGroup(){
		this.students = new Student[5];
		this.freePlaces = 5;
	}
	
	StudentGroup(String subject){
		this();
		this.groupSubject = subject;
	}
	
	void addStudent(Student a){
		if(freePlaces > 0 && a != null){
			if(this.groupSubject.equals(a.subject) ){
				students[students.length - freePlaces] = a;
				freePlaces--;
			}
		} else {
			System.out.println("There's no free place");
		}
	}
	
	void emptyGroup(){
		students = null;
		freePlaces = 5;
	}
	
	String theBestStudent(){
		if(students != null){
			int index = 0;
			for(int i = 1; i < students.length - freePlaces; i++){
				if(students[i].grade > students[index].grade){
					index = i;
				}
			}
			return students[index].name;
		} else {
			return "no students";
		}
	}
	
	void printStudentsInGroup(){
		if(students != null){ 
			for(int i = 0; i < students.length - freePlaces; i++){
				System.out.println("Name: " + students[i].name + ", Age: " + students[i].age + ", Is " + (students[i].isDegree? "" : "not") + " degreed");
				System.out.println("Grade: " + students[i].grade);
				System.out.println("Subject: " + students[i].subject + 
						(!students[i].isDegree ?  ", " + students[i].yearInCollege + " year in college" : ""));
				System.out.println("Money: " + students[i].money);
				System.out.println("---------------");
			}
		}
	}
}

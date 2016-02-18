package personInheritance;

public class Student extends Person{

	private double score;
	
	/**
	 * когато се създава обект от наследяващ клас, default-ният му конструктор извиква 
	 * default-ния конструктор на класа, който наследява (за да се създаде първо обект 
	 * от тип Person и след това човекът става студент или работник). Ако липсва default-ен
	 * конструктор в супер класа, то сме задължени да направим конструктор в текущия клас,
	 * с който да извикаме горен контруктор.
	 */
	Student(String name, int age, boolean isMale, double score) {
		super(name, age, isMale);
		setScore(score);
	}
	
	public void setScore(double score){
		if(score > 0){
			this.score = score;
		}
	}
	
	public void showStudentInfo(){
		super.showPersonInfo();
		System.out.println("score: " + this.score);
	}

	
	

}

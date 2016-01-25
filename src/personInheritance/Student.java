package personInheritance;

public class Student extends Person{

	private double score;
	
	/**
	 * ������ �� ������� ����� �� ���������� ����, default-���� �� ����������� ������� 
	 * default-��� ����������� �� �����, ����� ��������� (�� �� �� ������� ����� ����� 
	 * �� ��� Person � ���� ���� ������� ����� ������� ��� ��������). ��� ������ default-��
	 * ����������� � ����� �����, �� ��� ��������� �� �������� ����������� � ������� ����,
	 * � ����� �� �������� ����� ����������.
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

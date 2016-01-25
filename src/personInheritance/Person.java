package personInheritance;

public class Person {

	protected String name;
	protected int age;
	protected boolean isMale;
	
	Person(String name, int age, boolean isMale){
		setName(name);
		setAge(age);
		setSex(isMale);
	}
	
	public void setName(String name){
		if(name != null){
			this.name = name;
		}
	}
	
	public void setAge(int age){
		if(age > 0){
			this.age = age;
		}
	}
	
	public void setSex(boolean isMale){
		this.isMale = isMale;
	}
	
	protected void showPersonInfo(){
		System.out.println(this);
	}
	
	@Override
	public String toString() {
		return "name:" + name + "\nage:" + age + "\nisMale:" + isMale;
	}
	
}

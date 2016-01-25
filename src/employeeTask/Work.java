package employeeTask;

public class Work {

	public static void main(String[] args) {

		Employee pesho = new Employee("Pesho");
		Task makeAPizza = new Task("Make a pizza", 12);
		pesho.setCurrentTask(makeAPizza);
		pesho.work();
		
		Employee gosho = new Employee("Gosho");
		gosho.setCurrentTask(makeAPizza);
		gosho.work();
		
		Employee pencho = new Employee("Pencho");
		Task makeSpagetti = new Task("Make spagetti", 7);
		pencho.setCurrentTask(makeSpagetti);
		pencho.work();
		
		Employee toshko = new Employee("Pencho");
		Task makePotatoes = new Task("Make potatoes", 7.5);
		toshko.setCurrentTask(makePotatoes);
		toshko.work();
		
	}

}

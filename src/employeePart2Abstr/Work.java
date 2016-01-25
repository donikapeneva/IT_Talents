package employeePart2Abstr;

public class Work {

	public static void main(String[] args) {

		AllWork allWork = new AllWork();
		allWork = new AllWork();
		allWork.addTask(new Task("Make a pizza", 12));
		allWork.addTask(new Task("Clean the floor", 3));
		allWork.addTask(new Task("Cut the carrots", 5));
		allWork.addTask(new Task("Make spagetti", 7));
		allWork.addTask(new Task("Make a soup", 10));
		allWork.addTask(new Task("Clean the cooker", 11));
		allWork.addTask(new Task("Cut the onions", 48));
		allWork.addTask(new Task("Eat chocolate", 2));
		allWork.addTask(new Task("Rest", 28));
		allWork.addTask(new Task("Do your homework", 42));

		
		Employee[] employee = new Employee[4];
		employee[0] = new Employee("Pesho");
		employee[1] = new Employee("Gosho");
		employee[2] = new Employee("Zdravko");
		employee[3] = new Employee("Ivan");
		
		Employee.setAllWork(allWork);
		
		int day = 1;
		
		while(true){
			System.out.println("Day: " + day);
			System.out.println("---------------------------------");		
			
			for(int i = 0; i < employee.length; i++){
				employee[i].work();
			}

			day++;
			
			if(allWork.isAllWorkDone()){
				System.out.println("All work is done");
				break;
			}
			
		}
	}

}

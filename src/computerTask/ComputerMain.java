package computerTask;

public class ComputerMain {

	public static void main(String[] args) {

		Computer firstComputer = new Computer(2015, 200, 1000, 1000);
		Computer secondComputer = new Computer(2014, 1000, true, 512, 400, "Mac OS");
		Computer thirdComputer = new Computer(2010, 500, 500, 500);
		Computer forthComputer = new Computer(2015, 1000, false, 1000, 800, "Linux");

		System.out.println("Comparing first and second computer");
		printInfo(firstComputer.comparePrice(secondComputer));
		System.out.println("Comparing second and forth computer");
		printInfo(secondComputer.comparePrice(forthComputer));
		System.out.println("Comparing third and second first");
		printInfo(thirdComputer.comparePrice(firstComputer));

	}

	static void printInfo(int result) {
		switch (result) {
		case -1:
			System.out.println("The price of the first one is bigger");
			break;
		case 1:
			System.out.println("The price of the second one is bigger");
			break;
		default:
			System.out.println("Prices are equal");
			break;
		}
	}

}

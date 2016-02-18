package computerTask;
public class Computer {

	int year;
	double price; 
	boolean isNotebook;
	double hardDiskMemory; 
	double freeMemory; 
	String operationSystem;

	Computer(){
		this.isNotebook = false;
		this.operationSystem = "Win XP";
	}
	
	Computer(int year, double price, double hardDiskMemory, double freeMemory){
		this();
		this.year = year;
		this.price = price;
		this.hardDiskMemory = hardDiskMemory;
		this.freeMemory = freeMemory;
	}
	
	Computer(int year, double price, boolean isNotebook, double hardDiskMemory,
			double freeMemory, String operationSystem){
		
		this(year, price, hardDiskMemory, freeMemory);
		this.isNotebook = isNotebook;
		this.operationSystem = operationSystem;
	}
	
	int comparePrice(Computer c){
		if (this.price > c.price){
			return -1;
		} else if(this.price < c.price){
			return 1;
		} else {
			return 0;
		}
	}
	
	void changeOperationSystem(String newOperationSystem) {
		this.operationSystem = newOperationSystem;
	}

	void useMemory(double memory) {
		if (memory > this.freeMemory) {
			System.out.println("Not enough free memory!");
		}
		else {
			this.freeMemory -= memory;
		}
	}

	void printComputerCharacteristics() {
		System.out.println("Data for the computer: ");
		System.out.println("year: " + year);
		System.out.println("price: " + price);
		System.out.println("Harddisk memory : " + hardDiskMemory);
		System.out.println("Free memory : " + freeMemory);
		System.out.println("Operation system: " + operationSystem);
		System.out.println("Is the computer a portable: " + isNotebook);
	}
}

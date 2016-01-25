package vinetki;

public class Demo {

	public static void main(String[] args) {
		//create Gas Station
		GasStation station = new GasStation();
		station.showVignettesForSale();
		
		//Create 20 drivers
		Driver[] drivers = new Driver[20];
		drivers[0] = new Driver("Bob", 100, station);
		drivers[1] = new Driver("Carl", 150, station);
		drivers[2] = new Driver("Mike", 200, station);
		drivers[3] = new Driver("Todor", 250, station);
		drivers[4] = new Driver("Petur", 300, station);
		drivers[5] = new Driver("Azis", 50, station);
		drivers[6] = new Driver("Osman", 100, station);
		drivers[7] = new Driver("Ali Raza", 150, station);
		drivers[8] = new Driver("Stefan", 170, station);
		drivers[9] = new Driver("Donika", 900, station);
		drivers[10]= new Driver("Ivelina", 150, station);
		drivers[11] = new Driver("Maria", 300, station);
		drivers[12] = new Driver("Katerina", 500, station);
		drivers[13] = new Driver("Ivo", 200, station);
		drivers[14] = new Driver("Rostislav", 170, station);
		drivers[15] = new Driver("Qvor", 210, station);
		drivers[16] = new Driver("Kalata", 50, station);
		drivers[17] = new Driver("Yoan", 70, station);
		drivers[18] = new Driver("Ivan", 90, station);
		drivers[19]= new Driver("Ian Somerhalder", 110, station);
		
		//create 200 vehicles
		Vehicle[] vehicalsForDemo = new Vehicle[200];
		for(int i = 0; i < vehicalsForDemo.length; i++){
			Vehicle vehicle;
			int random = (int )(Math.random() * 3 + 1);
			switch(random){
			case 1: vehicalsForDemo[i] = new Car();
					break;
			case 2: vehicalsForDemo[i] = new Bus();
					break;
			case 3: vehicalsForDemo[i] = new Truck();
					break;
			}
		}
		
		//setting the vehicles to the drivers
		int vehicleCounter = 0;
		for(int i = 0; i < drivers.length;  i++){
			for(int j = 0; j < drivers[i].getNumberOfVehicles(); j++){
				drivers[i].setVehicle(vehicalsForDemo[vehicleCounter++]);
			}
		}
		
		// step 4
		for(int i = 0; i < drivers.length; i++){
			if(i % 3 == 0){
				for(int j = 0; j < 5; j++){
					randomGenerator(drivers[i], j);
				}
			} else {
				for (int j = 0; j < drivers[i].getNumberOfVehicles(); j++) {
					randomGenerator(drivers[i], j);
				}
			}
		}
		
		// step 5
		for(int i = 0; i < drivers.length; i++){
			drivers[i].showInfo();
		}
		
		// step 6
		station.showAvailableVignettes();
		
		// step 7
		for(int i = 0; i < vehicalsForDemo.length; i++){
			if (vehicalsForDemo[i] instanceof Truck){
				if(vehicalsForDemo[i].checkVignette(17, 2, 2016)){
					vehicalsForDemo[i].showInfoForVehicle();
				}
			}
		}

	}
	
	static void randomGenerator(Driver driver, int numberOfVehicle){
		int r = (int )(Math.random()*3 +1);
		switch(r){
		case 1: driver.buyVignette(driver.getVehicle(numberOfVehicle), "week");
		break;
		case 2: driver.buyVignette(driver.getVehicle(numberOfVehicle), "month");
		break;
		case 3: driver.buyVignette(driver.getVehicle(numberOfVehicle), "year");
		break;
		}
	}

}

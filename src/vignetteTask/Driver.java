package vinetki;

public class Driver {

	private String name;
	private Vehicle[] vehicles;
	private int freePosition;
	private double money;
	private GasStation stationEntered;
	
	public Driver(String name, double money, GasStation stationEntered){
		//TODO
		this.freePosition = 0;
	}
	
	public int getNumberOfVehicles(){
		return vehicles.length;
	}
	
	public void buyVignetteForAllVehicles(String period){
		for(int i = 0; i < this.vehicles.length; i++){
			this.buyVignette(vehicles[i], period);
		}
	}
	
	public void buyVignette(Vehicle vehicle, String period){
		Vignette v = null;
		if(vehicle instanceof Car){
			v = new CarVignette(period)	;
		} else if (vehicle instanceof Truck){
			v = new TruckVignette(period);
		} else if (vehicle instanceof Bus){
			v = new BusVignette(period);
		}
		if(money >= v.getPrice()){ 
			this.money -= v.getPrice();
			(this.stationEntered.sellVignette(v.getPrice())).putOnWindow(vehicle);
		} else {
			System.out.println(this.name + "hasn't got enough money to buy vignette!!!");
		}
	}
	
	public void showAllVehiclesWithOutdatedVignette(){
		//TODO
	}
	
	public void setVehicle(Vehicle vehicle) {
		if(this.freePosition >= vehicles.length){
			System.out.println("There is no free places!");
		} else {
			this.vehicles[this.freePosition++] = vehicle;
		}
	}
	
	public Vehicle getVehicle(int number) {
		//TODO
		return null;
	}
	
	public void showInfo() { 
		//TODO
		// from step 5
		
	}
	
}

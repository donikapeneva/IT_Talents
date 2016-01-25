package vinetki;

public abstract class Vehicle {

	private String model;
	private Vignette vignette;
	private int yearOfProduction;
	
	//constructor, random for creating vehicles
	
	public boolean checkVignette(int day, int month, int year){
		//TODO
		return false;
	}
	
	public void showInfoForVehicle(){
		//TODO
	}
	
	public void putVignette(Vignette vignette) {
		this.vignette = vignette;
	}
	
}

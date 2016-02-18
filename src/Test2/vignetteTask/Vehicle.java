package vignetteTask;

public abstract class Vehicle {

	private String model;
	private Vignette vignette;
	private int yearOfProduction;
	
	//constructor, random for creating vehicles
	Vehicle(){
		this.randomCreating();
	}
	
	public boolean checkVignette(int day, int month, int year){
		//TODO
		return false;
	}
	
	public void showInfoForVehicle(){
		//TODO
		System.out.println(this.model + " " + this.yearOfProduction + " " 
		+ (this.vignette == null ? "hasn't got a vignette" : this.vignette.getPrice()) );
	}
	
	public void putVignette(Vignette vignette) {
		this.vignette = vignette;
	}
	
	protected abstract void randomCreating();
	
	protected void setModel(String model){
		if(model != null){
			this.model = model;
		}
	}
	
	protected void setYearOfProduction(int year){
		if(year > 0){
			this.yearOfProduction = year;
		}
	}
		

	
}

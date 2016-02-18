package vignetteTask;

public class CarVignette extends Vignette{
	
	public static String COLOUR = "Green";
	
	public CarVignette(String period) {
		super(period);
		super.setPrice(period, 5);
	}
	
	@Override
	public int putOnWindow(Vehicle vehicle) {
		vehicle.putVignette(this);
		return 5; 
	}

}

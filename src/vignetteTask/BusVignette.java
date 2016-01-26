package vignetteTask;

public class BusVignette extends Vignette {
	
	public static String COLOUR = "Orange";

	public BusVignette(String period) {
		super(period);
		super.setPrice(period, 9);
	}
	
	@Override
	public int putOnWindow(Vehicle vehicle) {
		vehicle.putVignette(this);
		return 20;		
	}

}

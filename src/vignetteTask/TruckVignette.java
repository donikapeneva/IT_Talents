package vinetki;

public class TruckVignette extends Vignette{

	public static String COLOUR = "Blue";
	
	public TruckVignette(String period) {
		super(period);
		super.setPrice(period, 7);
	}
	
	@Override
	public int putOnWindow(Vehicle vehicle) {
		vehicle.putVignette(this);
		return 10;		
	}

}

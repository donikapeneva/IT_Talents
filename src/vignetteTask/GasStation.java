package vignetteTask;

public class GasStation {

	private int moneyForTheDay;
	private Vignette[] vignettes;
	
	public GasStation(){
		this.vignettes = new Vignette[10_000];
		this.generateVignettes();
		this.sortVignettes();
		this.moneyForTheDay = 0;
	}
	
	public void showVignettesForSale(){
		//TODO
	}
	
	public void showAvailableVignettes() {
		//TODO
	}
	
	public Vignette sellVignette(int price){
		this.moneyForTheDay += price;
		Vignette v = this.searchVignette(price);
		return v;		
	}
	
	private void generateVignettes() {
		String period = "";
		for (int i = 0; i < vignettes.length; i++) {
			int random = (int) (Math.random() * 3 + 1);
			switch (random) {
			case 1:
				period = Vignette.VALID_FOR_WEEK;
				break;
			case 2:
				period = Vignette.VALID_FOR_MONTH;
				break;
			case 3:
				period = Vignette.VALID_FOR_YEAR;
				break;
			}

			random = (int) (Math.random() * 3 + 1);
			switch (random) {
			case 1:
				this.vignettes[i] = new CarVignette(period);
				break;
			case 2:
				this.vignettes[i] = new BusVignette(period);
				break;
			case 3:
				this.vignettes[i] = new TruckVignette(period);
				break;
			}
		}
	}
	
	public void sortVignettes(){
		//TODO
	}
	
	private Vignette searchVignette(int price) {
		//TODO
		Vignette v = null;
		// search v = vignette , Vignette = null
		this.sortVignettes();
		return v;
	}
	
		
}

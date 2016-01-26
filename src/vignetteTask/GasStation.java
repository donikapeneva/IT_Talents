package vignetteTask;

public class GasStation {

	private int moneyForTheDay;
	private Vignette[] vignettes;

	public GasStation() {
		this.vignettes = new Vignette[10_000];
		this.generateVignettes();
		this.sortVignettes();
		this.moneyForTheDay = 0;

	}

	public void showVignettesForSale() {
		// TODO
	}
	
	
	public void showAvailableVignettes() {
		// TODO
		for(int i = 0; i < this.vignettes.length; i++){
			if(this.vignettes[i] != null){
				System.out.println(this.vignettes[i]);
			}
		}
	}

	public Vignette sellVignette(int price) {
		this.moneyForTheDay += price;
		Vignette v = this.searchVignette(price);
		if(v == null){
			System.out.println("Sorry, we don't have this kind of vignette");
		}
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


	public Vignette searchVignette(int price) {
		// TODO
		int start = 0;
		int end = this.vignettes.length - 1;
		Vignette searchedVignette;
		
		while (end >= start) {
			int middle = (start + end) / 2;
			if (this.vignettes[middle].getPrice() == price) {
				searchedVignette = this.vignettes[middle];
				this.vignettes[middle] = null;
				this.sortVignettes();
				return searchedVignette;
			}
			if (this.vignettes[middle].getPrice() < price) {
				start = middle + 1;
			}
			if (this.vignettes[middle].getPrice() > price) {
				end = middle - 1;
			}
		}
		return null;
	}


	public void sortVignettes() {
		// TODO
		quickSort(0, this.vignettes.length);
		
	}
			
	private void quickSort(int left, int right) {
		if (left >= right) {
			return;
		}
		int k = this.partition(left, right);
		quickSort(left, k-1);
		quickSort(k+1, right);
	}

	private int partition(int left, int right) {
		
		int pivot = this.vignettes[right].getPrice();
		int k = left-1;
		for (int i = left; i <= right; i++) {
			if (this.vignettes[i].getPrice() <= pivot) {
				k++;
				swap(k, i);
			}
		}
		return k;
	}
	
	private void swap(int x, int y) {
		Vignette temp = this.vignettes[x];
		this.vignettes[x] = this.vignettes[y];
		this.vignettes[y] = temp;
		temp = null;
	}
}

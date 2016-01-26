package vignetteTask;

public class Bus extends Vehicle {

	@Override
	protected void randomCreating() {
		
		int r = (int)(Math.random()*3 +1);
		switch(r){
			case 1: super.setModel("Mercedes");
					break;
			case 2: super.setModel("Karus");
					break;
			case 3: super.setModel("Chavdarche");
					break;
		}
		
		super.setYearOfProduction(this.randomYearBetween(1950, 2009));
	}
		
	private int randomYearBetween(int start, int end) {
		return start + (int)Math.round(Math.random() * (end - start));
	}
}

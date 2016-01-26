package vignetteTask;

public class Car extends Vehicle {

	@Override
	protected void randomCreating() {
		
		int r = (int)(Math.random()*3 +1);
		switch(r){
			case 1: super.setModel("Opel");
					break;
			case 2: super.setModel("Reno");
					break;
			case 3: super.setModel("Ford");
					break;
		}
		
		super.setYearOfProduction(this.randomYearBetween(1950, 2015));
	}
		
	private int randomYearBetween(int start, int end) {
		return start + (int)Math.round(Math.random() * (end - start));
	}

}

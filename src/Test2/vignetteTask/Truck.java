package vignetteTask;

public class Truck extends Vehicle {
	
	@Override
	protected void randomCreating(){

		int r = (int)(Math.random()*3 +1);
		switch(r){
			case 1: super.setModel("Tir");
					break;
			case 2: super.setModel("Golqm");
					break;
			case 3: super.setModel("Man");
					break;
		}
		
		super.setYearOfProduction(this.randomYearBetween(1950, 2015));
	}
	
	private int randomYearBetween(int start, int end) {
		return start + (int)Math.round(Math.random() * (end - start));
	}

	
	
}

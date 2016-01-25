package musicFestival;

public class Player extends Musician{

	private String playOn;
	
	Player(String name, String playOn) {
		super(name);
		if(this.playOn != playOn){
			this.playOn = playOn;
		}
	}
	
	@Override
	public String toString() {
		return super.getName() + ": " + this.playOn;
	}

	
	

	
}

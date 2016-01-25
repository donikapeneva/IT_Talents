package musicFestival;

public class Vocal extends Musician {

	Vocal(String name) {
		super(name);
		
	}
	
	public void sing(Song song){
		System.out.println(song.getText());
	}

	
}

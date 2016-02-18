package musicFestival;

public abstract class Musician {

	private String name;
	
	Musician(String name){
		if(name != null){
			this.name = name;
		}
	}
	
	public String getName(){
		return this.name;
	}
}

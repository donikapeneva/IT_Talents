package musicFestival;

public class Group {

	private String name;
	private Song[] song;
	private Musician[] musician;
	private int freePlacesForMembers;
	private int freePlacesForSongs;
	
	private static double durationOnStage;
	
	
	Group(String name, int members, int numberOfSongs){
		if(name != null && members != 0 && numberOfSongs != 0){
			this.name = name;
			this.musician = new Musician[members];
			this.song = new Song[numberOfSongs];
			this.freePlacesForMembers = musician.length;
			this.freePlacesForSongs = song.length;
		}
		
	}

	public void addMusician(Musician musician){
		if(musician != null && freePlacesForMembers > 0){
			this.musician[--freePlacesForMembers] = musician;
		}
	}
	
	public void addSong(Song song){
		if(song != null && freePlacesForSongs > 0){
			this.song[--freePlacesForSongs] = song;
			durationOnStage += song.getDuration();
		}
	}
	
	public double getDurationOnStage(){
		return durationOnStage;
	}
	
	
	@Override
	public String toString() {
		return this.name;
	}
}

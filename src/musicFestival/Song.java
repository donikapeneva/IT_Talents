package musicFestival;

public class Song {
	
	private String title;
	private String text;
	private  double duration;
	
	Song(String title, double duration){
		
		if(title != null){
			this.title = title;
		} else {
			this.title = "";
		}
		this.text = "";
		if(duration != 0){
			this.duration = duration;
		} else{ 
			this.duration = 3;
		}
		
	}
	
	public void setText(String text){
		this.text = text;
	}
	
	public String getText(){
		return this.text;
	}
	
	public double getDuration(){
		return this.duration;
	}
	
	@Override
	public String toString() {
		return this.title;
	}
	
	

}

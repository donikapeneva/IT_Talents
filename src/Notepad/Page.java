package Notepad;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Page {

	private String title;
	private String text;
	
	Page(){
		this.title = "";
		this.text = new String();
	}
	
	public void addText(String text){
		if(text != null){
			this.text = this.text + text;
		}
	}
	
	public void deleteText(){
		this.text = "";
	}
	
	@Override
	public String toString() {
		return this.title + "\n" + this.text + "\n----------------";
	}
	
	public void changeTitle(String newTitle){
		this.title = newTitle;
	}
	
	public boolean searchWord(String word){
		
		Pattern p = Pattern.compile("\\b" + word.trim() + "\\b");
		Matcher m = p.matcher(this.text);
		
		return m.find();
	}
	
	public boolean containsDigits(){
		
		Pattern p = Pattern.compile("\\d");
		Matcher m = p.matcher(this.text);
		
		return m.find();
		
	}
}

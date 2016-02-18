package Notepad;

public class ElectronicSecuredNotepad extends SecuredNotepad implements IElectronicDevice{

	private boolean isStarted;

	ElectronicSecuredNotepad(int numberOfPages) {
		super(numberOfPages);
		start();
		System.out.println("This is electronic notebook");
		System.out.println("Your notebook is turned on");
	}

	@Override
	public void addTextToPage(String text, int pageNumber) {
		if(isStarted()){
			super.addTextToPage(text, pageNumber);
		}
	}
	
	@Override
	public void replceTextOnPage(String text, int pageNumber) {
		if(isStarted()){
			super.replceTextOnPage(text, pageNumber);
		}
	}
	
	@Override
	public void deleteTextOnPage(int pageNumber) {
		if(isStarted()){
			super.deleteTextOnPage(pageNumber);
		}	
	}
	
	@Override
	public void start() {
		this.isStarted = true;
	}

	@Override
	public void stop() {
		this.isStarted = false;
	}

	@Override
	public boolean isStarted() {
		if(!this.isStarted) {
			System.out.println("\nYour notebook is turned off");
		}
		return this.isStarted;
	}

}

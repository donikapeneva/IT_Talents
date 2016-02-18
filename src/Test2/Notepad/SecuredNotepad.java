package Notepad;

import java.util.Scanner;

public class SecuredNotepad extends SimpleNotepad implements ISecuredNotepad {

	private String pass;

	SecuredNotepad(int numberOfPages) {
		super(numberOfPages);
		System.out.println("\n*****");
		System.out.println("Creating a secured notepad");
		createPass();
	}
	
	@Override
	public void addTextToPage(String text, int pageNumber) {
		System.out.println("\nTo add a text on page " + pageNumber + " confirm your password");
		if (validatePass()) {
			super.addTextToPage(text, pageNumber);
			System.out.println("Text added");
		}
	}

	@Override
	public void replceTextOnPage(String text, int pageNumber) {
		System.out.println("\nTo replace the text on page " + pageNumber + " confirm your password");
		if (validatePass()) {
			super.replceTextOnPage(text, pageNumber);
			System.out.println("Text replaced");
		}
	}
	
	@Override
	public void deleteTextOnPage(int pageNumber) {
		System.out.println("\nTo delete the text on page " + pageNumber + " confirm your password");
		if (validatePass()) {
			super.deleteTextOnPage(pageNumber);
			System.out.println("Text deleted");
		}
	}
	
	@Override
	public void showPages() {
		System.out.println("\nTo show pages confirm your password ");
		if(validatePass()){
			super.showPages();
		}
	}
	
	private void createPass() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Create a strong password: ");
		System.out.println("/It must contains at least one digit, one upercase, one lowercase, one special sign, and be longer than 5 symbols/");
		this.pass = sc.next().trim();
		
		if(!detectSpecialSigns(this.pass)){
			throw new IllegalArgumentException("\nYour password is not strong enough\n");
		}
		
		System.out.println("Confirm your password: ");
		if (this.pass.equals(sc.next())) {
			System.out.println("Successfully created secured notepad \n");
		} else {
			System.out.println("Try again...");
		}
	}
	
	private boolean detectSpecialSigns(String pass){
		String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=.*\\S+$).{5,10}";
		return pass.matches(pattern);
	}

	protected boolean userValidation() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a password: ");
		if (!this.pass.equals(sc.next())) {
			System.out.println("Wrong password...");
			return false;
		} else {
			return true;
		}
	}

	//ne znam tochno kak da kapsuliram po dobre dannite
	@Override
	public boolean validatePass() {
		return userValidation();

	}

}

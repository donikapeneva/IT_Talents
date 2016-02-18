package Notepad;


public class Demo {

	public static void main(String[] args) {
		
		SimpleNotepad simpleNotepad = new SimpleNotepad(5);
		simpleNotepad.addTextToPage("Zdrasti", 1);
		simpleNotepad.addTextToPage("Chao1", 2);
		simpleNotepad.addTextToPage("Doni", 1);
		simpleNotepad.replceTextOnPage("Dai pari za pasti", 2);
	//	simpleNotepad.deleteTextOnPage(2);
		simpleNotepad.addTextToPage("Hell0", 3);
		simpleNotepad.showPages();
		
	//	simpleNotepad.printAllPagesWithDigits();
		simpleNotepad.searchWord("za");
		
		
//		SecuredNotepad secured = new SecuredNotepad(3);
//		secured.addTextToPage("qwerty", 1);
//		secured.addTextToPage("qwe", 2);
//		secured.replceTextOnPage("123", 2);
//		secured.showPages();
//		
		ElectronicSecuredNotepad electronic = new ElectronicSecuredNotepad(3);
		electronic.addTextToPage("Vremeto", 1);
		electronic.addTextToPage("e", 2);
		electronic.stop();
		electronic.addTextToPage("toplo", 3);
		
	}
}

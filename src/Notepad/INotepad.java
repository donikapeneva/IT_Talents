package Notepad;

public interface INotepad {

	void addTextToPage(String text, int pageNumber);
	void replceTextOnPage(String text, int pageNumber);
	void deleteTextOnPage(int pageNumber);
	void showPages();
	void searchWord(String word);
	void printAllPagesWithDigits();
	
}

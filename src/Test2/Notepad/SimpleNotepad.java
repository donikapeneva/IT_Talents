package Notepad;

public class SimpleNotepad implements INotepad {

	private Page[] pages;

	SimpleNotepad(int numberOfPages) {
		if (numberOfPages > 0) {
			this.pages = new Page[numberOfPages];
		} else {
			this.pages = new Page[10];
		}

		for (int i = 0; i < pages.length; i++) {
			pages[i] = new Page();

		}
	}

	@Override
	public void addTextToPage(String text, int pageNumber) {
		if (validatePage(pageNumber)) {
			this.pages[pageNumber - 1].addText(text);
		}
	}

	@Override
	public void replceTextOnPage(String text, int pageNumber) {
		if (validatePage(pageNumber)) {
			this.pages[pageNumber - 1].deleteText();
			this.pages[pageNumber - 1].addText(text);
		}
	}

	@Override
	public void deleteTextOnPage(int pageNumber) {
		if (validatePage(pageNumber)) {
			this.pages[pageNumber - 1].deleteText();
		}
	}

	@Override
	public void showPages() {
		for (int i = 0; i < pages.length; i++) {
			System.out.println("Page " + (i + 1) + " " + pages[i]);
		}
	}

	private boolean validatePage(int pageNumber) {
		if (pageNumber > 0 && pageNumber <= pages.length) {
			return true;
		} else {
			System.out.println("Invalid page number");
			return false;
		}
	}

	@Override
	public void searchWord(String word) {
		int matches = 0;
		for (int i = 0; i < pages.length; i++) {
			if (pages[i].searchWord(word)) {
				matches++;
			}
		}
		System.out.println("Searching for: " + word + "\nMatches: " + matches);
	}

	@Override
	public void printAllPagesWithDigits() {
		for (int i = 0; i < pages.length; i++) {
			if (pages[i].containsDigits()) {
				System.out.println("Page " + (i + 1) + pages[i]);
			}
		}
	}
}

package lawyer;

public class Judge extends LegalEntity{

	
	Judge(String name, int staj, int numberOfCases) {
		super(name);
		if(staj < 5){
			System.out.println("Ne moje da e sudiq");
		} else {
			super.staj = staj;
		}
		super.numberOfCases = numberOfCases;
	}

	
	@Override
	public void askQuestions(Citizen citizen) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writeNotes() {
		// TODO Auto-generated method stub
		
	}


}

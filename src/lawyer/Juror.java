package lawyer;

public class Juror extends LegalEntity{

	Juror(String name, int staj, int numberOfCases) {
		super(name);
		super.staj = staj;
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

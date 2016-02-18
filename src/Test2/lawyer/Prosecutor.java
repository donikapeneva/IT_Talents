package lawyer;

public class Prosecutor extends LegalEntity {

	Prosecutor(String name, int staj, int numberOfCases) {
		super(name);
		if(staj  < 10){
			super.staj = staj;
		} else {
			System.out.println("Ne moje da byde prokuror");
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

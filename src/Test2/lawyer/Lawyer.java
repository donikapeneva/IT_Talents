package lawyer;

public class Lawyer extends LegalEntity{

	Lawyer(String name, int staj, int numberOfCases){
		super(name);
		super.staj = staj;
		if(numberOfCases < 10){
			System.out.println("This guy cannot be a lawyer");
		} else {
			super.numberOfCases = numberOfCases;
		}
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

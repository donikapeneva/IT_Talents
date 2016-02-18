package lawyer;

public class CriminalCase extends Case{

	Prosecutor accuser;
	
	CriminalCase(boolean isCriminal, Judge judge, Defendant defendant, Prosecutor accuser) {
		super(isCriminal, judge, defendant);
		this.accuser = accuser;
	}

	@Override
	void askQuestions() {
		
		this.accuser.numberOfCases++;
		
		for(int i = 0; i < 5; i++){
			this.accuser.askQuestions(super.defendant);
			this.accuser.writeNotes();
		}
		
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < super.witness.length; j++){
				this.accuser.askQuestions(super.witness[j]);
				this.accuser.writeNotes();
			}
		}
		
	}

	
}

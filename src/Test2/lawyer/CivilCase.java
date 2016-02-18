package lawyer;

public class CivilCase extends Case {

	Accuser accuser;

	CivilCase(boolean isCriminal, Judge judge, Defendant defendant, Accuser accuser) {
		super(isCriminal, judge, defendant);
		this.accuser = accuser;
	}

	@Override
	void askQuestions() {
		
		for(int i = 0; i < accuser.layer.length; i++){
			
		}
		
		
//		for (int i = 0; i < 5; i++) {
//			this.accuser.lawyer
//			//askQuestions(super.defendant);
//			this.accuser.writeNotes();
//		}
//
//		for (int i = 0; i < 5; i++) {
//			for (int j = 0; j < super.witness.length; j++) {
//				this.accuser.askQuestions(super.witness[j]);
//				this.accuser.writeNotes();
//			}
//		}

	}

}

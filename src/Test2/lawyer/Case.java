package lawyer;

public abstract class Case {
	Judge judge;
	Juror[] juror;
	Defendant defendant;
	Witness[] witness;
	
	
	Case(boolean isCriminal, Judge judge, Defendant defendant){
		this.juror = isCriminal ? new Juror[13] : new Juror[3];
		this.judge = judge;
		this.defendant = defendant;
	}
	
	void conduct(){
		this.judge.numberOfCases++;
		for(int i = 0; i < this.juror.length; i++){
			this.juror[i].numberOfCases++;
		}
		for(int i = 0; i < this.defendant.lawyer.length; i++){
			this.defendant.lawyer[i].numberOfCases++;
		}
		
		askQuestions();
		
		for(int i = 0; i < this.defendant.lawyer.length; i++){
			for(int question = 0; question < 5; question++){
				for(int j = 0; j < this.witness.length; j++){
					this.defendant.lawyer[i].askQuestions(witness[j]);
					this.defendant.lawyer[i].writeNotes();
				}
			}
		}
		
	}
		
	abstract void askQuestions();
}

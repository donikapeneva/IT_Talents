package lawyer;

public abstract class LegalEntity implements ILegalEntity{

	String name;
	int staj;
	int numberOfCases;
	
	LegalEntity(String name) {
		this.name = name;
	}
	
	
}

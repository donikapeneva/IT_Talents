package vignetteTask;

import java.time.LocalDate;
import java.time.Period;

public abstract class Vignette {

	public static final String VALID_FOR_WEEK = "week";
	public static final String VALID_FOR_MONTH = "month";
	public static final String VALID_FOR_YEAR = "year";
	
	private LocalDate dateOfIssue;
	private LocalDate limitation; // the date till the vignette is valid
	private int price;
	
	public Vignette(String period){
		this.dateOfIssue= LocalDate.now();
		this.setPeriod(period);
	}
	
	protected void setPeriod(String period){
		switch (period){
		case VALID_FOR_WEEK: this.limitation = this.dateOfIssue.plus(Period.ofDays(7));
		break;
		case VALID_FOR_MONTH: this.limitation = this.dateOfIssue.plus(Period.ofMonths(1));
		break;
		case VALID_FOR_YEAR: this.limitation = this.dateOfIssue.plus(Period.ofYears(1));
		break;
		}
	}
	
	protected void setPrice(String period, int price){
		switch (period){
		case VALID_FOR_WEEK: this.price = price;
		break;
		case VALID_FOR_MONTH: this.price = price * 10;
		break;
		case VALID_FOR_YEAR: this.price = (price * 10) * 6;
		break;
		}
	}
	
	public abstract int putOnWindow(Vehicle vehicle); // returns how much seconds do we need to put the vignette on the window
	
	public int getPrice(){
		return this.price;
	}
	
	@Override
	public String toString() {
		
		return " " + this.price;
	}
	
}

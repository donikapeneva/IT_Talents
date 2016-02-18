package musicShop;

public class Customer extends Thread {

	private String name;
	private Shop shop;
	
	public Customer(String name, Shop shop) {
		this.name = name; 
		this.shop = shop;
	}
	
	public void makeOrder(Instrument instrument, int quantity){
		this.shop.makeOrder(instrument, quantity);
		this.buyInstrument(instrument, quantity);
	}
	
	public void buyInstrument(Instrument instrument, int quantity){
		this.shop.sellInstrument(instrument, quantity);
	}
	
	@Override
	public void run() {
		
		int count = 0;
		while(count++ < 10){
			
//			random for instrument & quantity, primerno
//			buyInstrument(instrument, quantity);
			
		}
		
	}
	
	
	public String getNameOfCustomer(){
		return this.name;
	}
	
	public Shop getShop(){
		return this.shop;
	}
}

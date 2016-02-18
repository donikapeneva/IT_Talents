package musicShop;

import java.util.Map;

public class Supplier extends Thread{

	private String name;
	private Shop shop;
	
	public Supplier(String name, Shop shop) {
		this.name = name;
		this.shop = shop;
	}
	
	public void supplyInstrument(){
		Instrument customInstrument = null;
		int quantity = 0;
		for(Map.Entry<Instrument, Integer> instrument : shop.getCustomerWishes().entrySet()){
			customInstrument = instrument.getKey();
			quantity = instrument.getValue();
		}
		
		try {
			Thread.sleep(customInstrument.getDeliveryTime());
			System.out.println(customInstrument.getName() + " has been delivered");
		} catch (InterruptedException e) {
			System.out.println("Something went wrong with the order");
			return;
		}
		this.shop.makeOrder(customInstrument, quantity);
	}
	
	
	
	@Override
	public void run() {
		
		this.supplyInstrument();
		
	}
	
	public Shop getShop(){
		return this.shop;
	}
	
	public void setShop(Shop shop){
		this.shop = shop;
	}
	
	
}

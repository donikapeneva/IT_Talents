package musicShop;

public abstract class Instrument {

	private String name;
	private double price;
	private int deliveryTime;
	
	public Instrument(String name, double price, int deliveryTime) {
		this.name = name;
		this.price = price;
		this.deliveryTime = deliveryTime;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}

	public int getDeliveryTime() {
		return this.deliveryTime;
	}
	
	
}

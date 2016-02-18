package musicShop;

public class MonthlySupplier extends Supplier{

	public MonthlySupplier(String name, Shop shop) {
		super(name, shop);
	}

	
	public void supplyGoods(){
		super.getShop().supply();
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			System.out.println("Maybe the supplier wont work anymore");
		}
		this.supplyGoods();
		
	}
	
}

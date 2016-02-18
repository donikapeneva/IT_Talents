package musicShop;

import java.io.IOException;

import musicShop.intruments.Duhov;
import musicShop.intruments.Elektronen;
import musicShop.intruments.Klavishen;
import musicShop.intruments.Strunen;
import musicShop.intruments.Udaren;

public class Demo {

	public static void main(String[] args) {
		
		Shop trick = new Shop("Trick");
		
		Instrument cigulka = new Strunen("cigulka", 180);
		Instrument kitara = new Strunen("kitara", 80);
		Instrument gudulka = new Strunen("gudulka", 100);
		Instrument tambura = new Strunen("tambura", 120);
		Instrument barabani = new Udaren("barabani", 1000);
		Instrument tarambuka = new Udaren("tarambuka", 20);
		Instrument fleita = new Duhov("fleita", 200);
		Instrument kaval = new Duhov("kaval", 90);
		Instrument saksofon = new Duhov("saksofon", 250);
		Instrument piano = new Klavishen("piano", 2000);
		Instrument akordeon = new Klavishen("akordeon", 200);
		Instrument sintezator = new Elektronen("sintezator", 1500);
		Instrument elKitara = new Elektronen("elektricheska kitara", 240);
		Instrument elCigulka = new Elektronen("elektricheska cigulka", 280);
		
		
		trick.makeOrder(cigulka, 10);
		trick.makeOrder(kitara, 10);
		trick.makeOrder(gudulka, 10);
		trick.makeOrder(tambura, 10);
		trick.makeOrder(barabani, 10);
		trick.makeOrder(tarambuka, 10);
		trick.makeOrder(fleita, 10);		
		trick.makeOrder(kaval, 10);		
		trick.makeOrder(saksofon, 10);
		trick.makeOrder(piano, 10);	
		trick.makeOrder(akordeon, 10);	
		trick.makeOrder(sintezator, 10);	
		trick.makeOrder(elKitara, 10);	
		trick.makeOrder(elCigulka, 10);	
		
		System.out.println("\n");
		
		try {
			trick.makeCatalog(Shop.Catalog.CATALOG_BY_NAME);
		} catch (InputException e) {
			System.out.println(e.getMessage());
		} catch (IOException e){
			System.out.println("Fail with io");
			e.printStackTrace();
		}
		
		try {
			trick.showCatalog(Shop.Catalog.CATALOG_BY_PRICE_ASCENDING);
		} catch (IOException | InputException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n");
		
		trick.sellInstrument(barabani, 1);
		trick.sellInstrument(fleita, 1);
		
		Thread dostavchik = new Supplier("Dostavchik", trick);
		// tova neshto si poruchva samo saksofoni?? 
		dostavchik.start();
		Thread mesechenDostavchik = new MonthlySupplier("Mesechen dostavchik", trick);;
		mesechenDostavchik.start();
		
		Customer pesho = new Customer("Pesho", trick);
		pesho.start();
		pesho.buyInstrument(fleita, 9);
		pesho.buyInstrument(fleita, 2);
		pesho.makeOrder(fleita, 5);
		
	}
}

package musicShop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import musicShop.intruments.Duhov;
import musicShop.intruments.Elektronen;
import musicShop.intruments.Klavishen;
import musicShop.intruments.Strunen;
import musicShop.intruments.Udaren;

public class Shop {

	private String name;
	private Map<Instrument, Integer> goods;
	private Map<Instrument, Integer> sold;
	private Map<Instrument, Integer> customerWishes;
	private static final int DELIVERY_QUANTITY = 10;
	private double money;

	public enum Catalog {
		CATALOG_BY_KIND_OF_INSTRUMENT, CATALOG_BY_NAME, CATALOG_BY_PRICE_ASCENDING, CATALOG_BY_PRICE_DESCENDING, CATALOG_BY_AVAILABILITY
	}

	public Shop(String name) {
		this.name = name;
		
		this.goods = new HashMap<>();
		this.sold = new HashMap<>();
		this.customerWishes = new HashMap<Instrument, Integer>(1);
		
		
	}

	
	
	
	
	//TODO 
	public void doSpravka(){
		
	}
	
	
	public synchronized void sellInstrument(Instrument instrument, int quantity) {
		if (this.hasInstrument(instrument, quantity)) {
			this.money += instrument.getPrice() * quantity;
			this.goods.put(instrument, this.goods.get(instrument) - quantity);
			
			if(this.sold.containsKey(instrument)){
				this.sold.put(instrument, this.sold.get(instrument) + quantity);
			} else {
				this.sold.put(instrument, quantity);
			}
			System.out.println(instrument.getName() + " has been sold");
			notifyAll();
		} else {
			System.out.println("You should wait for suply?");
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("Something interrupted...");
			}
		}
	}
	
	private boolean hasInstrument(Instrument instrument, int quantity){
	
		if(this.goods.containsKey(instrument)){
			if(this.goods.get(instrument) >= quantity){
				return true;
			} else {
				System.out.println("We don't have " + quantity + " " + instrument.getName()); 
			}
		} else {
			System.out.println("We don't have " + instrument.getName());
		}
		return false;
	}
	
	public synchronized void supply() {
		if(this.getMissingInstruments().size() <= 0){
			this.fill(this.getMissingInstruments());
			System.out.println("No more missing instruments");
		}
		System.out.println("The deliver has been done");
		notifyAll();
		try {
			wait();
		} catch (InterruptedException e) {
			System.out.println("Something interrupted.. may the supliyer is a quiter ??");
		}
	}
	
	private void fill(HashSet<Instrument> missingInstruments) {
		for(Instrument instrument : missingInstruments){
			if (this.goods.containsKey(instrument)) {
				this.goods.put(instrument, this.goods.get(instrument) + DELIVERY_QUANTITY);
			} else {
				this.goods.put(instrument, DELIVERY_QUANTITY);
			}
		}
	}
	
	private HashSet<Instrument> getMissingInstruments(){
		HashSet<Instrument> missingInstruments = new HashSet<>();
		for(Map.Entry<Instrument, Integer> instrument : this.goods.entrySet()){
			if(instrument.getValue() > 0){
				continue;
			} else { 
				missingInstruments.add(instrument.getKey());
			}
		}
		return missingInstruments;
	}
	
	public synchronized void makeOrder(Instrument instrument, int quantity){
		System.out.println("An order for " + instrument.getName() + " has been made");
		this.setCustomerWishes(instrument, quantity);
		if(this.goods.containsKey(instrument)){
			this.goods.put(instrument, this.goods.get(instrument) + quantity);
		}else { 
			this.goods.put(instrument, quantity);
		}
		notifyAll();
		
		// ako pusnem custumer kato nishka => wait()
		
	}
	
	private void setCustomerWishes(Instrument instrument, int quantity){
		this.customerWishes.remove(0);
		this.customerWishes.put(instrument, quantity);
	}
	
	public Map<Instrument, Integer> getCustomerWishes(){
		return  this.customerWishes;
	}

	public void showCatalog(Catalog catalog) throws IOException, InputException {
		File catalogFile;

		switch (catalog) {
		case CATALOG_BY_KIND_OF_INSTRUMENT:
			catalogFile = new File("catalogByInstrument.txt");
			break;
		case CATALOG_BY_NAME:
			catalogFile = new File("catalogByName.txt");
			break;
		case CATALOG_BY_PRICE_ASCENDING:
			catalogFile = new File("catalogByPriceAscending.txt");
			break;
		case CATALOG_BY_PRICE_DESCENDING:
			catalogFile = new File("catalogByPriceDescending.txt");
			break;
		case CATALOG_BY_AVAILABILITY:
			catalogFile = new File("catalogByAvailability.txt");
		default:
			throw new InputException("Please, enter an existing catalog");
		}

		if (!catalogFile.exists()) {
			this.makeCatalog(catalog);
		}

		BufferedReader catalogReader = new BufferedReader(new FileReader(catalogFile));
		String line = "";
		while ((line = catalogReader.readLine()) != null) {
			System.out.println(line);
		}
		catalogReader.close();
	}

	public void makeCatalog(Catalog catalog) throws IOException, InputException  {
		File catalogFile;
		Map<Instrument, Integer> instrumentToCatalog;
		String catalogTitle = "";

		switch (catalog) {
		default:
			throw new InputException("Please, enter an existing catalog");
		case CATALOG_BY_KIND_OF_INSTRUMENT:
			catalogFile = new File("catalogByInstrument.txt");
			instrumentToCatalog = this.goods;
			catalogTitle = "instrument (not sorted at all)";
			break;
		case CATALOG_BY_NAME:
			catalogFile = new File("catalogByName.txt");
			instrumentToCatalog = sortCatalogByName();
			catalogTitle = "name";
			break;
		case CATALOG_BY_PRICE_ASCENDING:
			catalogFile = new File("catalogByPriceAscending.txt");
			instrumentToCatalog = sortCatalogByPrice(true);
			catalogTitle = "price (ascending)";
			break;
		case CATALOG_BY_PRICE_DESCENDING:
			catalogFile = new File("catalogByPriceDescending.txt");
			instrumentToCatalog = sortCatalogByPrice(false);
			catalogTitle = "price (descending)";
			break;
		case CATALOG_BY_AVAILABILITY:
			catalogFile = new File("catalogByAvailability.txt");
			instrumentToCatalog = sortCatalogByAvailability();
			catalogTitle = "availability";
		}

		if (!catalogFile.exists()) {
			catalogFile.createNewFile();
		}

		try(BufferedWriter catalogWriter = new BufferedWriter(new FileWriter(catalogFile))){

			String title = String.format("------ Catalog by %s ------ ", catalogTitle);
			catalogWriter.write(title);
			catalogWriter.newLine();

			for (Map.Entry<Instrument, Integer> instrument : instrumentToCatalog.entrySet()) {
				catalogWriter.write("name: " + instrument.getKey().getName() + ", price: "
						+ instrument.getKey().getPrice() + ", quantity: " + instrument.getValue());
				catalogWriter.newLine();
			}
			catalogWriter.close();
		} catch (IOException e){
			System.out.println("Something went wrong with the file");
		}
}

	private Map<Instrument, Integer> sortCatalogByName() {

		// sortirane na map-a po name
		List<Map.Entry<Instrument, Integer>> listOfInstruments = new ArrayList<>(this.goods.entrySet());

		Collections.sort(listOfInstruments,
				(firstEntry, secondEntry) -> firstEntry.getKey().getName().compareTo(secondEntry.getKey().getName()));

		Map<Instrument, Integer> sortedInstruments = new LinkedHashMap<Instrument, Integer>();

		for (Map.Entry<Instrument, Integer> entry : listOfInstruments) {
			sortedInstruments.put(entry.getKey(), entry.getValue());
		}

		return sortedInstruments;
	}

	private Map<Instrument, Integer> sortCatalogByPrice(boolean isAscending) {

		// sortirane na map-a po price
		List<Map.Entry<Instrument, Integer>> listOfInstruments = new ArrayList<>(this.goods.entrySet());

		Comparator<Map.Entry<Instrument, Integer>> byPrice;
		if (isAscending) {
			byPrice = (instrument1, instrument2) -> instrument1.getKey().getPrice()
					.compareTo(instrument2.getKey().getPrice());
		} else {
			byPrice = (instrument1, instrument2) -> instrument2.getKey().getPrice()
					.compareTo(instrument1.getKey().getPrice());
		}

		Collections.sort(listOfInstruments, byPrice);

		Map<Instrument, Integer> sortedInstruments = new LinkedHashMap<Instrument, Integer>();

		for (Map.Entry<Instrument, Integer> entry : listOfInstruments) {
			sortedInstruments.put(entry.getKey(), entry.getValue());
		}

		return sortedInstruments;
	}

	private Map<Instrument, Integer> sortCatalogByAvailability() {

		// sortirane na map-a po nalichnost
		List<Map.Entry<Instrument, Integer>> listOfInstruments = new ArrayList<>(this.goods.entrySet());

		Collections.sort(listOfInstruments,
				(firstEntry, secondEntry) -> firstEntry.getValue().compareTo(secondEntry.getValue()));

		Map<Instrument, Integer> sortedInstruments = new LinkedHashMap<Instrument, Integer>();

		for (Map.Entry<Instrument, Integer> entry : listOfInstruments) {
			sortedInstruments.put(entry.getKey(), entry.getValue());
		}

		return sortedInstruments;
	}

	public String getName() {
		return this.name;
	}


}

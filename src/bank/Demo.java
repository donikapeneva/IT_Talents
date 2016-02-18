package bank;

import java.util.ArrayList;
import java.util.List;

// Може ли feedback за използването на exception-ите :)
public class Demo {

	public static void main(String[] args) {
		
		Bank bank = new Bank("Bulgarska banka", "ul. Stamboliiski", 100_000);
		
		List<Client> clients = new ArrayList<Client>();
		clients.add(new Client("Ivan", "", 200, 500));
		clients.add(new Client("Drago", "", 500, 1000));
		clients.add(new Client("Liubo", "", 7000, 700));
		clients.add(new Client("Simo", "", 2000, 600));
		clients.add(new Client("Gosho", "", 520, 450));
		clients.add(new Client("Pesho", "", 1000, 350));
		clients.add(new Client("Stefan", "", 800, 520));
		clients.add(new Client("Purvan", "", 80, 600));
		clients.add(new Client("Qvor", "", 200, 900));
		clients.add(new Client("Dimitur", "", 300, 1000));
		
		
		for(Client client : clients){
			int randomDeposit = (int) (Math.random() * 2 + 1) ;
			if(randomDeposit == 1){
				client.makeDeposit(randomMoneyToDeposit(client.getMoney()), bank, new BankAccount.Deposit("Short Deposit", 3, 3));
			} else { 
				client.makeDeposit(randomMoneyToDeposit(client.getMoney()), bank, new BankAccount.Deposit("Long Deposit", 5, 12));
			}
		}
		
		
//		8. След това да се изпише паричната наличност на банката както и нейния паричен	резерв.
		
		bank.payAllInterests();
		System.out.println();
		System.out.println(bank);
		
		
//		9. Всеки един от тези клиенти да вземе на случаен принцип кредити от банката.
		
		for(Client client : clients){
			int r = (int)(Math.random()*2 + 1);
			double randomSum = Math.random() * 1500 + 1;
			if(r == 1){
				client.takeCredit(randomSum, bank, new BankAccount.Credit("Home Credit", 6), randomPeriodForCredit());
			} else {
				client.takeCredit(randomSum, bank, new BankAccount.Credit("Cunsumer Credit", 10), randomPeriodForCredit());
			}
		}
		
		
//		10. Да се изпишат информация (всички свойства) за всички клиенти, всички депозити,
//		всички отпуснати кредити и информация за състоянието на банката.
		
		System.out.println("\n********-clients-********");
		for(Client client : clients){
			System.out.println(client);
		}
	
		System.out.println("\n********-bank-********");
		System.out.println(bank);
		
	}
	
	public static double randomMoneyToDeposit(double money){
		int min = 80;
		int max = 100;
		int randomPercentage = (min + (int)(Math.random() * ((max - min) + 1)));
		return money * randomPercentage / 100;
	}
	
	private static int randomPeriodForCredit(){
		int min = 5;
		int max = 60;
		return min + (int)(Math.random() * ((max - min) + 1));
		
	}
}

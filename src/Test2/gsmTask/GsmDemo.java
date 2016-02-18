package gsmTask;

public class GsmDemo {

	public static void main(String[] args) {
		GSM gsm1 = new GSM();
		GSM gsm2 = new GSM();
		
		gsm1.insertSimCard("0888888888");
		gsm2.insertSimCard("0899999999");

		gsm1.model = "Sony";
		gsm2.model = "LG";

		gsm1.call(gsm2, 3);
		gsm1.printInfoForTheLastIncomingCall();
		gsm1.printInfoForTheLastOutgoingCall();
		gsm2.printInfoForTheLastIncomingCall();
		gsm2.printInfoForTheLastOutgoingCall();
		System.out.println(gsm1.getSumForCall());

	}

}

package gsmTask;

public class GSM {

	String model;
	boolean hasSimCard;
	String simMobileNumber;
	int outgoingCallsDuration;
	Call lastIncomingCall ;
	Call lastOutgoingCall ;

	void insertSimCard(String newSimMobileNumber) {
		if (newSimMobileNumber.matches("(08)[0-9]{8}")) {
			simMobileNumber = newSimMobileNumber;
			hasSimCard = true;
		}
	}

	void removeSimCard() {
		hasSimCard = false;
	}

	void call(GSM receiver, int duration) {
		if (duration > 0 && !simMobileNumber.equals(receiver.simMobileNumber)
				&& hasSimCard && receiver.hasSimCard) {
			Call newCall = new Call();
			newCall.duration=duration;
			newCall.receiver = receiver;
			newCall.caller = this;
			
			this.lastOutgoingCall = newCall;
			receiver.lastIncomingCall = newCall;
			this.outgoingCallsDuration+=duration;

		}
	}

	double getSumForCall() {
		return (outgoingCallsDuration * Call.priceForAMinute);
	}

	void printInfoForTheLastOutgoingCall() {
		if (lastOutgoingCall == null) {
			System.out.println("There in no outgoing call ");		
		} else {
			System.out.println("Receiver model: "
					+ lastOutgoingCall.receiver.model);
			System.out.println("Receiver number: "
					+ lastOutgoingCall.receiver.simMobileNumber);
			System.out.println("Last outgoing call duration: "
					+ lastOutgoingCall.duration);
		}
	}
	
	void printInfoForTheLastIncomingCall() {
		if (lastIncomingCall == null) {
			System.out.println("There in no incoming call ");
		} else {
			System.out.println("Caller model: "
					+ lastIncomingCall.caller.model);
			System.out.println("Caller number: "
					+ lastIncomingCall.caller.simMobileNumber);
			System.out.println("Last incoming call duration: "
					+ lastIncomingCall.duration);
		}
	}

}

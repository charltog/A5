package cs414.a5.gcharl.server;


import java.util.Date;
import java.util.HashSet;

import cs414.a5.gcharl.common.*;

public class EntryGate implements IEntryGate {

	private int Id;
	private gateStatus status;
	private Garage garage;
	private int ticketCount;
	public HashSet<Ticket> tickets = new HashSet<Ticket>();

	public EntryGate(int Id, int initialTicketCount, Garage g1) {
		this.Id = Id;
		this.ticketCount = initialTicketCount;
		this.garage = g1;
		this.status = gateStatus.Closed;
	}

	public void openEntryGate() {
		setStatus(gateStatus.Open);
	}
	
	public void closeEntryGate() {
		setStatus(gateStatus.Closed);		
	}

	public gateStatus getStatus() {
		return this.status;
	}

	private void setStatus(gateStatus status) {
		this.status = status;
	}

	public void incrementTicketCount() {
		this.ticketCount++;		
	}

	public int getTicketCount() {
		return this.ticketCount;
	}

	public Garage getGarage() {
		return this.garage;
	}

	public Ticket requestTicket()	{
		Ticket t1 = new Ticket();
		Date startTime;
		if(!this.garage.isGarageAcceptingVehicles()) {
			//Deny Entry, let t1 return as default
			//t1 = null;
		} else {			
			startTime = this.garage.getDateTime();
			t1 = new Ticket(startTime, this.ticketCount, this.garage);	
			this.incrementTicketCount();
			tickets.add(t1);
		}
		return t1;		
	}
	
	public boolean enterGarage()	{
		this.garage.increaseCurrentOccupancyByOne();
		return true;
	}
	
	public Ticket requestEntry() {
		Ticket t1 = new Ticket();
		Date startTime;
		if(!this.garage.isGarageAcceptingVehicles()) {
			//Deny Entry
		} else {			
			startTime = this.garage.getDateTime();
			t1 = new Ticket(startTime, this.ticketCount, this.garage);	
			this.incrementTicketCount();
			this.garage.increaseCurrentOccupancyByOne();
			tickets.add(t1);
		}
		return t1;
	}

	public Ticket findTicketByID(String testString) {
		Ticket t1 = new Ticket();
		for (Ticket t : garage.getEntryGate().tickets) {
			if (t.toString().equals(testString)) {
				t1 = t;
			}
		}	
	
		return t1;
	}
	
	public int findTicketID(String testString) {
		Ticket t1 = new Ticket();
		for (Ticket t : garage.getEntryGate().tickets) {
			if (t.toString().equals(testString)) {
				t1 = t;
			}
		}	
	
		return t1.getId();
	}

	public Ticket findTicketByID(int ticketId) {
		Ticket t1 = new Ticket();
		for (Ticket t : garage.getEntryGate().tickets) {
			if (t.getId() == ticketId) {
				t1 = t;
			}
		}
		return t1;
	}
	

}

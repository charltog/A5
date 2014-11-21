package cs414.a5.gcharl.server;

import java.util.HashSet;

import cs414.a5.gcharl.common.*;

public class ExitGate {

	HashSet<Sale> Sales = new HashSet<Sale>();
	private int Id;
	private Garage garage;
	private gateStatus status;
	
	public ExitGate(int id, Garage garage) {
		this.Id = id;
		this.garage = garage;
		status = gateStatus.Closed;
	}

	public HashSet<Sale> getSales() {
		// TODO Auto-generated method stub
		return Sales;
	}

	public void openExitGate() {
		setStatus(gateStatus.Open);		
	}

	public void closeExitGate() {
		setStatus(gateStatus.Closed);
	}
	
	public gateStatus getStatus() {
		return status;
	}

	private void setStatus(gateStatus status) {
		this.status = status;
	}
	
	public void exitGarage(String ticketNum)	{
		this.garage.decreaseCurrentOccupancyByOne();
		this.closeExitGate();
		//s1.getTicket().retire();		
	}

	public Sale requestExit(int ticketId) {
		Ticket t1 = this.garage.getEntryGate().findTicketByID(ticketId);
		Sale s1 = null;
		if (!t1.isValid()) {			
			//Ticket not valid, charge default fee and allow exit
//		} else if (FOP == null) {
//			// need a valid FOP 
//			s1 = createSale(t1);
//			Sales.add(s1);			
		} else {
			for (Sale s: Sales) {
				if (s.getTicket() == t1) {
					s1 = s;
				}
			} 
			if (s1 == null) {
				s1 = createSale(t1);
			}
			//Sales.add(s1);
			//Payment p1 = createPayment(s1.getTotal(), FOP);
			//confirmTotal();
			//p1.processPayment();
			//this.garage.decreaseCurrentOccupancyByOne();
			//t1.retire();
		}
		return s1;
		
	}

	private Payment createPayment(double total, FormOfPayment FOP) {
		SystemLogEvent event = new SystemLogEvent(this.garage, "Payment by " + FOP + " for " + total + " Created", ExitGate.class.getName(), this.garage.getDateTime());
		this.garage.systemLog.addLogEvent(event);
		return new Payment(total, FOP);
	}

	private Sale createSale(Ticket t1) {
		SystemLogEvent event = new SystemLogEvent(this.garage, "Sale for Ticket " + t1 + " Created", ExitGate.class.getName(), this.garage.getDateTime());
		this.garage.systemLog.addLogEvent(event);
		Sale s1 = new Sale (t1);
		Sales.add(s1);
		return s1;		
	}

	private void confirmTotal() {
		// TODO Auto-generated method stub
		
	}

	public Sale findSaleByTicketId(Ticket t1) {
		Sale s1 = null;
		for (Sale s : garage.getExitGate().Sales) {
			if (s.getTicket() == t1) {
				s1 = s;
			}
		}
		return s1;
	}

	public double makePayment(Sale s1, double payAmt, int fopCode) {
		boolean result = false;
		double changeAmt = 0.0;
		this.closeExitGate();
		FormOfPayment FOP = FormOfPayment.None;
		switch (fopCode) {
		case 1: 	FOP = FormOfPayment.Cash;
					break;
					
		case 2: 	FOP = FormOfPayment.CreditCard;
					break;
		
		}
		if (FOP==FormOfPayment.Cash || FOP == FormOfPayment.CreditCard) {
			if (this.Sales.contains(s1)) {
				double newTotal = s1.getTotal() - payAmt;
				if (newTotal <= 0.00) {
					s1.getTicket().retire();
					this.openExitGate();
					s1.setChange(Math.abs(newTotal));
				}
				s1.setTotal((double)newTotal);			
				//s1.calculateTotal();
				changeAmt = s1.getChange();				
			}			
		}		
		return changeAmt;
	}


}

package cs414.a5.gcharl.server;

import java.rmi.RemoteException;
import java.util.Date;

import cs414.a5.gcharl.common.*;

public class GarageController 
						extends java.rmi.server.UnicastRemoteObject 
						implements IParkingGarage {
	
	Garage garage;
	static int curGarageId = 1;
	

	public GarageController() 
			throws java.rmi.RemoteException {
		
        super();
        Garage g = new Garage(curGarageId);
		curGarageId ++;			
		this.garage = g;			
	}


	@Override
	public boolean createAdministrator(String adminUserName, String adminPassword) throws RemoteException {
		return garage.createAdministrator(adminUserName, adminPassword);
	}

	@Override
	public boolean administratorLogin(String adminUserName, String password)
			throws RemoteException {
		
		return garage.administratorLogin(adminUserName, password);
	}

	@Override
	public Administrator findAdminByUserName(String adminUserName) throws RemoteException {
		return garage.findAdminByUserName(adminUserName);
	}

	@Override
	public SystemLog getSystemLog() throws RemoteException {
		return garage.getSystemLog();
	}

	@Override
	public EntryGate getEntryGate() throws RemoteException {
		return garage.getEntryGate();
	}

	@Override
	public ExitGate getExitGate() throws RemoteException {
		return garage.getExitGate();
	}

	@Override
	public Date getDateTime() throws RemoteException {
		return garage.getDateTime();
	}

	@Override
	public boolean isGarageAcceptingVehicles() throws RemoteException {
		return garage.isGarageAcceptingVehicles();
	}

	@Override
	public GarageDescription viewConfig() throws RemoteException {
		return garage.viewConfig();
	}

	@Override
	public double getParkingRate() throws RemoteException {
		return garage.getParkingRate();
	}


	@Override
	public int pressGetTicket() throws RemoteException {
		return garage.pressGetTicket();
	}


	@Override
	public boolean pressEnterGarage() throws RemoteException {
		return garage.pressEnterGarage();
		
	}


//	@Override
//	public boolean updateExitTicketNum(String testString) throws RemoteException {
//		return garage.updateExitTicketNum(testString);
//	}


	@Override
	public double getSaleTotal(String ticketNum) {
		double result = 0;
		Ticket t1 = garage.getEntryGate().findTicketByID(ticketNum);
		if (t1.isValid()) {
			Sale s1 = garage.getExitGate().requestExit(t1.getId());
			result = s1.getTotal();
		}
		
		return result;
	}


	@Override
	public double makePayment(String ticketNum, double payAmt, int fopCode)
			throws RemoteException {
		return garage.makePayment(ticketNum, payAmt, fopCode);
	}


	@Override
	public String getExitGateStatus() throws RemoteException {
		return garage.getExitGateStatus();
	}


	@Override
	public boolean isValidTicket(String ticketNum) throws RemoteException {
		return garage.isValidTicket(ticketNum);
	}


	@Override
	public void exitGarage(String ticketNum) throws RemoteException {
		garage.exitGarage(ticketNum);
	}


	@Override
	public String[] getConfigValues() throws RemoteException {
		return garage.getConfigValues();
	}


	@Override
	public boolean setConfigValues(String[] configValues) throws RemoteException {
		return garage.setConfigValues(configValues);
	}


	@Override
	public boolean createEmployee(String userName, String password)
			throws RemoteException {
		return garage.createEmployee(userName, password);
	}


	@Override
	public String[] getSystemActivity() throws RemoteException {
		return garage.getSystemActivity();
	}


	@Override
	public String[] getHourlySystemActivity() throws RemoteException {
		return garage.getHourlySystemActivity();
	}



}

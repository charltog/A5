package cs414.a5.gcharl.common;

import java.util.Date;

import cs414.a5.gcharl.server.Administrator;
import cs414.a5.gcharl.server.EntryGate;
import cs414.a5.gcharl.server.ExitGate;
import cs414.a5.gcharl.server.Garage;
import cs414.a5.gcharl.server.GarageDescription;
import cs414.a5.gcharl.server.SystemLog;

public interface IParkingGarage extends java.rmi.Remote {
	
	public boolean createAdministrator(String adminUserName, String adminPassword)
                throws java.rmi.RemoteException;

	public boolean administratorLogin(String adminUserName, String password)
                throws java.rmi.RemoteException;
	
	public Administrator findAdminByUserName(String adminUserName)
            throws java.rmi.RemoteException;
	
	public SystemLog getSystemLog()
            throws java.rmi.RemoteException;
	
	public EntryGate getEntryGate()
            throws java.rmi.RemoteException;
	
	public ExitGate getExitGate()
            throws java.rmi.RemoteException;
	
	public Date getDateTime()
            throws java.rmi.RemoteException;
	
	public boolean isGarageAcceptingVehicles()
            throws java.rmi.RemoteException;
	
	public GarageDescription viewConfig()
        throws java.rmi.RemoteException;
	
	public double getParkingRate()
            throws java.rmi.RemoteException;

	public int pressGetTicket()
            throws java.rmi.RemoteException;

	public boolean pressEnterGarage()
			throws java.rmi.RemoteException;

//	public boolean updateExitTicketNum(String testString)
//			throws java.rmi.RemoteException;

	public double getSaleTotal(String testString)
			throws java.rmi.RemoteException;

	public double makePayment(String ticketNum, double payAmt, int fopCode)
			throws java.rmi.RemoteException;

	public String getExitGateStatus()
			throws java.rmi.RemoteException;

	public boolean isValidTicket(String ticketNum)
			throws java.rmi.RemoteException;

	public void exitGarage(String ticketNum)
			throws java.rmi.RemoteException;

	public String[] getConfigValues()
			throws java.rmi.RemoteException;

	public boolean setConfigValues(String[] configValues)
			throws java.rmi.RemoteException;

	public boolean createEmployee(String userName, String password)
			throws java.rmi.RemoteException;

	public String[] getSystemActivity()
			throws java.rmi.RemoteException;

	public String[] getHourlySystemActivity()
			throws java.rmi.RemoteException;
	

}

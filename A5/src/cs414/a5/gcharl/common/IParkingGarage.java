package cs414.a5.gcharl.common;

import java.util.Date;

import cs414.a5.gcharl.server.Administrator;
import cs414.a5.gcharl.server.EntryGate;
import cs414.a5.gcharl.server.ExitGate;
import cs414.a5.gcharl.server.Garage;
import cs414.a5.gcharl.server.GarageDescription;
import cs414.a5.gcharl.server.SystemLog;

public interface IParkingGarage extends java.rmi.Remote {
	
	public Administrator createAdministrator(int adminId, String adminPassword, Garage g1)
                throws java.rmi.RemoteException;

	public boolean administratorLogin(int id, String password)
                throws java.rmi.RemoteException;
	
	public Administrator findAdminById(int Id)
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

	public boolean updateExitTicketNum(String testString)
			throws java.rmi.RemoteException;

}

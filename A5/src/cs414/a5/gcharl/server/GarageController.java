package cs414.a5.gcharl.server;

import java.rmi.RemoteException;
import java.util.Date;

import cs414.a5.gcharl.common.IParkingGarage;

public class GarageController implements IParkingGarage {
	
	Garage garage;
	static int curGarageId = 1;
	

	public GarageController() {
		Garage g = new Garage(curGarageId);
		curGarageId ++;			
		this.garage = g;			
	}


	@Override
	public Administrator createAdministrator(int adminId, String adminPassword,
			Garage g1) throws RemoteException {

		return garage.createAdministrator(adminId, adminPassword, g1);
	}

	@Override
	public boolean administratorLogin(int id, String password)
			throws RemoteException {
		
		return garage.administratorLogin(id, password);
	}

	@Override
	public Administrator findAdminById(int Id) throws RemoteException {
		return garage.findAdminById(Id);
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

	


}

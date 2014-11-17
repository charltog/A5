package cs414.a5.gcharl;

import java.util.Date;
import java.util.HashSet;

public class Garage {

	private int Id = 1;
	private int defaultAdminId = 1;
	private String defaultAdminPassword = "foo";
	private EntryGate entryGate;
	private ExitGate exitGate;
	private GarageDescription _garageDescription;
	public SystemLog systemLog;
	public HashSet<Administrator> _administrators = new HashSet<Administrator>();
	public HashSet<Employee> _employees = new HashSet<Employee>();
	
	public Garage(int id) {
		this.Id = id;		
		systemLog = new SystemLog();
		entryGate = createEntryGate();
		exitGate = createExitGate();
		_garageDescription = new GarageDescription();
		
		Administrator a = createAdministrator(defaultAdminId, defaultAdminPassword, this);
		_administrators.add(a);
		
	}

	public Administrator createAdministrator(int adminId, String adminPassword, Garage g1) {
		Administrator a1 = findAdminById(adminId);
		if ((a1 == null) && (adminId > 0)) {
			a1 = new Administrator(adminId, adminPassword, g1);	
			_administrators.add(a1);
		}
		return a1;
	}
	
	
	public boolean administratorLogin(int id, String password) {
		boolean result = false;
		Administrator a = this.findAdminById(id);
		if (a != null && a.getPassword().equals(password)) {
			result = true;
		}
		return result;
	}
	
	public Administrator findAdminById(int Id) {
		Administrator a = null;
		for (Administrator a1 : _administrators) {
			if (a1.getId() == Id) {
				a = a1;
			}
		}
		return a;
	}

	public SystemLog getSystemLog() {
		return systemLog;
	}

	public boolean equals(Object o) {
		boolean result = false;
		if (this.Id == ((Garage)o).getId()) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}
	public int getId() {
		return this.Id;
	}

	private EntryGate createEntryGate() {
		return createEntryGate(this.Id);
	}

	private EntryGate createEntryGate(int id) {
		int initialTicketCount = 1;
		SystemLogEvent event = new SystemLogEvent(this, "Entry Gate Created", EntryGate.class.getName(), this.getDateTime());
		systemLog.addLogEvent(event);		
		return new EntryGate(id, initialTicketCount, this);
	}

	private ExitGate createExitGate() {
		return createExitGate(this.Id);
	}

	private ExitGate createExitGate(int id) {
		SystemLogEvent event = new SystemLogEvent(this, "Exit Gate Created", ExitGate.class.getName(), this.getDateTime());
		systemLog.addLogEvent(event);
		return new ExitGate(id, this);
	}
	
	public EntryGate getEntryGate() {
		return entryGate;
	}

	public ExitGate getExitGate() {
		return exitGate;
	}

	public Date getDateTime() {
		Date d1 = new Date();
		return d1;
	}

	public boolean isGarageAcceptingVehicles() {
		boolean isAccepting = false;
		if (_garageDescription.getSystemStatus() == SystemStatus.Vacancy) {
			isAccepting = true;
		} else {
			isAccepting = false;
		}
		return isAccepting;
	}

	public void increaseCurrentOccupancyByOne() {
		SystemLogEvent event = new SystemLogEvent(this, "Increased Occupancy by one", Garage.class.getName(), this.getDateTime());
		systemLog.addLogEvent(event);
		_garageDescription.increaseCurrentOccupancyByOne();		
	}

	public double getParkingRate() {
		return _garageDescription.getCurrentParkingRate();
	}

	public void decreaseCurrentOccupancyByOne() {
		SystemLogEvent event = new SystemLogEvent(this, "Decreased Occupancy by one", EntryGate.class.getName(), this.getDateTime());
		systemLog.addLogEvent(event);
		_garageDescription.decreaseCurrentOccupancyByOne();
	}

	public GarageDescription viewConfig() {
//		GarageDescription gd = new GarageDescription();
//		gd.setConfig(_garageDescription.maxOccupancy, 
//						_garageDescription.currentOccupancy,
//						_garageDescription.buffer,
//						_garageDescription.hourlyParkingRate,
//						_garageDescription.status);
//		return gd;
		return _garageDescription;
	}

//	private void displayConfig(int max, int cur, int buf, double hpr, SystemStatus ss) {
//		GarageConfigGUI gcgui = new GarageConfigGUI(this);
//		
		
//		System.out.println("Maxiumum Occupancy: " + max);
//		System.out.println("Current Occupancy: " + cur);
//		System.out.println("Capacity Buffer: " + buf);
//		System.out.println("Hourly Parking Rate: " + hpr);
//		System.out.println("System Status: " + ss);		
//	}
	
}

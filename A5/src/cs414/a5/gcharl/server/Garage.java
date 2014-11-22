package cs414.a5.gcharl.server;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.logging.Logger;

import cs414.a5.gcharl.common.*;
import cs414.a5.gcharl.server.*;


public class Garage implements Serializable {

	private int Id = 1;
	private String defaultAdminUserName = "foo";
	private String defaultAdminPassword = "bar";
	private String employeePassword = "";
	private EntryGate entryGate;
	private ExitGate exitGate;
	private GarageDescription _garageDescription;
	public GarageController _garageController;
	
	public SystemLog systemLog;
	public Logger logger = Logger.getLogger(Garage.class.getName());
//	private Logger LOGGER = new Logger.getLogger();
	
	public HashSet<Administrator> _administrators = new HashSet<Administrator>();
	public HashSet<Employee> _employees = new HashSet<Employee>();
	
	public Garage(int id) {
		this.Id = id;		
		systemLog = new SystemLog();
		entryGate = createEntryGate();
		exitGate = createExitGate();
		_garageDescription = new GarageDescription();
		
		this.createAdministrator(defaultAdminUserName, defaultAdminPassword);
		
	}

	public boolean createAdministrator(String adminUserName, String adminPassword) {
		boolean result = false;
		Administrator a1 = findAdminByUserName(adminUserName);
		if ((a1 == null)) {
			a1 = new Administrator(adminUserName, adminPassword, this);	
			_administrators.add(a1);
			result = true;
		}
		return result;
	}
	
	
	public boolean administratorLogin(String adminUserName, String password) {
		boolean result = false;
		Administrator a = this.findAdminByUserName(adminUserName);
		if (a != null && a.getPassword().equals(password)) {
			result = true;
		}
		return result;
	}
	
	public Administrator findAdminByUserName(String adminUserName) {
		Administrator a = null;
		for (Administrator a1 : _administrators) {
			if (a1.getUserName().equals(adminUserName)) {
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

	public int pressGetTicket() {
		
		Ticket t1 = this.getEntryGate().requestTicket();
		return t1.getId();
		
//		if (t1 != null) {
		
//			assignedTicketNumber.setText(t1.toString());
//			entryGatePane.setText("Open");
//			vacancyPane.setText("Yes");			
//			btnEnterGarage.setEnabled(true);
//			btnGetTicket.setEnabled(false);
//		} else {
			
//			assignedTicketNumber.setText("Sorry, Garage is Full");
//			entryGatePane.setText("Closed");
			
			//vacancyPane.setText("No");
//		}
	}
	
	public boolean pressEnterGarage() {
		return this.entryGate.enterGarage();		
	}

	public double makePayment(String ticketNum, double payAmt, int fopCode) {
//		return this.getExitGate()
//		boolean result = false;
		
		Ticket t1 = this.getEntryGate().findTicketByID(ticketNum);
		Sale s1 = this.getExitGate().findSaleByTicketId(t1);
		return this.exitGate.makePayment(s1, payAmt, fopCode);
		
		
//		return result;
	}

	public String getExitGateStatus() {
		return this.getExitGate().getStatus().toString();
	}
//
//	public boolean updateExitTicketNum(String testString) {
//		boolean result = false;
//		int ticketId = this.getEntryGate().findTicketID(testString);
//		boolean isValid = this.getEntryGate().findTicketByID(testString).isValid();
//		if (ticketId > 0 && isValid) {
//			result = true;
//		}
//		return result;
//	}

	public boolean isValidTicket(String ticketNum) {
		boolean result = false;
		int ticketId = this.getEntryGate().findTicketID(ticketNum);
		boolean isValid = this.getEntryGate().findTicketByID(ticketNum).isValid();
		if (ticketId > 0 && isValid) {
			result = true;
		}
		return result;
	}

	public void exitGarage(String ticketNum) {
		this.getExitGate().exitGarage(ticketNum);
	}

	public String[] getConfigValues() {
		return this._garageDescription.getConfigValues();
	}

	public boolean setConfigValues(String[] configValues) {
		return this._garageDescription.setConfig(configValues);
	}

	public boolean createEmployee(String userName, String password) {
		boolean result = false;
		Employee e1 = findEmployeeByUserName(userName);
		if ((e1 == null)) {
			e1 = new Employee(userName, employeePassword, this);	
			_employees.add(e1);
			result = true;
		} else {
			// employee name already exists
		}
		return result;
	}

	public Employee findEmployeeByUserName(String userName) {
		boolean result = false;
		Employee e = null;
		for (Employee e1 : _employees) {
			if (e1.getUserName().equals(userName)) {
				e = e1;
				result = true;
			}
		}
		return e;
	}

	public String[] getSystemActivity() {
		return this.systemLog.getAllActivity();
	}

	public String[] getHourlySystemActivity() {
		return this.systemLog.getHourlyActivity();
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

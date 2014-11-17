package cs414.a5.gcharl;

public class Employee {

	protected Garage _garage;
	private int Id = -1;
	private String password = "";
	private boolean isSessionActive = false;
	
	public Employee(int id, String password, Garage g1) {
		this.Id = id;
		this.password = password;
		this._garage = g1;
		this.isSessionActive = false;		
	}

	public boolean isDone() {
		return this.isSessionActive;		
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return Id;
	}

	public void setDone(boolean done) {
		this.isSessionActive = done;
	}
	
//		
//	public boolean employeeLogin(int id, String password) {
//		boolean result = false;
//		Administrator a = garage.findAdminById(id);
//		if (a != null && a.getPassword().equals(password)) {
//			result = true;
//		}
//		return result;
//	}
}

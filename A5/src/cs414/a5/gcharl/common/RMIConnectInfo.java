package cs414.a5.gcharl.common;

public enum RMIConnectInfo {
	HOSTNAME ("localhost"),
	PORTNUM (8000);
	
	private String hostname;
	private int portnum;
	
	private RMIConnectInfo(String s) {
		this.hostname = s;
	}
	private RMIConnectInfo(int n) {
		portnum = n;
	}
	
}

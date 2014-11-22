package cs414.a5.gcharl.server;

import java.util.Date;

import cs414.a5.gcharl.common.*;

public class SystemLogEvent {
	
	private Garage garage;
	private String description = "";
	private String sourceClassName = "";
	private Date eventTime = null;
	private long hour;
	

	public SystemLogEvent(Garage g1, String description, String className, Date eventTime) {
		this.garage = g1;
		this.description = description;
		this.sourceClassName = className;
		this.eventTime = eventTime;
		this.hour = eventTime.getTime()/3600000;
		
	}
	
	
	public long getHour() {
		return hour;
	}


	public String getDescription() {
		return description;
	}

	public String getSourceClassName() {
		return sourceClassName;
	}

	public Date getEventTime() {
		return eventTime;
	}

	public Garage getGarage() {
		return garage;
	}

	public String toString() {
		String result ="";
		result = result + "Description: " + this.description + "  Time: " + this.eventTime +  " Garage ID: " + this.garage.getId() + "  Source Class: " + this.sourceClassName + "\n";		
		return result;
	}
	
	
}

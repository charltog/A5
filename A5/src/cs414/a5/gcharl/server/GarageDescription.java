package cs414.a5.gcharl.server;

import java.io.IOException;

import cs414.a5.gcharl.common.SystemStatus;


public class GarageDescription {
	
	public int maxOccupancy = 10;
	public int buffer = 3;
	public double hourlyParkingRate = 2.00;
	public SystemStatus status = SystemStatus.ShutDown;
	public int currentOccupancy = 0;
	
	public SystemStatus getSystemStatus() {
		calculateSystemStatus();
		return status;
	}

	private void calculateSystemStatus() {
		if (maxOccupancy-buffer>currentOccupancy) {
			status = SystemStatus.Vacancy;
		} else {
			status = SystemStatus.NoVacancy;
		}		
	}
	
	public boolean setConfig(String[] configValues) { 
		
		boolean result = false;
		try {
			try {
				this.maxOccupancy = Integer.parseInt(configValues[0]);
			} catch (NumberFormatException e) {
				// Blank or non-integer value, do nothing
			}
			try {
				this.currentOccupancy = Integer.parseInt(configValues[1]);
			} catch (NumberFormatException e) {
				// Blank or non-integer value, do nothing
			}
			try {
				this.buffer = Integer.parseInt(configValues[2]);
			} catch (NumberFormatException e) {
				// Blank or non-integer value, do nothing
				
			}
			try {
				this.hourlyParkingRate = Double.parseDouble(configValues[3]);
			} catch (NumberFormatException e) {
				// Blank or non-double value, do nothing
			}
			try {
				this.status = SystemStatus.valueOf(configValues[4]);
			} catch (Exception e) {
				// Blank or invalid value, do nothing
			}
			result = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public void increaseCurrentOccupancyByOne() {
		currentOccupancy++;		
	}

	public double getCurrentParkingRate() {
		return hourlyParkingRate;
	}

	public void decreaseCurrentOccupancyByOne() {
		currentOccupancy--;
	}

	public String[] getConfigValues() {
		String[] configValues = new String[5];
		
		configValues[0] = "" + this.maxOccupancy;
		configValues[1] = "" + this.currentOccupancy;
		configValues[2] = "" + this.buffer;
		configValues[3]	= String.format("$ %.2f", this.hourlyParkingRate);
		configValues[4] = "" + this.status.toString();		
		
		return configValues;
	}

}

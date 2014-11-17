package cs414.a5.gcharl;

import java.io.IOException;


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
	
	public boolean setConfig(int max, int cur, int buf, double hpr, SystemStatus ss) {
		boolean result = false;
		try {
			this.maxOccupancy = max;
			this.buffer = buf;
			this.hourlyParkingRate = hpr;
			this.currentOccupancy = cur;
			this.status = ss;
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

}

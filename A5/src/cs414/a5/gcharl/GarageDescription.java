package cs414.a5.gcharl;


public class GarageDescription {
	
	private static int maxOccupancy = 10;
	private static int buffer = 3;
	private static double hourlyParkingRate = 2.00;
	private SystemStatus status = SystemStatus.ShutDown;
	private int currentOccupancy = 0;
	
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

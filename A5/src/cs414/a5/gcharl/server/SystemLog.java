package cs414.a5.gcharl.server;

import java.util.HashSet;
import java.util.Set;

public class SystemLog {
	
	int maxDisplayedEvents = 24;
	public HashSet<SystemLogEvent> log = new HashSet<SystemLogEvent>();
	
	public void addLogEvent(SystemLogEvent event) {
		this.log.add(event);
	}
	
	public HashSet<String> displayLog() {
		HashSet<String> logStrings = new HashSet<String>();
		for (SystemLogEvent e : this.log) {
			logStrings.add(e.toString());
		}
		return logStrings;
	}

	public String[] getAllActivity() {
		String[] result = new String [maxDisplayedEvents];
		//SystemLogEvent event1;
		int i = 0;
		for (SystemLogEvent e : log) {
			if (i<maxDisplayedEvents) {
				result[i] = e.toString();
			}
			i++;
		}
		return result;
	}

	public String[] getHourlyActivity() {
		String[] result = new String [maxDisplayedEvents];
				
		long hour = 0;
		Integer[] hourlyCount = new Integer[24];
		for (int i = 0; i<24; i++) {
			hourlyCount[i] = 0;
		}
		for (SystemLogEvent e : log) {
			hour = e.getEventTime().getTime()/3600000;
			hour = (hour-7)%24;
			int intHour = (int) hour;
//			System.out.println("Hour:  " + hour);
			//int index = (int) Math.ceil(hour);
			hourlyCount[intHour]++;
		}
		int i = 0;
		while (i<maxDisplayedEvents) {
			result[i] = "Hour: " + i + "  Total events: " + hourlyCount[i] + "";
			i++;
		}

		return result;
	}
	
}

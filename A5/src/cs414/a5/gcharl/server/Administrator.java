package cs414.a5.gcharl.server;

import cs414.a5.gcharl.common.*;

public class Administrator extends Employee{

	public Administrator(int id, String password, Garage g1) {
		super(id, password, g1);
	}

	public GarageDescription viewGarageConfig() {
		GarageDescription gd = null;
		try {
			gd = super._garage.viewConfig();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
		return gd;
	}

	
	
}

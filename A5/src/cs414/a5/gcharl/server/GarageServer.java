package cs414.a5.gcharl.server;

import cs414.a5.gcharl.common.*;  // common.IParkingGarage;
import cs414.a5.gcharl.controller.EntryGateController;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.*;

public class GarageServer {
    private String url;
    public GarageServer(String url) {
    	this.url = url;
    	
    	try {
    		LocateRegistry.createRegistry(2000);
    		System.out.println("java RMI registry successfully created.");
    	} catch (RemoteException re) {
    		// Do nothing, registry already exists
    		System.out.println("java RMI registry already running.");
    	}
    	
    	try {
    		IParkingGarage gc = new GarageController();
    		Naming.rebind(url, gc);
    		
//    		IEntryGate eg = new EntryGateController();
//    		Naming.rebind(url, eg);
    		
    	} catch (Exception e) {
    		System.out.println("Trouble: " + e);
    	}
    }

// run the program using 
// java GarageServer <host> <port>

    public static void main(String args[]) {
    	try {
	        //String url = new String("rmi://" + "localhost" + ":" + "2000" + "/GarageService");
	    	String url = new String("rmi://" + args[0] + ":" + args[1] + "/GarageService");
	        new GarageServer(url);
    	}
    	
    	catch (Exception e) {
    		System.out.println("Trouble: " + e);
    	}    
	    	
    }
}


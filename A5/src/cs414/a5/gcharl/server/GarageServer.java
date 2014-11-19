package cs414.a5.gcharl.server;

import cs414.a5.gcharl.common.*;  // common.IParkingGarage;


import java.rmi.Naming;
public class GarageServer {
    private String url;
        public GarageServer(String url) {
        this.url = url;
        int id = 3;
              try {
            IParkingGarage c = new GarageController();
            Naming.rebind(url, c);
               } catch (Exception e) {
                       System.out.println("Trouble: " + e);
               }
        }

// run the program using 
// java CalculatorServer <host> <port>

    public static void main(String args[]) {
        String url = new String("rmi://" + args[0] + ":" + args[1] + "/CalculatorService");
        new GarageServer(url);
    }
}


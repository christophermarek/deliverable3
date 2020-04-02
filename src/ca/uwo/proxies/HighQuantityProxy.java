package ca.uwo.proxies;

import java.util.Map;
import java.util.Scanner;

import ca.uwo.client.Buyer;
import ca.uwo.client.Supplier;
import ca.uwo.controller.Controller;
import ca.uwo.frontend.Facade;

public class HighQuantityProxy extends Proxy {
	private static HighQuantityProxy instance = null; // singleton
	
	public static HighQuantityProxy getInstance() { // singleton
		if (instance == null)
			instance = new HighQuantityProxy();
		
		return instance;
	}
	
	private HighQuantityProxy() { // singleton
	}
	
	public boolean authenticate(Buyer buyer) {
		boolean auth = false;
		Scanner input = new Scanner(System.in);
		while (!auth) {
		    System.out.println("**********Authenticator**********");
		    System.out.print("Enter Username:");
		    String usr = input.next();
		    if (usr.equals(buyer.getUserName())) {
		    	System.out.print("Enter password:");
		    	String pwd = input.next();
		    	if (pwd.equals(buyer.getPassword())) {
		    		System.out.println("-> Authenticaton Successful");
		    		auth = true;
		    	} else
		    		System.out.println("-> Authenticaton failed");
		    } else
			System.out.println("-> Authenticaton failed");
		}
		return auth;
	    }
	
	@Override
	public void placeOrder(Map<String, Integer> orderDetails, Buyer buyer) {
		Facade facade = Facade.getInstance();
		if (authenticate(buyer)) {
			facade.placeOrder(orderDetails, buyer);
		}
	}

	@Override
	public void restock(Map<String, Integer> restockDetails, Supplier supplier) {
	}

}

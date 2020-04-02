package ca.uwo.proxies;

import java.util.Map;
import java.util.Scanner;

import ca.uwo.client.Buyer;
import ca.uwo.client.Supplier;
import ca.uwo.controller.Controller;
import ca.uwo.frontend.Facade;

public class LowQuantityProxy extends Proxy{
	private static LowQuantityProxy instance = null; // singleton
	protected Proxy next = HighQuantityProxy.getInstance();
	
	public static LowQuantityProxy getInstance() { // singleton
		if (instance == null)
			instance = new LowQuantityProxy();
		
		return instance;
	}
	
	private LowQuantityProxy() { // singleton
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
		// TODO Auto-generated method stub
		Facade facade = Facade.getInstance();
		int counter = 0;
		for (int i : orderDetails.values()) {
			counter = counter + i;
		}
		if (counter > 10) {
			next.placeOrder(orderDetails, buyer);
		} else {
			if (authenticate(buyer)) {
				facade.placeOrder(orderDetails, buyer);
			}
		}
	}

	@Override
	public void restock(Map<String, Integer> restockDetails, Supplier supplier) {
	}

}

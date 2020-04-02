package ca.uwo.proxies;

import java.util.Map;

import ca.uwo.client.Buyer;
import ca.uwo.client.Supplier;
import ca.uwo.controller.Controller;
import ca.uwo.frontend.Facade;

public class SupplierProxy extends Proxy {
	private static SupplierProxy instance; // singleton
	
	protected Proxy next = LowQuantityProxy.getInstance();
	
	public static SupplierProxy getInstance() { // singleton
		if (instance == null)
			instance = new SupplierProxy();
		
		return instance;
	}
	
	private SupplierProxy() { // singleton
	}

	@Override
	public void placeOrder(Map<String, Integer> orderDetails, Buyer buyer) {
		// TODO Auto-generated method stub
		next.placeOrder(orderDetails, buyer);
		
	}

	@Override
	public void restock(Map<String, Integer> restockDetails, Supplier supplier) {
		Facade facade = Facade.getInstance();
		facade.restock(restockDetails, supplier);
	}

}

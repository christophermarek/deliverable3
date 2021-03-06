package ca.uwo.controller;

import ca.uwo.utils.Invoice;
import ca.uwo.utils.Order;

/**
 * @author kkontog, ktsiouni, mgrigori
 * This class implements key underlying operations of the warehouse system. 
 */
public class Controller {
	private static Controller instance = null; // singleton
	
	private CreateInvoiceOperation createInvoiceOp;
	private DepleteStockOperation depleteStockOp;
	private ReplenishStockOperation replenishStockOp;
	
	Order currentOrder = null;
	
	/**
	 * deplete the stock after placing the order.
	 * @param myOrder details of the order.
	 */
	public static Controller getInstance() { // singleton
		if (instance == null)
			instance = new Controller();
		
		return instance;
	}
	public void depleteStock(Order myOrder) {
		System.out.println("Controller: Deplete Stock");
		currentOrder = depleteStockOp.perform(myOrder);
	}

	/**
	 * create invoice for the order.
	 * @return invoice of the current order.
	 */
	public Invoice createInvoice() {
		System.out.println("Controller: Create Invoice");
		currentOrder = createInvoiceOp.perform(currentOrder);
		Invoice invoice = currentOrder.getInvoice();
		currentOrder = null;
		return invoice;
	}

	/**
	 * replenish the stock according to the order.
	 * @param myOrder details of the order.
	 */
	public void replenishStock(Order myOrder) {
		System.out.println("Controller: Replenish Stock");
		replenishStockOp.perform(myOrder);
		
	}

	/**
	 * constructor for the Controller.
	 */
	private Controller() { // singleton
		depleteStockOp = new DepleteStockOperation();
		replenishStockOp = new ReplenishStockOperation();
		createInvoiceOp = new CreateInvoiceOperation();
	}
}

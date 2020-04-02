package ca.uwo.model;

import java.util.ArrayList;
import java.util.List;

import ca.uwo.model.item.states.ItemState;
import ca.uwo.model.item.states.ItemStateFactory;
import ca.uwo.utils.ItemResult;
import ca.uwo.utils.ResponseCode;
import ca.uwo.viewer.Messenger;
import ca.uwo.viewer.StockManager;
import ca.uwo.viewer.Viewer;

/**
 * @author kkontog, ktsiouni, mgrigori This class represents the data objects
 *         (instances of Item class) in the database.
 */
public class Item {
    private int id;
    private String name;
    private int availableQuantity;
    private double price;
    // This is the attribute that references the object's state
    private ItemState state;
    private List<Viewer> viewers;

    /**
     * constructor for the Item class.
     * 
     * @param id
     *            identifier of the item.
     * @param name
     *            name of the item.
     * @param quantity
     *            quantity of the item.
     * @param price
     *            price of the item.
     */
    public Item(int id, String name, int quantity, double price) {
	super();
	this.id = id;
	this.name = name;
	this.availableQuantity = quantity;
	this.price = price;
	this.viewers = new ArrayList<Viewer>();
<<<<<<< HEAD
	this.state = ItemStateFactory.create("in-stock");
=======
	
	if (quantity == 0) { // state initialization
		this.state = ItemStateFactory.create("out-of-stock");
	}else if (quantity > 0 && quantity < 50){
		this.state = ItemStateFactory.create("low-stock");
	}else {
		this.state = ItemStateFactory.create("in-stock");
	}

>>>>>>> 8d6f23c1cc9ede14436ea3c1aa7a51039f554144
	// Adding viewers thus implementing part of the Observer design pattern
	this.viewers.add(StockManager.getInstance());
	this.viewers.add(Messenger.getInstance());

	// When you add states to items make sure you
	// initialize them using the proper STATE!!!!

    }

    public void setState(ItemState state) {
	this.state = state;
    }

    public void notifyViewers() {
	for (Viewer view : viewers) {
	    view.inform(this);
	}
    }

    public void addViewer(Viewer view) {
	boolean duplicate = false;
	for (Viewer viewer : viewers) {
	    if (viewer.equals(view)) {
		duplicate = true;
		break;
	    }
	}
	if (!duplicate)
	    viewers.add(view);
	else
	    System.out.println("-> Unable to add viewer, already exists");
    }

    public void deleteViewer(Viewer view) {
	for (Viewer viewer : viewers) {
	    if (viewer.equals(view)) {
		viewers.remove(viewer);
		System.out.println("-> Viewer deleted successfully");
		break;
	    }
	}
	System.out.println("-> Viewer not deleted, does not exist");
    }

    /**
     * @return id of the item.
     */
    public int getId() {
	return id;
    }

    /**
     * @return name of the item.
     */
    public String getName() {
	return name;
    }

    /**
     * @return available quantity of the item.
     */
    public int getAvailableQuantity() {
	return availableQuantity;
    }

    /**
     * @param availableQuantity
     *            available quantity of the item in stock.
     */
    public void setAvailableQuantity(int availableQuantity) {
	this.availableQuantity = availableQuantity;
    }

    /**
     * @return price of the item.
     */
    public double getPrice() {
	return price;
    }

    /**
     * deplete the item.
     * 
     * @param quantity
     *            the quantity of item to deplete.
     * @return execution result of the deplete action.
     */
    public ItemResult deplete(int quantity) {
	return state.deplete(this, quantity);
    }

    /**
     * replenish the item.
     * 
     * @param quantity
     *            the quantity of item to replenish.
     * @return execution result of the replenish action.
     */
    public ItemResult replenish(int quantity) {
	return state.replenish(this, quantity);
    }

}
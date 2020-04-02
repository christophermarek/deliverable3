package ca.uwo.viewer.restock.strategies;

public class RestockStrategy2 implements RestockStrategy{

    @Override
    public int calculateQuantity(String itemName, int quantity, double price) {
	System.out.println("-> Restock strategy 2 used");
	if (itemName.equalsIgnoreCase("apples") || itemName.equalsIgnoreCase("apple"))
	    return 100;
	else
	    return 25;
    }
}

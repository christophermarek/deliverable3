package ca.uwo.viewer.restock.strategies;

public class RestockStrategy1 implements RestockStrategy {

    @Override
    public int calculateQuantity(String itemName, int quantity, double price) {
	System.out.println("-> Restock strategy 1 used");
	return 50;
    }

}
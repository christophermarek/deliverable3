package ca.uwo.viewer.restock.strategies;

public class RestockStrategyDefault implements RestockStrategy {

    @Override
    public int calculateQuantity(String itemName, int quantity, double price) {
	return quantity;
    }
}
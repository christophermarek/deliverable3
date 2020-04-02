package ca.uwo.model.item.states;

import ca.uwo.model.Item;
import ca.uwo.utils.ItemResult;
import ca.uwo.utils.ResponseCode;

public class InStockState implements ItemState {

    @Override
    public ItemResult deplete(Item item, int quantity) {
	ItemResult result;
	int newQuantity = item.getAvailableQuantity() - quantity;
	if (newQuantity < 0) {
	    result = new ItemResult("OUT OF STOCK", ResponseCode.Not_Completed);
	    item.setState(ItemStateFactory.create("low-stock"));
	}
	else {
	    result = new ItemResult("AVAILABLE", ResponseCode.Completed);
	    item.setAvailableQuantity(newQuantity);
	    if (newQuantity == 0)
		item.setState(ItemStateFactory.create("out-of-stock"));
	}
	item.notifyViewers();
	return result;
    }

    @Override
    public ItemResult replenish(Item item, int quantity) {
	int newQuantity = item.getAvailableQuantity() + quantity;
	item.setAvailableQuantity(newQuantity);
	item.notifyViewers();
	return new ItemResult("RESTOCKED", ResponseCode.Completed);
    }

}

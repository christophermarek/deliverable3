package ca.uwo.model.item.states;

import ca.uwo.model.Item;
import ca.uwo.utils.ItemResult;
import ca.uwo.utils.ResponseCode;

public class OutOfStockState implements ItemState {

    @Override
    public ItemResult deplete(Item item, int quantity) {
    	return new ItemResult("NOT AVAIALBLE", ResponseCode.Not_Completed);
    }

    @Override
    public ItemResult replenish(Item item, int quantity) {
		int newQuantity = item.getAvailableQuantity() + quantity;
		item.setAvailableQuantity(newQuantity);
		item.setState(ItemStateFactory.create("in-stock"));
		//item.notifyViewers();
		return new ItemResult("RESTOCKED", ResponseCode.Completed);
    }
}

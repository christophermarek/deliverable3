package ca.uwo.model.item.states;

import ca.uwo.model.Item;
import ca.uwo.utils.ItemResult;
import ca.uwo.utils.ResponseCode;

public class DefaultStockState implements ItemState {

    @Override
    public ItemResult deplete(Item item, int quantity) {
    	return new ItemResult("INVALID STOCK TYPE", ResponseCode.Not_Completed);
    }

    @Override
    public ItemResult replenish(Item item, int quantity) {
    	return new ItemResult("INVALID STOCK TYPE", ResponseCode.Not_Completed);
    }

}

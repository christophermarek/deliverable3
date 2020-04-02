package ca.uwo.model.item.states;

public class ItemStateFactory {

    public static ItemState create(String type) {
	switch (type) {
	case "in-stock":
	    return new InStockState();
	case "out-of-stock":
	    return new OutOfStockState();
	case "low-stock":
	    return new LowStockState();
	default:
	    return new DefaultStockState();		
	}
    }
}

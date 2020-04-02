package ca.uwo.viewer.restock.strategies;

public class RestockStrategyFactory {

    public static RestockStrategy create(String type) {
	switch (type) {
	case "one":
	    return new RestockStrategy1();
	case "two":
	    return new RestockStrategy2();
	default:
	    return new RestockStrategyDefault();
	}
    }
}

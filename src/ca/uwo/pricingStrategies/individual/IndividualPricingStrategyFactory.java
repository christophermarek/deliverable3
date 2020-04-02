package ca.uwo.pricingStrategies.individual;

public class IndividualPricingStrategyFactory {
    public static IndividualPricingStrategy create(String type) {
	if (type.equalsIgnoreCase("one"))
	    return new IndividualPricingStrategy1();
	else
	    return new IndividualPricingStrategy2();
    }
}

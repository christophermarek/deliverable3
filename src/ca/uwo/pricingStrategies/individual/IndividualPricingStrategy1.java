package ca.uwo.pricingStrategies.individual;

public class IndividualPricingStrategy1 implements IndividualPricingStrategy {

    @Override
    public double calculate(int quantity, double price) {
	System.out.println("-> Individual pricing strategy 1 used");
	return (quantity * price);
    }

}

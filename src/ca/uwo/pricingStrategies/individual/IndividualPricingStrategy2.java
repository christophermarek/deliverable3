package ca.uwo.pricingStrategies.individual;

public class IndividualPricingStrategy2 implements IndividualPricingStrategy {

    @Override
    public double calculate(int quantity, double price) {
	double res = quantity * price;
	double rand = Math.random();
	if (rand >= 0 && rand <= 0.2)
	    res -= (res * 0.1);
	else
	    res *= 1.1;
	return res;
    }
}
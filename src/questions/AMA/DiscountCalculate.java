package questions.AMA;

import java.util.List;

public class DiscountCalculate {

    private List<IDiscountStrategy> strategies;

    public DiscountCalculate(List<IDiscountStrategy> strategies) {
        this.strategies = strategies;
    }

    public double getPrice(double amount, int totalPurchase) {
        double res = amount;
        for (IDiscountStrategy strategy: strategies) {
            res = Math.min(res, strategy.calculateDiscount(amount, totalPurchase));
        }
        return res;
    }
}

package questions.AMA;

public class TotalPurchase implements IDiscountStrategy {
    @Override
    public double calculateDiscount(double amount, int totalPurchase) {
        if (totalPurchase >= 100) {
            return amount * 0.90;
        }
        return amount;
    }
}

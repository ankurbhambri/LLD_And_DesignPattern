package questions.AMA;

public class TotalAmount implements IDiscountStrategy {
    @Override
    public double calculateDiscount(double amount, int totalPurchase) {
        if (amount >= 100) {
            return amount * 0.95;
        }
        return amount;
    }
}

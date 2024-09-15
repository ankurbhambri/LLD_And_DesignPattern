package questions.AMA;
import java.util.Arrays;

/*
    The problem statement was something like:

    Amazon Marketplace wants to apply a discount for a user's order.
    If it's the user's 100th order, there is a discount of 10%.
    If the order total exceeds $100, there is a discount of 5%.
    They want to apply the highest discount only, e.g. if a user is eligible for both of the above discounts, they only receive the 10% discount.

 */

public class Main {
    public static void main(String[] args) {

        TotalPurchase totalPurchase = new TotalPurchase();
        TotalAmount totalAmount = new TotalAmount();

        DiscountCalculate discountCalculate = new DiscountCalculate(Arrays.asList(totalPurchase, totalAmount));
        double amount = 90.0;
        int totalOrder = 100;
        System.out.println("Final Price .... " + discountCalculate.getPrice(amount, totalOrder));

        double amount1 = 101.0;
        int totalOrder1 = 80;
        System.out.println("Final Price .... " + discountCalculate.getPrice(amount1, totalOrder1));
    }
}

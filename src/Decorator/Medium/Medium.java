/* Here we have extended the functionality to include drinks and other fast food items and Order Management */

package Decorator.Medium;

import java.util.ArrayList;
import java.util.List;

// interface OrderItem {
//     String getDescription();
//     double getCost();
// }

abstract class OrderItem {

    public abstract String getDescription();
    public abstract double getCost();

    // Concrete methods → already implemented and can be reused or overridden.
    @Override
    public String toString() {
        return getDescription() + ": $" + String.format("%.2f", getCost());
    }
}

class PlainPizza extends OrderItem {

    @Override
    public String getDescription() {
        return "Plain Pizza";
    }

    @Override
    public double getCost() {
        return 5.0;
    }
}

class MargheritaPizza extends OrderItem {

    @Override
    public String getDescription() {
        return "Margherita Pizza";
    }

    @Override
    public double getCost() {
        return 8.0;
    }
}

class CheesePizza extends OrderItem {

    @Override
    public String getDescription() {
        return "Cheese Pizza";
    }

    @Override
    public double getCost() {
        return 7.0;
    }
}

// Abstract Decorator
abstract class PizzaDecorator extends OrderItem {

    protected OrderItem pizza;

    public PizzaDecorator(OrderItem pizza) {
        this.pizza = pizza;
    }

    @Override
    public String toString() {
        return getDescription() + ": $" + String.format("%.2f", getCost());
    }
}

// Toppings
class CheeseTopping extends PizzaDecorator {

    public CheeseTopping(OrderItem pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Cheese";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 1.5;
    }
}

class PepperoniTopping extends PizzaDecorator {

    public PepperoniTopping(OrderItem pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Pepperoni";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 2.0;
    }
}

class VeggieTopping extends PizzaDecorator {

    public VeggieTopping(OrderItem pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Veggies";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 1.0;
    }
}

// Size Enum and Decorator
enum Size {

    SMALL(0.8, "Small"),
    MEDIUM(1.0, "Medium"),
    LARGE(1.5, "Large");

    private final double multiplier;
    private final String label;

    Size(double multiplier, String label) {
        this.multiplier = multiplier;
        this.label = label;
    }

    public double apply(double baseCost) {
        return baseCost * multiplier;
    }

    public String getLabel() {
        return label;
    }
}

class SizeDecorator extends PizzaDecorator {

    private final Size size;

    public SizeDecorator(OrderItem pizza, Size size) {
        super(pizza);
        this.size = size;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " (" + size.getLabel() + ")";
    }

    @Override
    public double getCost() {
        return size.apply(pizza.getCost());
    }
}

// Other Items
class Cola extends OrderItem {

    @Override
    public String getDescription() {
        return "Cola";
    }

    @Override
    public double getCost() {
        return 2.0;
    }
}

class Lemonade extends OrderItem {

    @Override
    public String getDescription() {
        return "Lemonade";
    }

    @Override
    public double getCost() {
        return 1.5;
    }
}

class Burger extends OrderItem {

    @Override
    public String getDescription() {
        return "Burger";
    }

    @Override
    public double getCost() {
        return 4.0;
    }
}

// Order Manager
class Order {
    private final List<OrderItem> items = new ArrayList<>();

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public double getCost() {
        return items.stream().mapToDouble(OrderItem::getCost).sum();
    }

    public void printSummary() {
        System.out.println("\n");
        System.out.println("Order Summary:");
        items.forEach(item -> System.out.println("- " + item));
        System.out.printf("Total Cost: $%.2f%n", getCost());
        System.out.println("\n");
    }
}

// Main
public class Medium {
    public static void main(String[] args) {

        // Large Margherita with Cheese, Veggies + Cola
        Order order = new Order();

        OrderItem pizza1 = new VeggieTopping(new CheeseTopping((new SizeDecorator(new MargheritaPizza(), Size.LARGE))));

        order.addItem(pizza1);
        order.addItem(new Cola());

        order.printSummary();

        // Small Plain Pizza with Pepperoni + Lemonade + Veggie Burger
        Order order2 = new Order();

        OrderItem pizza2 = new PepperoniTopping(new SizeDecorator(new PlainPizza(), Size.SMALL));

        order2.addItem(pizza2);
        order2.addItem(new Lemonade());
        order2.addItem(new Burger());

        order2.printSummary();
    }
}

package Decorator_DesignPattern.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

interface OrderItem {
    String getDescription();

    double getCost();
}

interface BasePizza extends OrderItem {
    String getDescription();

    double getCost();
}

class PlainPizza implements BasePizza {
    @Override
    public String getDescription() {
        return "Plain Pizza";
    }

    @Override
    public double getCost() {
        return 5.0;
    }
}

class MargheritaPizza implements BasePizza {
    @Override
    public String getDescription() {
        return "Margherita Pizza";
    }

    @Override
    public double getCost() {
        return 8.0;
    }
}

class CheesePizza implements BasePizza {
    @Override
    public String getDescription() {
        return "Cheese Pizza";
    }

    @Override
    public double getCost() {
        return 7.0;
    }
}

abstract class PizzaDecorator implements BasePizza {
    protected BasePizza pizza;

    public PizzaDecorator(BasePizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription();
    }

    @Override
    public double getCost() {
        return pizza.getCost();
    }
}

class CheeseTopping extends PizzaDecorator {
    public CheeseTopping(BasePizza pizza) {
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
    public PepperoniTopping(BasePizza pizza) {
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
    public VeggieTopping(BasePizza pizza) {
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

class SmallSizeDecorator extends PizzaDecorator {
    public SmallSizeDecorator(BasePizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " (Small)";
    }

    @Override
    public double getCost() {
        return pizza.getCost() * 0.8;
    }
}

class MediumSizeDecorator extends PizzaDecorator {
    public MediumSizeDecorator(BasePizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " (Medium)";
    }

    @Override
    public double getCost() {
        return pizza.getCost() * 1.0;
    }
}

class LargeSizeDecorator extends PizzaDecorator {
    public LargeSizeDecorator(BasePizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " (Large)";
    }

    @Override
    public double getCost() {
        return pizza.getCost() * 1.5;
    }
}

class Cola implements OrderItem {
    @Override
    public String getDescription() {
        return "Cola";
    }

    @Override
    public double getCost() {
        return 2.0;
    }
}

class Lemonade implements OrderItem {
    @Override
    public String getDescription() {
        return "Lemonade";
    }

    @Override
    public double getCost() {
        return 1.5;
    }
}

class VeggieBurger implements OrderItem {
    @Override
    public String getDescription() {
        return "Veggie Burger";
    }

    @Override
    public double getCost() {
        return 4.0;
    }
}

class ChickenBurger implements OrderItem {
    @Override
    public String getDescription() {
        return "Chicken Burger";
    }

    @Override
    public double getCost() {
        return 5.5;
    }
}

class Order {
    private List<OrderItem> items = new ArrayList<>();

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public String getDescription() {
        return items.stream()
                .map(OrderItem::getDescription)
                .collect(Collectors.joining("; "));
    }

    public double getCost() {
        return items.stream()
                .mapToDouble(OrderItem::getCost)
                .sum();
    }
}

public class Medium {
    public static void main(String[] args) {
        Order order = new Order();

        // Test Case 1: Large Margherita with Cheese, Veggies + Cola
        BasePizza pizza1 = new MargheritaPizza();
        pizza1 = new LargeSizeDecorator(pizza1);
        pizza1 = new CheeseTopping(pizza1);
        pizza1 = new VeggieTopping(pizza1);
        order.addItem(pizza1);
        order.addItem(new Cola());

        // Test Case 2: Small Plain Pizza with Pepperoni + Lemonade + Veggie Burger
        BasePizza pizza2 = new PlainPizza();
        pizza2 = new SmallSizeDecorator(pizza2);
        pizza2 = new PepperoniTopping(pizza2);
        order.addItem(pizza2);
        order.addItem(new Lemonade());
        order.addItem(new VeggieBurger());

        // Test Case 3: Medium Cheese Pizza with Double Cheese + Chicken Burger
        BasePizza pizza3 = new CheesePizza();
        pizza3 = new MediumSizeDecorator(pizza3);
        pizza3 = new CheeseTopping(pizza3);
        pizza3 = new CheeseTopping(pizza3);
        order.addItem(pizza3);
        order.addItem(new ChickenBurger());

        // Print order details
        System.out.println("Order Details: " + order.getDescription());
        System.out.printf("Total Cost: $%.2f%n", order.getCost());
    }
}
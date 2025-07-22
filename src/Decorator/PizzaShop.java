// Pizza Builder using the Decorator + Fluent Builder pattern. You can copy and run it all in a single file (e.g., PizzaShop.java) using any IDE or Java compiler.

package Decorator;

import java.util.*;

// ----------------- Enum for Size -----------------
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

// ----------------- Abstract OrderItem -----------------
abstract class OrderItem {

    public abstract String getDescription();
    public abstract double getCost();

    @Override
    public String toString() {
        return getDescription() + ": $" + String.format("%.2f", getCost());
    }
}

// ----------------- Base Pizza -----------------
class MargheritaPizza extends OrderItem {
    @Override
    public String getDescription() {
        return "Margherita Pizza";
    }

    @Override
    public double getCost() {
        return 5.0;
    }
}

// ----------------- Decorator Base -----------------
abstract class PizzaDecorator extends OrderItem {
    protected final OrderItem pizza;

    public PizzaDecorator(OrderItem pizza) {
        this.pizza = pizza;
    }
}

// ----------------- Size Decorator -----------------
class SizeDecorator extends PizzaDecorator {
    private final Size size;

    public SizeDecorator(OrderItem pizza, Size size) {
        super(pizza);
        this.size = size;
    }

    @Override
    public String getDescription() {
        return size.getLabel() + " " + pizza.getDescription();
    }

    @Override
    public double getCost() {
        return size.apply(pizza.getCost());
    }
}

// ----------------- Topping Decorators -----------------
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
        return pizza.getCost() + 1.0;
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

// ----------------- Builder -----------------
class PizzaBuilder {

    private OrderItem basePizza;
    private final List<PizzaDecorator> toppings = new ArrayList<>();
    private Size size = Size.MEDIUM;

    private PizzaBuilder(OrderItem basePizza) {
        this.basePizza = basePizza;
    }

    public static PizzaBuilder withBase(OrderItem basePizza) {
        return new PizzaBuilder(basePizza);
    }

    public PizzaBuilder addTopping(PizzaDecorator toppingTemplate) {
        toppings.add(toppingTemplate);
        return this;
    }

    public PizzaBuilder addSize(Size size) {
        this.size = size;
        return this;
    }

    public OrderItem build() {
        OrderItem finalPizza = new SizeDecorator(basePizza, size);

        for (PizzaDecorator toppingTemplate : toppings) {
            finalPizza = createToppingFromTemplate(toppingTemplate, finalPizza);
        }

        return finalPizza;
    }

    private OrderItem createToppingFromTemplate(PizzaDecorator template, OrderItem wrappedPizza) {
        if (template instanceof CheeseTopping) {
            return new CheeseTopping(wrappedPizza);
        } else if (template instanceof VeggieTopping) {
            return new VeggieTopping(wrappedPizza);
        } else if (template instanceof PepperoniTopping) {
            return new PepperoniTopping(wrappedPizza);
        }
        throw new IllegalArgumentException("Unknown topping: " + template.getClass().getSimpleName());
    }
}

// ----------------- Demo / Main -----------------
public class PizzaShop {
    public static void main(String[] args) {

        OrderItem pizza = PizzaBuilder
            .withBase(new MargheritaPizza())
            .addSize(Size.LARGE)
            .addTopping(new CheeseTopping(null))
            .addTopping(new VeggieTopping(null))
            .build();

        System.out.println(pizza);
    }
}

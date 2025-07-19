/*
 * Decorator Design Pattern Notes
 * What is the Decorator Design Pattern?
 * 
 * Definition: A structural design pattern that allows you to dynamically extend
 * the behavior of an object without modifying its original class or creating
 * multiple subclasses.
 * Analogy: Like adding toppings to a pizza. You start with a base pizza and
 * "wrap" it with toppings (extra functionality) as needed.
 * Purpose: To add responsibilities to objects in a flexible and reusable way.
 * 
 * Why Use the Decorator Pattern?
 * 
 * Solves Class Explosion Problem:
 * Without decorators, we’d need a subclass for every combination of features
 * (e.g., CheesePizza, OnionCheesePizza, OnionCheeseOlivePizza).
 * For n features, we could end up with 2^n subclasses, making code
 * unmanageable.
 * Decorators allows us to combine features dynamically without creating new
 * subclasses.
 * 
 * 
 * Flexibility:
 * Add or remove features at runtime by wrapping objects with decorators.
 * Follows the Open/Closed Principle: Open for extension, closed for
 * modification.
 * 
 * 
 * Reusability:
 * Decorators can be reused across different objects (e.g., a CheeseTopping can
 * be used on any pizza type).
 * 
 * 
 * Dynamic Behavior:
 * You can customize objects based on user input or runtime conditions.
 * 
 * 
 * 
 * When to Use the Decorator Pattern?
 * 
 * When you need to add responsibilities to objects dynamically without
 * modifying their code.
 * 
 * When creating subclasses for every combination of features is impractical
 * (class explosion).
 * 
 * When you want to keep the core class simple and add optional features
 * separately.
 * 
 * Examples:
 * Adding toppings to a pizza.
 * Enhancing UI components (e.g., adding scrollbar or borders to a window).
 * Wrapping file streams (e.g., Java’s BufferedInputStream wraps
 * FileInputStream).
 *
 * 
 *  
 * How Does It Work?
 * 
 * 
 * Components:
 * Component Interface: Defines the common methods for both the base object and
 * decorators (e.g., Pizza interface with getDescription() and getCost()).
 * Concrete Component: The base object you want to extend (e.g., PlainPizza).
 * Decorator: An abstract class that implements the component interface and
 * holds a reference to a component object (e.g., ToppingDecorator).
 * Concrete Decorator: Specific decorators that add functionality (e.g.,
 * CheeseTopping, OnionTopping).
 * 
 * 
 * Mechanism:
 * Decorators "wrap" the base object and add their own behavior while delegating
 * the core functionality to the wrapped object.
 * You can stack multiple decorators to combine features (e.g.,
 * CheeseTopping(OnionTopping(PlainPizza))).
 * 
 * 
 * Explanation of Code
 * 
 * 
 * Pizza: Interface defining the contract (getDescription, getCost).
 * PlainPizza: Base pizza with minimal functionality.
 * PizzaDecorator: Abstract decorator that holds a Pizza object and delegates
 * calls to it.
 * CheeseTopping, OnionTopping: Concrete decorators that add their own
 * description and cost.
 * Usage: Wrapping PlainPizza with OnionTopping and CheeseTopping creates a
 * pizza with both toppings without needing a specific subclass.
 * 
 * 
 * Advantages of Decorator Pattern
 * 
 * 
 * Scalable: Easily add new features (e.g., new toppings) by creating new
 * decorators.
 * Flexible: Combine features in any order or quantity.
 * Maintainable: No need to modify existing classes when adding new
 * functionality.
 * Avoids Bloat: Prevents exponential growth of subclasses.
 * 
 * 
 * Disadvantages
 * 
 * 
 * Complexity: Can make the code harder to understand due to multiple layers of
 * wrapping.
 * Debugging: Stack of decorators can make it tricky to trace issues.
 * Overuse: Using decorators for simple problems can lead to unnecessary
 * complexity.
 * 
 * Real-World Examples
 * 
 * Java I/O Streams:
 * BufferedInputStream wraps FileInputStream to add buffering.
 * DataInputStream adds methods to read primitive data types.
 * 
 * 
 * GUI Frameworks:
 * Adding scrollbar, borders, or shadows to UI components.
 * 
 * 
 * Web Filters:
 * Adding logging, authentication, or compression to HTTP requests.
 * 
 * 
 * Key Takeaways
 * 
 * Decorator pattern is perfect for scenarios where you need to add optional
 * features dynamically.
 * It prevents the need for creating countless subclasses for every feature
 * combination.
 * It promotes clean, modular, and extensible code.
 * Use it when flexibility and scalability are more important than simplicity.
 */

package Decorator.Easy;

interface BasePizza {

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
        return pizza.getCost() * 0.8; // 20% cheaper
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
        return pizza.getCost() * 1.0; // Same cost
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
        return pizza.getCost() * 2.0; // 100% costlier
    }
}

public class Easy {
    public static void main(String[] args) {

        // Test Case 1: Large Margherita with Cheese and Veggies
        BasePizza pizza1 = new VeggieTopping(new CheeseTopping(new LargeSizeDecorator(new MargheritaPizza())));
        System.out.printf("Pizza 1: %s | Cost: $%.2f%n", pizza1.getDescription(), pizza1.getCost()); // 18.50 cost

        // Test Case 2: Small Plain Pizza with Pepperoni
        BasePizza pizza2 = new PepperoniTopping(new SmallSizeDecorator(new PlainPizza()));
        System.out.printf("Pizza 2: %s | Cost: $%.2f%n", pizza2.getDescription(), pizza2.getCost()); // 6.00 cost

        // Test Case 3: Medium Cheese Pizza with Double Cheese
        BasePizza pizza3 = new CheeseTopping(new MediumSizeDecorator(new CheesePizza()));
        System.out.printf("Pizza 3: %s | Cost: $%.2f%n", pizza3.getDescription(), pizza3.getCost()); // 8.50 cost
    }
}

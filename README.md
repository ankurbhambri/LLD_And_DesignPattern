## Low Level Design and Design Patterns in Java

Design patterns are well-established solutions to common problems in software design. They are like blueprints that can be customized to solve a particular design problem in your code. This document provides an overview of the three main categories of design patterns: **Creational**, **Structural**, and **Behavioral**.

### Table of Contents

- [Creational Design Patterns](#creational-design-patterns)
- [Structural Design Patterns](#structural-design-patterns)
- [Behavioral Design Patterns](#behavioral-design-patterns)

---

### Creational Design Patterns

Creational patterns focus on how objects are **created**. They abstract the instantiation process, making it more flexible and reusable.

- **Singleton**: Ensures a class has only one instance and provides a global point of access to it.
- **Factory Method**: Defines an interface for creating an object, but lets subclasses decide which class to instantiate.
- **Abstract Factory**: Provides an interface to create families of related or dependent objects without specifying their concrete classes.
- **Builder**: Separates the construction of a complex object from its representation, allowing the same construction process to create different representations.
- **Prototype**: Creates new objects by copying an existing object, known as the prototype.

### Structural Design Patterns

Structural patterns deal with the **composition** of objects or classes. They help ensure that if one part of a system changes, the entire system doesn't need to change.

- **Adapter**: Allows objects with incompatible interfaces to work together.
- **Bridge**: Decouples an abstraction from its implementation, allowing them to vary independently.
- **Composite**: Composes objects into tree structures to represent part-whole hierarchies. This pattern lets clients treat individual objects and compositions of objects uniformly.
- **Decorator**: Adds behavior or responsibilities to objects dynamically without altering their code.
- **Facade**: Provides a simplified interface to a complex subsystem, making it easier to use.
- **Flyweight**: Reduces the cost of creating and manipulating a large number of similar objects by sharing as much data as possible.
- **Proxy**: Provides a surrogate or placeholder for another object to control access to it.

### Behavioral Design Patterns

Behavioral patterns focus on **communication** between objects, making the interactions between objects more flexible and easier to manage.

- **Chain of Responsibility**: Passes a request along a chain of handlers, where each handler can either process the request or pass it to the next handler.
- **Command**: Encapsulates a request as an object, allowing you to parameterize clients with queues, requests, and operations.
- **Interpreter**: Implements a specialized language by defining a grammar and interpreting its sentences.
- **Iterator**: Provides a way to access the elements of an aggregate object sequentially without exposing its underlying representation.
- **Mediator**: Defines an object that encapsulates how a set of objects interact, promoting loose coupling by keeping objects from referring to each other explicitly.
- **Memento**: Captures and externalizes an object’s internal state so that the object can be restored to this state later without violating encapsulation.
- **Observer**: Defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.
- **State**: Allows an object to alter its behavior when its internal state changes, appearing as though it changes its class.
- **Strategy**: Defines a family of algorithms, encapsulates each one, and makes them interchangeable, allowing the algorithm to vary independently from the clients that use it.
- **Template Method**: Defines the skeleton of an algorithm in a method, deferring some steps to subclasses, allowing them to redefine certain steps without changing the algorithm's structure.
- **Visitor**: Represents an operation to be performed on elements of an object structure, allowing you to define a new operation without changing the classes of the elements on which it operates.

---

This document serves as a quick reference to different design patterns and their categories. Each pattern provides a specific solution to common design problems and can be adapted to suit your particular needs.

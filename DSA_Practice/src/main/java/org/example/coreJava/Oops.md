## Four Pillars of OOPs

The four pillars of Object-Oriented Programming (OOP) are fundamental principles that guide the design and development of object-oriented systems. These pillars are Encapsulation, Inheritance, Polymorphism, and Abstraction. Let's explore each pillar with an explanation and an example in Java.

### 1. **Encapsulation**

**Encapsulation** is the practice of bundling the data (attributes) and methods (functions) that operate on the data into a single unit, typically a class. It also involves restricting direct access to some of the object's components, which is achieved through access modifiers like `private`, `protected`, and `public`.

**Example:**

```java
public class Employee {
    private String name;
    private int age;

    // Getter and Setter methods for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter methods for age
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }
}
```

In this example, the `Employee` class encapsulates the `name` and `age` attributes. Access to these attributes is controlled through the public getter and setter methods, preventing direct access and allowing validation or other logic to be applied.

### 2. **Inheritance**

**Inheritance** allows a new class to inherit properties and behavior (methods) from an existing class. The class that is inherited from is called the parent or base class, and the class that inherits is called the child or derived class. This promotes code reusability.

**Example:**

```java
// Parent class
public class Animal {
    public void eat() {
        System.out.println("This animal eats food.");
    }
}

// Child class inheriting from Animal
public class Dog extends Animal {
    public void bark() {
        System.out.println("The dog barks.");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();  // Inherited method
        dog.bark(); // Method specific to Dog
    }
}
```

In this example, the `Dog` class inherits the `eat()` method from the `Animal` class, demonstrating how inheritance allows for code reuse.

### 3. **Polymorphism**

**Polymorphism** means "many forms." In OOP, it allows one interface to be used for a general class of actions. The specific action is determined by the exact nature of the situation. Polymorphism is achieved through method overriding and method overloading.

**Example:**

```java
// Parent class
public class Animal {
    public void sound() {
        System.out.println("Some generic animal sound");
    }
}

// Child class overriding the sound() method
public class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("The dog barks.");
    }
}

// Another child class overriding the sound() method
public class Cat extends Animal {
    @Override
    public void sound() {
        System.out.println("The cat meows.");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal myDog = new Dog();
        Animal myCat = new Cat();

        myDog.sound(); // Outputs: The dog barks.
        myCat.sound(); // Outputs: The cat meows.
    }
}
```

In this example, the `sound()` method is overridden in the `Dog` and `Cat` classes. The same method call (`sound()`) results in different behavior depending on the object (`Dog` or `Cat`), illustrating polymorphism.

### 4. **Abstraction**

**Abstraction** is the process of hiding the implementation details and showing only the essential features of an object. It can be achieved using abstract classes and interfaces in Java. Abstract classes provide a way to define common methods that must be implemented by subclasses, while interfaces define a contract that classes must follow.

**Example:**

```java
// Abstract class
public abstract class Shape {
    abstract void draw(); // Abstract method
}

// Concrete class implementing the abstract method
public class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a circle.");
    }
}

// Concrete class implementing the abstract method
public class Rectangle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a rectangle.");
    }
}

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape rectangle = new Rectangle();

        circle.draw();     // Outputs: Drawing a circle.
        rectangle.draw();  // Outputs: Drawing a rectangle.
    }
}
```

In this example, the `Shape` abstract class defines an abstract method `draw()`, which is implemented differently by the `Circle` and `Rectangle` classes. This demonstrates abstraction by defining a common interface while allowing different implementations.

### **Summary**

- **Encapsulation**: Bundling data and methods, restricting access to protect the internal state of the object.
- **Inheritance**: Allowing a new class to inherit properties and methods from an existing class.
- **Polymorphism**: Allowing a single interface or method to represent different forms or behaviors.
- **Abstraction**: Hiding implementation details and showing only essential features, achieved through abstract classes and interfaces.

These pillars work together to create robust, maintainable, and reusable code in Java and other object-oriented programming languages.

## Polymorphism types

Polymorphism in Java can be categorized into two main types: **Compile-Time Polymorphism** (also known as Static Polymorphism) and **Run-Time Polymorphism** (also known as Dynamic Polymorphism). Let's explore each type in detail:

### 1. **Compile-Time Polymorphism (Static Polymorphism)**

Compile-Time Polymorphism is achieved by method overloading and operator overloading. In Java, operator overloading is not supported, so compile-time polymorphism is primarily achieved through **method overloading**. The method to be invoked is determined at compile time.

#### **Method Overloading**

Method overloading occurs when two or more methods in the same class have the same name but different parameters (number, type, or both).

**Example:**

```java
public class Calculator {

    // Overloaded method for adding two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Overloaded method for adding three integers
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    // Overloaded method for adding two doubles
    public double add(double a, double b) {
        return a + b;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.add(2, 3));          // Outputs: 5
        System.out.println(calculator.add(2, 3, 4));       // Outputs: 9
        System.out.println(calculator.add(2.5, 3.5));      // Outputs: 6.0
    }
}
```

In this example, the `add` method is overloaded with different parameter lists. The correct method is selected by the compiler based on the method signature.

### 2. **Run-Time Polymorphism (Dynamic Polymorphism)**

Run-Time Polymorphism is achieved through **method overriding**. It occurs when a subclass provides a specific implementation of a method that is already defined in its superclass. The method to be invoked is determined at runtime based on the actual object's type, not the reference type.

#### **Method Overriding**

Method overriding allows a subclass to provide a specific implementation of a method that is already defined in its superclass.

**Example:**

```java
// Parent class
class Animal {
    public void sound() {
        System.out.println("Some generic animal sound");
    }
}

// Child class overriding the sound() method
class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("The dog barks.");
    }
}

// Another child class overriding the sound() method
class Cat extends Animal {
    @Override
    public void sound() {
        System.out.println("The cat meows.");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal myAnimal = new Animal(); // Animal reference, Animal object
        Animal myDog = new Dog();       // Animal reference, Dog object
        Animal myCat = new Cat();       // Animal reference, Cat object

        myAnimal.sound();  // Outputs: Some generic animal sound
        myDog.sound();     // Outputs: The dog barks.
        myCat.sound();     // Outputs: The cat meows.
    }
}
```

In this example, the `sound()` method is overridden in the `Dog` and `Cat` classes. The actual method that gets executed is determined at runtime based on the object type (`Dog` or `Cat`), even though the reference type is `Animal`.

### **Key Differences between Compile-Time and Run-Time Polymorphism**

- **Compile-Time Polymorphism**:
    - Achieved through method overloading.
    - The method to be called is resolved at compile time.
    - Cannot be achieved by changing the return type alone.

- **Run-Time Polymorphism**:
    - Achieved through method overriding.
    - The method to be called is resolved at runtime.
    - Requires inheritance (a subclass must override a method from its superclass).

### **Summary**

- **Compile-Time Polymorphism**: Achieved via method overloading, where the correct method is determined at compile time.
- **Run-Time Polymorphism**: Achieved via method overriding, where the correct method is determined at runtime based on the actual object type.

Both types of polymorphism are essential features of Java that contribute to the flexibility and reusability of code.

## Note:
The terms **compile-time polymorphism** and **run-time polymorphism** are used to describe the time at which the polymorphism is resolved in object-oriented programming.

### Compile-Time Polymorphism:
- **What it is:** Also known as **static polymorphism**, compile-time polymorphism occurs when the method or function to be invoked is determined at compile time. This is typically achieved through **method overloading** or **operator overloading**.

- **Why it's called "compile-time":** The reason it's called compile-time polymorphism is that the decision about which method to call is made by the compiler during the compilation process. The compiler knows exactly which method will be called based on the method signature (name, number of parameters, and parameter types).

- **Example:**
  ```java
  class MathOperations {
      int add(int a, int b) {
          return a + b;
      }

      double add(double a, double b) {
          return a + b;
      }
  }
  
  public class Main {
      public static void main(String[] args) {
          MathOperations mathOps = new MathOperations();
          System.out.println(mathOps.add(5, 3));        // Calls add(int, int)
          System.out.println(mathOps.add(2.5, 3.5));    // Calls add(double, double)
      }
  }
  ```

  In this example, the compiler determines which `add` method to invoke based on the arguments passed.

### Run-Time Polymorphism:
- **What it is:** Also known as **dynamic polymorphism**, run-time polymorphism occurs when the method to be invoked is determined at run time. This is typically achieved through **method overriding** in the context of inheritance.

- **Why it's called "run-time":** The reason it's called run-time polymorphism is that the decision about which method to call is made at run time, based on the actual object instance. The method that gets executed depends on the type of the object that is calling the method, which might not be known until the program is running.

- **Example:**
  ```java
  class Animal {
      void sound() {
          System.out.println("Animal makes a sound");
      }
  }

  class Dog extends Animal {
      @Override
      void sound() {
          System.out.println("Dog barks");
      }
  }

  public class Main {
      public static void main(String[] args) {
          Animal animal = new Dog(); // Polymorphism
          animal.sound(); // Calls Dog's sound method
      }
  }
  ```

  In this example, the method `sound` to be called is determined at run time, depending on the actual object type (`Dog` in this case) that the reference `animal` points to.

### Summary:
- **Compile-time polymorphism** is determined during the compilation of the code, based on method signatures.
- **Run-time polymorphism** is determined during the execution of the code, based on the actual object instance.

## Diamond problem
The **diamond problem** is a well-known issue that arises in some object-oriented programming languages that support multiple inheritance, like C++. However, in Java, which does not allow multiple inheritance for classes, the diamond problem can occur with interfaces.

### The Diamond Problem Explained:

Imagine a scenario where:
1. **Class B** and **Class C** both inherit from a common superclass, **Class A**.
2. **Class D** then inherits from both **Class B** and **Class C**.

This creates a diamond-shaped inheritance structure:

```
    A
   / \
  B   C
   \ /
    D
```

### Problem in Languages with Multiple Inheritance (like C++):

In languages that support multiple inheritance (like C++), the diamond problem occurs because **Class D** has two paths to inherit from **Class A**: one through **Class B** and another through **Class C**. This leads to ambiguity:
- If **Class A** has a method that is not overridden by **Class B** or **Class C**, should **Class D** inherit this method from **Class B** or **Class C**?
- If **Class B** and **Class C** override the method differently, which version should **Class D** inherit?

### Java and the Diamond Problem:

Java avoids the diamond problem with classes by disallowing multiple inheritance (i.e., a class cannot inherit from more than one class). However, Java allows multiple inheritance through interfaces, and this can lead to a situation that resembles the diamond problem.

#### Diamond Problem with Interfaces:

Consider the following scenario in Java:

```java
interface A {
    void display();
}

interface B extends A {
    default void display() {
        System.out.println("Display from B");
    }
}

interface C extends A {
    default void display() {
        System.out.println("Display from C");
    }
}

class D implements B, C {
    @Override
    public void display() {
        B.super.display();  // Or C.super.display(), depending on which implementation you want to use
    }
}
```

Here:
- **Interface B** and **Interface C** both extend **Interface A** and provide a default implementation of the `display` method.
- **Class D** implements both **B** and **C**.

This creates a diamond-shaped inheritance structure where **Class D** has two paths to inherit the `display` method: one through **B** and one through **C**.

#### Java's Solution to the Diamond Problem:

Java requires you to explicitly resolve this ambiguity by overriding the method in the class that implements both interfaces. In the example above, **Class D** must override the `display` method to decide which version of the method it wants to use (or provide its own implementation).

- You can choose to call one of the default methods using `B.super.display()` or `C.super.display()`.

### Summary:

- The **diamond problem** occurs in multiple inheritance scenarios where a class can inherit the same method from multiple paths, leading to ambiguity.
- In Java, the diamond problem can arise with interfaces that provide default methods.
- Java resolves this problem by requiring the class that implements multiple interfaces to explicitly override and resolve any conflicting methods.

## Abstract class

An **abstract class** in Java is a class that cannot be instantiated on its own and is meant to be subclassed by other classes. It can include both abstract methods (methods without a body that must be implemented by subclasses) and concrete methods (methods with a body that can be inherited by subclasses). Abstract classes are used to define a common template for a group of related classes, while still allowing flexibility for subclasses to provide their specific implementations.

### Key Characteristics of an Abstract Class

1. **Cannot Be Instantiated:**
    - An abstract class cannot be instantiated directly. In other words, you cannot create an object of an abstract class using the `new` keyword.
    - Example:
      ```java
      abstract class Animal {
          abstract void sound();
      }
      
      // Animal animal = new Animal(); // This will cause a compilation error
      ```

2. **Can Contain Abstract Methods:**
    - An abstract class can contain abstract methods, which are methods declared without an implementation (no method body). Subclasses of the abstract class must provide implementations for these abstract methods.
    - Example:
      ```java
      abstract class Animal {
          abstract void sound();  // Abstract method
      }
      
      class Dog extends Animal {
          @Override
          void sound() {
              System.out.println("Bark");
          }
      }
      ```

3. **Can Contain Concrete Methods:**
    - An abstract class can also contain concrete methods (methods with a body). Subclasses can inherit these methods or override them.
    - Example:
      ```java
      abstract class Animal {
          void sleep() {
              System.out.println("Sleeping...");
          }
      }
      
      class Cat extends Animal {
          @Override
          void sleep() {
              System.out.println("Cat is sleeping...");
          }
      }
      ```

4. **Can Contain Fields and Constructors:**
    - An abstract class can have fields (variables) and constructors. Subclasses can use these fields and constructors.
    - Example:
      ```java
      abstract class Animal {
          String name;
          
          Animal(String name) {
              this.name = name;
          }
          
          abstract void sound();
      }
      
      class Bird extends Animal {
          Bird(String name) {
              super(name);
          }
          
          @Override
          void sound() {
              System.out.println(name + " sings");
          }
      }
      ```

5. **Partial Implementation:**
    - An abstract class is often used when you want to provide some common functionality to multiple related classes, while still allowing those classes to implement specific behaviors.
    - Subclasses can inherit the implemented methods from the abstract class and are required to provide implementations for the abstract methods.

6. **Inheritance:**
    - Abstract classes serve as a base class in inheritance hierarchies. Subclasses inherit the properties and behaviors of the abstract class, and they can extend or modify them as needed.
    - Example:
      ```java
      abstract class Animal {
          abstract void sound();
          
          void eat() {
              System.out.println("Animal is eating...");
          }
      }
      
      class Lion extends Animal {
          @Override
          void sound() {
              System.out.println("Roar");
          }
      }
      ```

7. **Mix of Abstract and Non-Abstract Methods:**
    - Unlike interfaces, which can only contain abstract methods (before Java 8), abstract classes can have a mix of both abstract and non-abstract methods.
    - This allows the abstract class to define some general behavior that can be shared across multiple subclasses while leaving specific implementations up to the subclasses.

### Example of an Abstract Class in Java

Let's consider an example where we define an abstract class `Shape` that serves as a base class for different types of shapes like `Circle` and `Rectangle`.

```java
abstract class Shape {
    // Abstract method
    abstract double area();

    // Concrete method
    void display() {
        System.out.println("Displaying the shape");
    }
}

class Circle extends Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    double length, width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length * width;
    }
}

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        System.out.println("Area of Circle: " + circle.area());
        
        Shape rectangle = new Rectangle(4, 5);
        System.out.println("Area of Rectangle: " + rectangle.area());
    }
}
```

### Key Points in the Example:
- **Abstract Class `Shape`:** Defines an abstract method `area()` and a concrete method `display()`.
- **Concrete Classes `Circle` and `Rectangle`:** Both extend `Shape` and provide specific implementations for the `area()` method.
- **Main Method:** Creates objects of `Circle` and `Rectangle`, calculates their areas, and displays them.

### When to Use an Abstract Class:
- Use an abstract class when you have a group of related classes that should share some common behavior but still have their own specific implementations.
- When you want to enforce a common interface (set of methods) across a group of classes but also want to provide some shared code, an abstract class is a good choice.
- When you have a base class that should not be instantiated on its own because it doesn't make sense to have objects of that class, you should make it abstract.

### Summary:
An abstract class is a blueprint for other classes, providing a foundation for subclasses to build upon. It allows you to define common behavior in one place while leaving room for subclasses to provide specific implementations. Abstract classes are an essential part of the inheritance and polymorphism features in Java.

## When to use abstract class VS when to use interface?
Choosing between an abstract class and an interface in Java depends on the specific needs of your application and the design of your classes. Both abstract classes and interfaces are used to define common behaviors that multiple classes can share, but they serve different purposes and are used in different scenarios.

### **When to Use an Abstract Class**

1. **Common Base Class with Shared State:**
    - Use an abstract class when you want to define a common base class that contains shared state (fields) and behaviors (methods) that multiple related classes should inherit.
    - Abstract classes are useful when you want to provide some common code (concrete methods) that should be shared across all subclasses.

2. **Partial Implementation:**
    - If you have some common functionality that can be shared across multiple classes, and you want to enforce certain methods to be implemented by the subclasses, an abstract class is appropriate.

3. **When You Expect Future Changes:**
    - Abstract classes can be extended without breaking existing code, as you can add new methods without affecting the subclasses (since they can be concrete methods with default behavior).

4. **Single Inheritance:**
    - Since a class can extend only one abstract class, use an abstract class when you want to enforce a single-inheritance hierarchy.

#### **Example: Abstract Class**

```java
abstract class Vehicle {
    String name;
    int speed;

    Vehicle(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    // Abstract method
    abstract void move();

    // Concrete method
    void stop() {
        System.out.println(name + " has stopped.");
    }
}

class Car extends Vehicle {
    Car(String name, int speed) {
        super(name, speed);
    }

    @Override
    void move() {
        System.out.println(name + " is moving at " + speed + " km/h.");
    }
}

class Bicycle extends Vehicle {
    Bicycle(String name, int speed) {
        super(name, speed);
    }

    @Override
    void move() {
        System.out.println(name + " is pedaling at " + speed + " km/h.");
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle car = new Car("Car", 100);
        car.move();
        car.stop();

        Vehicle bicycle = new Bicycle("Bicycle", 15);
        bicycle.move();
        bicycle.stop();
    }
}
```

**Explanation:**
- `Vehicle` is an abstract class that contains shared state (name, speed) and behavior (`stop()` method) for all vehicles.
- `Car` and `Bicycle` extend `Vehicle` and provide specific implementations for the `move()` method.

### **When to Use an Interface**

1. **Defining a Contract:**
    - Use an interface when you want to define a contract or a set of methods that multiple classes should implement, regardless of where those classes exist in the class hierarchy.
    - Interfaces are ideal for specifying behaviors that can be applied to any class, whether or not they are related by inheritance.

2. **Multiple Inheritance:**
    - Since Java allows a class to implement multiple interfaces, use interfaces when you need a class to adhere to multiple types or behaviors.

3. **Loose Coupling:**
    - Interfaces promote loose coupling in your design. By depending on interfaces rather than concrete classes, you can easily swap out implementations without affecting the rest of the code.

4. **API Design:**
    - Interfaces are commonly used in API design to provide a way for different implementations to be interchangeable.

5. **Functional Interfaces (Java 8 and later):**
    - Use interfaces if you want to take advantage of functional programming features in Java, such as lambda expressions, where you can define single-method interfaces (functional interfaces).

#### **Example: Interface**

```java
interface Movable {
    void move();  // Abstract method
}

interface Stoppable {
    void stop();  // Abstract method
}

class Car implements Movable, Stoppable {
    String name;
    int speed;

    Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    @Override
    public void move() {
        System.out.println(name + " is moving at " + speed + " km/h.");
    }

    @Override
    public void stop() {
        System.out.println(name + " has stopped.");
    }
}

class Robot implements Movable {
    String model;

    Robot(String model) {
        this.model = model;
    }

    @Override
    public void move() {
        System.out.println(model + " is moving forward.");
    }
}

public class Main {
    public static void main(String[] args) {
        Movable car = new Car("Car", 100);
        car.move();

        Stoppable stoppableCar = (Stoppable) car;
        stoppableCar.stop();

        Movable robot = new Robot("Robot-X");
        robot.move();
    }
}
```

**Explanation:**
- `Movable` and `Stoppable` are interfaces that define the `move()` and `stop()` methods respectively.
- `Car` implements both `Movable` and `Stoppable` interfaces, while `Robot` implements only the `Movable` interface.
- This design allows for multiple types of objects to be treated uniformly as `Movable` objects, regardless of their underlying implementation.

### **Abstract Class vs. Interface: Key Differences**

| Feature                 | Abstract Class                                              | Interface                                                  |
|-------------------------|-------------------------------------------------------------|------------------------------------------------------------|
| **Instantiation**       | Cannot be instantiated directly                             | Cannot be instantiated directly                            |
| **Methods**             | Can have both abstract and concrete methods                 | Can have abstract methods, default methods (Java 8+), and static methods |
| **Fields**              | Can have fields (both constants and variables)              | Can have only constants (fields declared as `public static final` by default) |
| **Constructors**        | Can have constructors                                       | Cannot have constructors                                   |
| **Inheritance**         | A class can extend only one abstract class                  | A class can implement multiple interfaces                  |
| **When to Use**         | When you need to share code among closely related classes   | When you want to define a contract or role that can be applied to unrelated classes |
| **Flexibility**         | Less flexible (single inheritance)                          | More flexible (multiple inheritance)                       |

### **When to Use Both Together**

Sometimes, it might make sense to use both abstract classes and interfaces together in your design. For example, you might define a base abstract class for shared code and behavior while also implementing multiple interfaces to define various capabilities.

**Example:**

```java
interface Movable {
    void move();
}

interface Stoppable {
    void stop();
}

abstract class Vehicle implements Movable, Stoppable {
    String name;
    int speed;

    Vehicle(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    abstract void fuelType();  // Abstract method specific to the type of vehicle
}

class Car extends Vehicle {
    Car(String name, int speed) {
        super(name, speed);
    }

    @Override
    void fuelType() {
        System.out.println("This car uses gasoline.");
    }

    @Override
    public void move() {
        System.out.println(name + " is moving at " + speed + " km/h.");
    }

    @Override
    public void stop() {
        System.out.println(name + " has stopped.");
    }
}
```

In this example:
- The `Vehicle` abstract class provides a common base for vehicles, sharing fields like `name` and `speed`.
- The `Movable` and `Stoppable` interfaces define behaviors that can be implemented by any class.
- The `Car` class extends `Vehicle` and implements both interfaces.

### **Conclusion**

- Use **abstract classes** when you have a group of related classes that should share some code and state.
- Use **interfaces** when you want to define a contract that can be implemented by any class, including those that are not related.
- In some cases, combining both abstract classes and interfaces can provide a powerful design that balances shared implementation with flexibility.

## Constructor in Java

A **constructor** in Java is a special type of method used to initialize objects. When an object of a class is created, the constructor is automatically called to set up the initial state of the object. Constructors are important because they allow you to create and configure objects with specific values or settings when they are first instantiated.

### Key Characteristics of Constructors

1. **Same Name as the Class:**
    - A constructor must have the same name as the class in which it is defined.
    - Example:
      ```java
      class Dog {
          Dog() {  // Constructor
              System.out.println("Dog is created");
          }
      }
      ```

2. **No Return Type:**
    - Constructors do not have a return type, not even `void`. This is what distinguishes them from regular methods.
    - Example:
      ```java
      class Cat {
          Cat() {  // Constructor
              System.out.println("Cat is created");
          }
      }
      ```

3. **Called Automatically:**
    - Constructors are called automatically when an object is created using the `new` keyword.
    - Example:
      ```java
      class Animal {
          Animal() {
              System.out.println("Animal is created");
          }
      }
 
      public class Main {
          public static void main(String[] args) {
              Animal animal = new Animal();  // Constructor is called here
          }
      }
      ```

### Types of Constructors

There are two main types of constructors in Java:

1. **Default Constructor**
2. **Parameterized Constructor**

#### 1. Default Constructor

- A **default constructor** is a no-argument constructor that is automatically provided by Java if no other constructors are defined in the class. If you define at least one constructor, Java does not provide the default constructor.
- It initializes the object with default values (e.g., `null` for objects, `0` for integers, `false` for booleans).

**Example:**

```java
class Dog {
    String breed;
    int age;

    // Default constructor (provided by Java if not explicitly defined)
    Dog() {
        System.out.println("Dog is created");
    }

    void display() {
        System.out.println("Breed: " + breed + ", Age: " + age);
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();  // Default constructor is called
        dog.display();        // Outputs: Breed: null, Age: 0
    }
}
```

- If you define a class without any constructors, Java automatically provides a default constructor. However, if you define any constructor, the default constructor is not provided.

**Example with Explicit Default Constructor:**

```java
class Dog {
    String breed;
    int age;

    // Explicit default constructor
    Dog() {
        this.breed = "Unknown";
        this.age = 0;
        System.out.println("Dog is created with default values");
    }

    void display() {
        System.out.println("Breed: " + breed + ", Age: " + age);
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();  // Explicit default constructor is called
        dog.display();        // Outputs: Breed: Unknown, Age: 0
    }
}
```

#### 2. Parameterized Constructor

- A **parameterized constructor** is a constructor that takes arguments. It allows you to create objects with specific initial values.
- You can have multiple parameterized constructors with different parameter lists (constructor overloading).

**Example:**

```java
class Dog {
    String breed;
    int age;

    // Parameterized constructor
    Dog(String breed, int age) {
        this.breed = breed;
        this.age = age;
    }

    void display() {
        System.out.println("Breed: " + breed + ", Age: " + age);
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Labrador", 3);  // Parameterized constructor is called
        dog.display();                     // Outputs: Breed: Labrador, Age: 3
    }
}
```

**Example of Constructor Overloading:**

```java
class Dog {
    String breed;
    int age;

    // Default constructor
    Dog() {
        this.breed = "Unknown";
        this.age = 0;
    }

    // Parameterized constructor
    Dog(String breed, int age) {
        this.breed = breed;
        this.age = age;
    }

    // Another parameterized constructor with different parameters
    Dog(String breed) {
        this.breed = breed;
        this.age = 1;  // Default age
    }

    void display() {
        System.out.println("Breed: " + breed + ", Age: " + age);
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog1 = new Dog();               // Calls default constructor
        Dog dog2 = new Dog("Beagle", 2);    // Calls parameterized constructor with breed and age
        Dog dog3 = new Dog("Bulldog");      // Calls parameterized constructor with breed only

        dog1.display();  // Outputs: Breed: Unknown, Age: 0
        dog2.display();  // Outputs: Breed: Beagle, Age: 2
        dog3.display();  // Outputs: Breed: Bulldog, Age: 1
    }
}
```

### Summary

- **Constructors** are special methods used to initialize objects in Java.
- **Default Constructor**: Provided by Java or defined explicitly, takes no parameters, and initializes the object with default values.
- **Parameterized Constructor**: Takes parameters and allows for the initialization of objects with specific values.
- Constructors are called automatically when an object is created using the `new` keyword.
- Constructors do not have a return type and must have the same name as the class.
- **Constructor Overloading**: You can have multiple constructors in a class with different parameter lists to provide different ways of initializing objects.

### Note:
In Java, if a class has multiple constructors, the constructor that is called depends on the arguments passed when creating an instance of the class. The Java compiler will match the constructor call based on the number and types of arguments provided.

For example, let's say your `Animal` class has two constructors:

```java
class Animal {
    Animal() {
        System.out.println("Animal is created with no arguments");
    }

    Animal(String name) {
        System.out.println("Animal is created with name: " + name);
    }
}

public class Main {
    public static void main(String[] args) {
        Animal animal1 = new Animal();          // Calls the no-argument constructor
        Animal animal2 = new Animal("Lion");    // Calls the constructor with a String argument
    }
}
```

In this example:

- `new Animal()` will call the no-argument constructor, which prints `"Animal is created with no arguments"`.
- `new Animal("Lion")` will call the constructor that takes a `String` argument, which prints `"Animal is created with name: Lion"`.

If you try to instantiate an `Animal` object with arguments that don't match any of the constructors, the code will not compile, and you'll get a compilation error.

## Copy Constructor

In Java, a copy constructor is a special constructor used to create a new object as a copy of an existing object. This constructor takes an object of the same class as a parameter and initializes the new object with the values from the passed object.

Java does not provide a default copy constructor like C++. Instead, you need to explicitly define one if you want to perform a deep copy or to handle specific copying behavior.

Here's an example of how to implement and use a copy constructor in Java:

### Example

```java
class Person {
    String name;
    int age;

    // Parameterized constructor
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy constructor
    Person(Person other) {
        this.name = other.name;
        this.age = other.age;
    }

    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating an object using the parameterized constructor
        Person person1 = new Person("Alice", 30);
        person1.display();

        // Creating a copy of person1 using the copy constructor
        Person person2 = new Person(person1);
        person2.display();
    }
}
```

### Explanation

1. **Parameterized Constructor**: The `Person(String name, int age)` constructor initializes the `name` and `age` fields.
2. **Copy Constructor**: The `Person(Person other)` constructor creates a new `Person` object using the values from an existing `Person` object (`other`).
3. **Usage**:
    - `person1` is created using the parameterized constructor.
    - `person2` is created as a copy of `person1` using the copy constructor.

When you run this code, it will output:
```
Name: Alice, Age: 30
Name: Alice, Age: 30
```

This demonstrates that `person2` is a copy of `person1`, with the same values for `name` and `age`.

### Notes

- **Shallow Copy vs. Deep Copy**: If your class contains mutable objects (e.g., arrays or custom objects), the default copy constructor will only create a shallow copy. For a deep copy (where nested objects are also copied), you need to manually handle copying of these nested objects within the copy constructor.
- **Default Copy Behavior**: If you do not define a copy constructor, Java uses the default behavior of object copying (which performs a shallow copy).
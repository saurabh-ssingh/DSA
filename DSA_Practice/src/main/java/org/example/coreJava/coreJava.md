# Can I Run Java Programs with Only JRE Installed?

Yes, if you have only installed the Java Runtime Environment (JRE) on your system, you can run Java programs, but you cannot compile them.

## Key Points

### Running Java Programs

- The JRE is designed to run Java programs. It includes the Java Virtual Machine (JVM), core libraries, and other components necessary to execute Java applications that have already been compiled into bytecode (i.e., `.class` files).
- You can run any pre-compiled Java application (like `.jar` files or `.class` files) using the `java` command.

### Compiling Java Programs

- The JRE does not include the Java compiler (`javac`). Therefore, if you want to compile Java source code (`.java` files) into bytecode (`.class` files), you will need the Java Development Kit (JDK).
- The JDK includes both the JRE and development tools like the compiler, debugger, and other utilities required for Java development.

## Example

### Running a Java Program

- If you have a compiled `.class` file named `MyProgram.class`, you can run it using the following command:
  ```bash
  java MyProgram
  ```

### Running a Java Program

- This will work if you only have the JRE installed.

### Compiling a Java Program

- If you have a `.java` source file, you will need the JDK to compile it:
  ```bash
  javac MyProgram.java
  ```

This command requires the JDK, as the JRE alone does not include `javac`.

### Summary

- **JRE**: Allows you to run Java programs.
- **JDK**: Allows you to both compile and run Java programs.

With only the JRE installed, you can run pre-compiled Java applications, but you cannot compile Java source code.

In Java, the **String Constant Pool** (or simply **String Pool**) is a special memory region within the Java heap, where **String literals** are stored and reused. This mechanism helps in saving memory and improving performance when working with strings.

### Key Concepts of the String Constant Pool:

1. **String Literals**:
  - When you create a string using double quotes, like `String str = "Hello";`, the string `"Hello"` is stored in the String Pool.
  - If another string literal with the same content is created, like `String str2 = "Hello";`, Java will not create a new object. Instead, `str2` will reference the same object in the String Pool that `str` references.

2. **String Interning**:
  - The String Pool relies on a process called **interning**.
  - The `intern()` method can be used to add a string to the pool explicitly or to check if an equivalent string is already in the pool.
  - Example:
    ```java
    String str1 = new String("Hello");
    String str2 = str1.intern(); // str2 now points to the string in the pool
    String str3 = "Hello";
    System.out.println(str2 == str3); // true, because both refer to the same object in the pool
    ```

3. **Performance Benefits**:
  - Reusing strings from the pool avoids the overhead of creating and storing multiple string objects with the same content.
  - This can save memory and reduce the number of garbage collection cycles.

4. **Immutable Strings**:
  - Since strings in Java are immutable, they are safe to be shared across different parts of the program without the risk of accidental modification.

5. **String Creation Using `new`**:
  - If you create a string using the `new` keyword, like `String str = new String("Hello");`, it will create a new string object on the heap, not in the String Pool.
  - However, you can still intern this string using the `intern()` method.

### Example:

```java
public class StringPoolExample {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "Hello";

        // Both str1 and str2 point to the same object in the string pool
        System.out.println(str1 == str2); // true

        String str3 = new String("Hello");

        // str3 points to a different object in the heap
        System.out.println(str1 == str3); // false

        // Interning str3, making it point to the object in the string pool
        String str4 = str3.intern();
        System.out.println(str1 == str4); // true
    }
}
```

### Summary:

- The String Constant Pool is a memory optimization feature in Java.
- It stores and reuses string literals to reduce memory usage.
- String literals and interned strings reside in this pool, ensuring that identical strings are shared, thus improving efficiency.


In Java, strings are immutable, meaning that once a `String` object is created, its value cannot be changed. Any modification to a string, such as concatenation or replacement, results in the creation of a new `String` object.

### Key Characteristics of Immutable Strings

1. **Immutability**:
  - Once a `String` object is created, its value cannot be altered. If you try to modify a string, a new `String` object is created with the modified content, and the original string remains unchanged.

2. **String Pool**:
  - Java maintains a pool of strings to optimize memory usage. When you create a string literal, Java checks the string pool to see if an identical string already exists. If it does, the existing string is returned, otherwise, a new string is created and added to the pool.
  - This is possible because strings are immutable, ensuring that their value cannot change, making them safe to reuse.

3. **Thread Safety**:
  - Since strings are immutable, they are inherently thread-safe. Multiple threads can access the same string without worrying about synchronization issues or unexpected modifications.

4. **Security**:
  - Immutability also provides security benefits. For example, strings are commonly used to store sensitive information like passwords and file paths. Since strings cannot be modified, this helps prevent accidental or malicious changes.

### Example of Immutability

```java
public class ImmutableStringExample {
    public static void main(String[] args) {
        String original = "Hello";
        String modified = original.concat(" World");

        System.out.println("Original String: " + original); // Outputs: Hello
        System.out.println("Modified String: " + modified); // Outputs: Hello World
    }
}
```

In this example:
- The `concat` method does not change the original string. Instead, it creates a new `String` object with the modified value.

### Why Strings are Immutable

1. **String Pooling**:
  - Immutability enables Java to use a string pool, reducing memory consumption and improving performance by reusing string literals.

2. **Hashcode Caching**:
  - The `hashCode` of a string is cached when it is first computed, and because strings are immutable, the cached value can be reused, improving performance in operations like lookups in hash-based collections (e.g., `HashMap`).

3. **Security**:
  - Since strings often represent sensitive data, immutability ensures that once a string is created, it cannot be altered, making it more secure.

### Implications of Immutability

- **Performance**: While immutability provides many benefits, it can lead to performance issues if not used carefully. For example, concatenating strings in a loop can create many temporary `String` objects, which can be inefficient. In such cases, `StringBuilder` or `StringBuffer` should be used, as they are mutable and designed for such operations.

```java
StringBuilder sb = new StringBuilder("Hello");
sb.append(" World");
System.out.println(sb.toString()); // Outputs: Hello World
```

### Summary

- Strings in Java are immutable, meaning their value cannot be changed after they are created.
- Immutability enables string pooling, thread safety, and security benefits, making strings more efficient and reliable in various scenarios.
- For operations requiring frequent modifications, `StringBuilder` or `StringBuffer` should be used to avoid the performance overhead of creating multiple `String` objects.

In Java, both JAR (Java ARchive) and WAR (Web Application ARchive) files are packaging formats used to bundle multiple files into a single archive, but they serve different purposes and are used in different contexts.

In Java, the `String` class is immutable, meaning that once a `String` object is created, its value cannot be changed. There are several reasons why the designers of Java chose to make the `String` class immutable, and these reasons revolve around security, performance, and simplicity.

### Reasons for String Immutability

1. **Security**:
  - **Sensitive Data Protection**: Strings are frequently used to store sensitive information such as usernames, passwords, database connection URLs, etc. If strings were mutable, a change in the value of a string object holding sensitive data could lead to serious security vulnerabilities. For instance, if a string containing a password were altered, it could inadvertently expose sensitive information.
  - **Class Loading and Reflection**: Strings are used in many critical Java functions, such as class loading, reflection, and security checks. If a string could be altered, it could lead to a scenario where a string used to load a class or check permissions could be modified, potentially leading to unauthorized actions.

2. **String Pooling**:
  - **Memory Efficiency**: Java uses a concept called the string pool, which is a special memory region where `String` literals are stored. When you create a string literal, Java checks the string pool first to see if the same value already exists. If it does, the same reference is returned, saving memory. This is only possible because strings are immutable, ensuring that the stored string's value cannot change, and therefore, it can be safely reused.

3. **Thread Safety**:
  - **Inherently Thread-Safe**: Since strings cannot be modified once created, they are inherently thread-safe. Multiple threads can safely share a single string instance without the need for synchronization, which simplifies concurrent programming and reduces the overhead associated with thread management.

4. **Caching of Hashcode**:
  - **Performance Optimization**: The `hashCode` of a string is frequently used in hash-based collections like `HashMap`. Since the value of a string cannot change, the hash code is computed once and cached. This makes repeated lookups faster because the hash code does not need to be recalculated each time.

5. **Design Simplicity**:
  - **Simplifies API Design**: Making strings immutable simplifies the design and use of the Java API. Developers can pass strings around without worrying that they will be altered by other parts of the code, leading to fewer bugs and unintended side effects.

6. **Performance**:
  - **Reduced Overhead**: Because strings are immutable, the JVM can optimize their use in ways that would be impossible if strings were mutable. For instance, the JVM can safely share string objects without the overhead of having to check whether the strings have been modified.

### Example of Immutability in Action

```java
public class ImmutableStringExample {
    public static void main(String[] args) {
        String original = "Hello";
        String modified = original.concat(" World");

        System.out.println("Original String: " + original); // Outputs: Hello
        System.out.println("Modified String: " + modified); // Outputs: Hello World
    }
}
```

In this example:
- The `concat` method does not modify the original string. Instead, it creates a new `String` object with the concatenated value. The original string remains unchanged.

### Summary

- **Security**: Protects sensitive data and ensures the integrity of strings used in critical operations.
- **Memory Efficiency**: Enables string pooling, which saves memory by reusing string instances.
- **Thread Safety**: Simplifies concurrency by making strings inherently thread-safe.
- **Performance**: Optimizes performance by caching the hash code and enabling JVM optimizations.
- **Design Simplicity**: Simplifies the API and reduces the risk of bugs related to unintended modifications.

By making the `String` class immutable, Java achieves a balance of performance, security, and simplicity that is essential for building robust and efficient applications.

### 1. **JAR (Java ARchive)**
- **Purpose**:
  - A JAR file is used to package Java classes, resources (like images, properties files), and metadata (like a manifest file) into a single file that can be distributed and used as a library or a standalone application.

- **Usage**:
  - JAR files are commonly used for distributing Java libraries, command-line applications, or any Java project that does not require a web server.

- **Structure**:
  - Contains compiled `.class` files, along with optional resource files (e.g., images, text files) and a `META-INF` directory with a `MANIFEST.MF` file.

- **Execution**:
  - A JAR file can be executed if it contains a `Main-Class` entry in the `MANIFEST.MF` file, which specifies the entry point for the Java application.
  - Example command to run a JAR file:
    ```bash
    java -jar myapplication.jar
    ```

- **Examples**:
  - A library like `commons-lang3.jar` that can be added as a dependency to other projects.
  - A standalone Java application packaged as `myapp.jar`.

### 2. **WAR (Web Application ARchive)**
- **Purpose**:
  - A WAR file is used to package a web application, which includes servlets, JSP files, HTML files, JavaScript files, images, and other resources, along with compiled Java classes.

- **Usage**:
  - WAR files are specifically designed for web applications that are deployed to a Java EE (Enterprise Edition) application server (e.g., Apache Tomcat, Jetty, JBoss, WebLogic).

- **Structure**:
  - Contains a specific directory structure:
    - `WEB-INF/` directory which contains:
      - `web.xml`: The deployment descriptor for the web application.
      - `classes/`: Directory for compiled classes.
      - `lib/`: Directory for JAR files that the web application depends on.
    - `META-INF/`: Contains `MANIFEST.MF` and other metadata.
    - Static files like HTML, CSS, JavaScript, and JSP files outside of `WEB-INF/`.

- **Deployment**:
  - WAR files are deployed to a web server or application server, which extracts the contents and serves the web application.
  - Example deployment in Tomcat:
    - Place the `mywebapp.war` file in the `webapps/` directory of the Tomcat server, and it will be automatically deployed.

- **Examples**:
  - A web application like `mywebapp.war` that can be deployed on Tomcat.

### **Key Differences**

| Feature         | JAR (Java ARchive)             | WAR (Web Application ARchive)   |
|-----------------|--------------------------------|---------------------------------|
| **Purpose**     | Package Java classes and resources | Package web applications       |
| **Usage**       | Java libraries, standalone applications | Web applications               |
| **Deployment**  | Run with `java -jar` or as a library | Deployed on web/application servers |
| **Structure**   | Contains `META-INF` and classes | Contains `WEB-INF`, `META-INF`, classes, JSPs, etc. |
| **Execution**   | Can be executed as a standalone application | Requires deployment on a server |
| **Examples**    | `myapp.jar`, `commons-lang3.jar` | `mywebapp.war`, `springmvc.war` |

### Summary
- **JAR** files are general-purpose archives for packaging Java libraries or standalone applications.
- **WAR** files are specifically designed for packaging web applications that run on a web server or application server.

In Java, `String`, `StringBuffer`, and `StringBuilder` are all classes used to handle and manipulate sequences of characters. However, they have different characteristics, use cases, and performance implications. Here's a comparison of these three classes:

### 1. **String**

- **Immutability**:
  - `String` objects are immutable, meaning once a `String` object is created, its value cannot be changed. Any operation that seems to modify a string actually creates a new `String` object.

- **Thread-Safety**:
  - Since `String` is immutable, it is inherently thread-safe. Multiple threads can share a `String` object without synchronization.

- **Performance**:
  - Because `String` is immutable, operations like concatenation can lead to performance issues, especially in loops, as they create many temporary objects. For example, each concatenation creates a new `String` object.

- **Usage**:
  - Use `String` when you have a fixed sequence of characters that won't change, or when the number of modifications is minimal.

- **Example**:
  ```java
  String str = "Hello";
  str = str + " World"; // Creates a new String object "Hello World"
  ```

### 2. **StringBuffer**

- **Mutability**:
  - `StringBuffer` objects are mutable, meaning that the content of the `StringBuffer` can be modified without creating new objects.

- **Thread-Safety**:
  - `StringBuffer` is synchronized, meaning it is thread-safe. Multiple threads can safely modify a `StringBuffer` object, but this comes with the overhead of synchronization.

- **Performance**:
  - `StringBuffer` is generally faster than `String` for concatenation and other modifications because it does not create new objects. However, the synchronization overhead makes it slower than `StringBuilder` in single-threaded scenarios.

- **Usage**:
  - Use `StringBuffer` when you need to modify strings in a multi-threaded environment where thread safety is required.

- **Example**:
  ```java
  StringBuffer sb = new StringBuffer("Hello");
  sb.append(" World"); // Modifies the same StringBuffer object
  ```

### 3. **StringBuilder**

- **Mutability**:
  - Like `StringBuffer`, `StringBuilder` objects are mutable, allowing modifications without creating new objects.

- **Thread-Safety**:
  - `StringBuilder` is not synchronized, meaning it is not thread-safe. However, this makes it faster than `StringBuffer` in single-threaded scenarios.

- **Performance**:
  - `StringBuilder` is the fastest option for string manipulation in a single-threaded environment because it does not have the synchronization overhead of `StringBuffer`.

- **Usage**:
  - Use `StringBuilder` when you need to perform a lot of string modifications in a single-threaded environment.

- **Example**:
  ```java
  StringBuilder sb = new StringBuilder("Hello");
  sb.append(" World"); // Modifies the same StringBuilder object
  ```

### **Key Differences**

| Feature           | `String`                     | `StringBuffer`                | `StringBuilder`               |
|-------------------|------------------------------|--------------------------------|--------------------------------|
| **Mutability**    | Immutable                    | Mutable                        | Mutable                        |
| **Thread-Safety** | Thread-safe (due to immutability) | Thread-safe (synchronized)     | Not thread-safe (no synchronization) |
| **Performance**   | Slower for multiple modifications | Slower than `StringBuilder` due to synchronization | Fastest for single-threaded modifications |
| **Use Case**      | Fixed strings, minimal modifications | Multi-threaded environments where strings need frequent modification | Single-threaded environments with frequent modifications |

### **When to Use Each**

- **`String`**:
  - Use when you have a string that will not change or when thread safety without modification is a requirement.
  - Ideal for storing configuration keys, constant values, or any string that does not need frequent updates.

- **`StringBuffer`**:
  - Use in multi-threaded environments where you need to modify strings and thread safety is crucial.
  - Suitable for situations like logging, where multiple threads might append text to a common log string.

- **`StringBuilder`**:
  - Use in single-threaded environments where performance is a priority, and strings need frequent modifications.
  - Ideal for building strings dynamically, such as creating a SQL query or constructing large text blocks.

### **Example Usage Scenarios**

- **`String`**:
  ```java
  String greeting = "Hello, World!";
  ```

- **`StringBuffer`**:
  ```java
  StringBuffer log = new StringBuffer();
  log.append("Thread-1: Start\n");
  log.append("Thread-2: Start\n");
  ```

- **`StringBuilder`**:
  ```java
  StringBuilder query = new StringBuilder("SELECT * FROM users WHERE ");
  query.append("age > 30 AND ");
  query.append("status = 'active'");
  ```

### Summary

- **String**: Immutable, thread-safe, but slower for repeated modifications.
- **StringBuffer**: Mutable, thread-safe, and suitable for multi-threaded environments.
- **StringBuilder**: Mutable, not thread-safe, and the fastest option for single-threaded scenarios.

## Reverse a string in java

Reversing a string in Java can be done in multiple ways, depending on the use case and preference. Here are a few common methods:

### 1. **Using `StringBuilder` or `StringBuffer`**
Both `StringBuilder` and `StringBuffer` have a built-in `reverse()` method that can reverse the characters in a string.

#### Using `StringBuilder`:
```java
public class ReverseStringExample {
    public static void main(String[] args) {
        String original = "Hello World";
        StringBuilder sb = new StringBuilder(original);
        String reversed = sb.reverse().toString();
        System.out.println("Reversed String: " + reversed);
    }
}
```

#### Using `StringBuffer`:
```java
public class ReverseStringExample {
    public static void main(String[] args) {
        String original = "Hello World";
        StringBuffer sb = new StringBuffer(original);
        String reversed = sb.reverse().toString();
        System.out.println("Reversed String: " + reversed);
    }
}
```

### 2. **Using a `for` loop**
You can manually reverse the string by iterating through its characters from the end to the beginning.

```java
public class ReverseStringExample {
    public static void main(String[] args) {
        String original = "Hello World";
        String reversed = "";

        for (int i = original.length() - 1; i >= 0; i--) {
            reversed += original.charAt(i);
        }

        System.out.println("Reversed String: " + reversed);
    }
}
```

### 3. **Using Recursion**
You can reverse a string recursively by taking the last character and appending it to the reverse of the remaining substring.

```java
public class ReverseStringExample {
    public static void main(String[] args) {
        String original = "Hello World";
        String reversed = reverseString(original);
        System.out.println("Reversed String: " + reversed);
    }

    public static String reverseString(String str) {
        if (str.isEmpty()) {
            return str;
        }
        return reverseString(str.substring(1)) + str.charAt(0);
    }
}
```

### 4. **Using `char[]` Array**
You can convert the string to a character array, reverse the array, and then convert it back to a string.

```java
public class ReverseStringExample {
    public static void main(String[] args) {
        String original = "Hello World";
        char[] charArray = original.toCharArray();
        int left = 0;
        int right = charArray.length - 1;

        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }

        String reversed = new String(charArray);
        System.out.println("Reversed String: " + reversed);
    }
}
```

### 5. **Using Java 8 Streams**
With Java 8, you can use streams to reverse a string in a more functional style.

```java
import java.util.stream.Collectors;

public class ReverseStringExample {
    public static void main(String[] args) {
        String original = "Hello World";
        String reversed = original.chars()
                                  .mapToObj(c -> (char) c)
                                  .collect(Collectors.collectingAndThen(Collectors.toList(), 
                                      list -> {
                                          java.util.Collections.reverse(list);
                                          return list.stream();
                                      }))
                                  .map(String::valueOf)
                                  .collect(Collectors.joining());
        System.out.println("Reversed String: " + reversed);
    }
}
```

### Summary

- **`StringBuilder`/`StringBuffer`**: Easiest and most efficient method.
- **`for` loop**: Simple and doesn't require additional libraries, but less efficient for long strings.
- **Recursion**: Elegant but less efficient and can lead to stack overflow for very long strings.
- **`char[]` Array**: Low-level approach, efficient for in-place reversal.
- **Java 8 Streams**: Functional approach, useful if you're already using streams.


## Casting in Java

In Java, **casting** is the process of converting a variable from one type to another. Casting is necessary when you want to perform operations that involve different data types or when you want to assign a value of one type to a variable of another type. Java provides two main types of casting: **primitive casting** and **reference casting** (also known as object casting).

### **1. Primitive Casting**

Primitive casting involves converting one primitive data type into another. Java supports two types of primitive casting:

#### a. **Implicit Casting (Widening Casting)**
- **Implicit casting** happens automatically when the destination type is larger or more inclusive than the source type.
- No data loss occurs during widening casting, as you're converting to a type that can accommodate all possible values of the original type.

**Example:**
```java
public class WideningCastingExample {
    public static void main(String[] args) {
        int intValue = 100;
        double doubleValue = intValue;  // Automatic casting: int to double
        System.out.println("Int value: " + intValue);
        System.out.println("Double value: " + doubleValue);
    }
}
```

#### b. **Explicit Casting (Narrowing Casting)**
- **Explicit casting** is required when you want to convert a larger or more inclusive type into a smaller type.
- There is a potential risk of data loss, as the target type may not be able to hold the original value completely.

**Example:**
```java
public class NarrowingCastingExample {
    public static void main(String[] args) {
        double doubleValue = 9.78;
        int intValue = (int) doubleValue;  // Manual casting: double to int
        System.out.println("Double value: " + doubleValue);
        System.out.println("Int value: " + intValue);  // Fractional part is lost
    }
}
```

### **2. Reference Casting (Object Casting)**

Reference casting is used when you work with object references, particularly when you want to cast an object to a different type within the same inheritance hierarchy. Reference casting is also divided into two types:

#### a. **Upcasting**
- **Upcasting** is the process of casting a subclass object to a superclass type.
- Upcasting is implicit and doesn't require explicit syntax because you're going from a more specific type to a more general type.

**Example:**
```java
class Animal {
    void makeSound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog barks");
    }
}

public class UpcastingExample {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Animal animal = dog;  // Upcasting Dog to Animal (implicit)
        animal.makeSound();    // Animal method can be called
    }
}
```

#### b. **Downcasting**
- **Downcasting** is the process of casting a superclass reference back to a subclass type.
- Downcasting is explicit and requires an explicit cast because you're going from a general type to a more specific type.
- If the actual object is not of the target type, `ClassCastException` will be thrown.

**Example:**
```java
class Animal {
    void makeSound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog barks");
    }
}

public class DowncastingExample {
    public static void main(String[] args) {
        Animal animal = new Dog();  // Upcasting
        Dog dog = (Dog) animal;     // Downcasting (explicit)
        dog.bark();                 // Now Dog method can be called
    }
}
```

**Important Considerations:**
- **Instanceof Check**: Before performing downcasting, it's a good practice to check if the object is an instance of the target class using `instanceof` to avoid `ClassCastException`.

**Example:**
```java
if (animal instanceof Dog) {
    Dog dog = (Dog) animal;
    dog.bark();
}
```

### **Summary**

- **Primitive Casting**:
  - **Widening Casting (Implicit)**: Converts a smaller type to a larger type (e.g., `int` to `double`).
  - **Narrowing Casting (Explicit)**: Converts a larger type to a smaller type (e.g., `double` to `int`).

- **Reference Casting**:
  - **Upcasting**: Converts a subclass type to a superclass type (implicit).
  - **Downcasting**: Converts a superclass type back to a subclass type (explicit).

## Final keyword in java
The `final` keyword in Java is a versatile modifier that can be applied to variables, methods, and classes to impose specific restrictions on their usage. Here's an explanation of how `final` works in each context:

### 1. **Final Variables**

When a variable is declared with the `final` keyword, it becomes a constant, meaning its value cannot be changed once it is initialized. The `final` keyword can be used with:

- **Primitive Data Types**: Once a final primitive variable is assigned a value, it cannot be modified.
- **Reference Variables**: For final reference variables, the reference itself cannot be changed to point to another object, but the object’s internal state can still be modified.

**Example**:
   ```java
   public class FinalVariableExample {
       public static void main(String[] args) {
           final int number = 10; // A final primitive variable
           number = 20; // Error: cannot assign a value to final variable 'number'
           
           final StringBuilder sb = new StringBuilder("Hello"); // A final reference variable
           sb.append(" World!"); // Allowed: modifying the object’s state
           sb = new StringBuilder("New Object"); // Error: cannot change the reference
       }
   }
   ```

### 2. **Final Methods**

A method declared with the `final` keyword cannot be overridden by subclasses. This is useful when you want to prevent a specific method’s behavior from being altered in subclasses.

**Example**:
   ```java
   public class ParentClass {
       public final void show() {
           System.out.println("This is a final method.");
       }
   }

   public class ChildClass extends ParentClass {
       @Override
       public void show() { // Error: Cannot override the final method from ParentClass
           System.out.println("Attempting to override.");
       }
   }
   ```

### 3. **Final Classes**

A class declared as `final` cannot be subclassed, meaning no other class can extend it. This is useful when you want to prevent inheritance, ensuring that the class’s implementation remains unchanged.

**Example**:
   ```java
   public final class FinalClass {
       public void display() {
           System.out.println("This is a final class.");
       }
   }

   public class SubClass extends FinalClass { // Error: Cannot subclass the final class 'FinalClass'
   }
   ```

### 4. **Final Parameters**

The `final` keyword can also be applied to method parameters. When a parameter is declared as `final`, it cannot be reassigned within the method.

**Example**:
   ```java
   public class FinalParameterExample {
       public void display(final int number) {
           number = number + 10; // Error: cannot assign a value to final variable 'number'
       }
   }
   ```

### 5. **Final and Immutability**

While `final` is often associated with immutability, it doesn’t guarantee that an object is immutable. The `final` keyword only prevents reassignment, not modification. To achieve immutability, a combination of `final` and careful design is required, such as making all fields private and final, and not providing any methods that modify the state.

### 6. **Final and Performance**

- **Compiler Optimizations**: The `final` keyword can help the Java compiler perform certain optimizations, especially with final methods, as the compiler knows these methods won’t be overridden.
- **Inlining**: The JVM may choose to inline calls to final methods, reducing method call overhead.

### Summary

- **Final Variables**: Immutable once assigned.
- **Final Methods**: Cannot be overridden in subclasses.
- **Final Classes**: Cannot be extended by other classes.
- **Final Parameters**: Cannot be reassigned within the method.

The `final` keyword is an important tool in Java for creating constants, controlling inheritance, and ensuring that certain methods or classes cannot be altered, which can lead to more predictable and secure code.

## Static keyword in java

The `static` keyword in Java is used to define class-level methods and variables. It means that the particular member belongs to the class itself, rather than to instances of the class. Here's a detailed explanation of how the `static` keyword works in various contexts:

### 1. **Static Variables (Class Variables)**

- **Definition**: When a variable is declared as `static`, it belongs to the class rather than any instance of the class. All instances of the class share the same static variable.
- **Initialization**: Static variables are initialized only once when the class is first loaded into memory.
- **Access**: Static variables can be accessed using the class name directly, without creating an instance of the class.

**Example**:
   ```java
   public class StaticVariableExample {
       public static int counter = 0; // Static variable

       public StaticVariableExample() {
           counter++;
       }

       public static void main(String[] args) {
           StaticVariableExample obj1 = new StaticVariableExample();
           StaticVariableExample obj2 = new StaticVariableExample();
           
           System.out.println(StaticVariableExample.counter); // Output: 2
       }
   }
   ```
In this example, `counter` is a static variable, so it is shared across all instances of `StaticVariableExample`.

### 2. **Static Methods**

- **Definition**: Static methods belong to the class rather than any instance of the class. They can be called without creating an object of the class.
- **Limitations**: Static methods cannot access instance variables or instance methods directly because they belong to the class level, not to a specific instance. They can only directly access static variables and other static methods.
- **Use Cases**: Static methods are often used for utility or helper functions that do not require any object state.

**Example**:
   ```java
   public class StaticMethodExample {
       public static int add(int a, int b) {
           return a + b;
       }

       public static void main(String[] args) {
           int sum = StaticMethodExample.add(5, 10); // Static method call
           System.out.println("Sum: " + sum); // Output: Sum: 15
       }
   }
   ```
In this example, the `add` method is static, so it can be called directly using the class name without creating an object of `StaticMethodExample`.

### 3. **Static Blocks (Static Initializer Blocks)**

- **Definition**: A static block is a block of code that gets executed when the class is loaded into memory. It is used to initialize static variables or to perform static setup.
- **Execution Order**: Static blocks are executed in the order they appear in the class, before any static variables or methods are accessed.

**Example**:
   ```java
   public class StaticBlockExample {
       public static int number;

       static {
           number = 100;
           System.out.println("Static block executed.");
       }

       public static void main(String[] args) {
           System.out.println("Number: " + number); // Output: Number: 100
       }
   }
   ```
In this example, the static block is executed when the class is loaded, initializing the `number` variable.

### 4. **Static Classes (Nested Static Classes)**

- **Definition**: In Java, you cannot declare a top-level class as `static`, but you can declare a nested class as `static`. A static nested class does not have access to the instance variables and methods of the outer class.
- **Use Cases**: Static nested classes are often used when the nested class doesn’t need access to the outer class's instance members.

**Example**:
   ```java
   public class OuterClass {
       static int outerStaticVariable = 10;

       static class NestedStaticClass {
           public void display() {
               System.out.println("Outer static variable: " + outerStaticVariable);
           }
       }

       public static void main(String[] args) {
           OuterClass.NestedStaticClass nested = new OuterClass.NestedStaticClass();
           nested.display(); // Output: Outer static variable: 10
       }
   }
   ```
In this example, `NestedStaticClass` is a static nested class that can access static members of the outer class.

### Summary

- **Static Variables**: Belong to the class, shared by all instances, initialized only once.
- **Static Methods**: Belong to the class, can be called without creating an instance, cannot access instance variables/methods directly.
- **Static Blocks**: Used for static initialization, executed when the class is loaded.
- **Static Nested Classes**: Can be declared static, do not have access to instance variables/methods of the outer class.

The `static` keyword in Java is essential for creating class-level members that are shared across all instances or are independent of any instance, allowing for memory efficiency and better organization of utility functions.

## Super keyword in java
The `super` keyword in Java is a reference variable that is used to refer to the immediate parent class object. It is commonly used in object-oriented programming to access methods, variables, and constructors of the superclass (parent class) from a subclass (child class). The `super` keyword is very useful in cases where the subclass has overridden a method of the superclass or when the subclass needs to call a constructor from the superclass.

### Uses of the `super` Keyword

1. **Accessing Superclass Constructor**
2. **Accessing Superclass Methods**
3. **Accessing Superclass Variables**

Let's go through each use case with examples:

### 1. Accessing Superclass Constructor

When a subclass inherits a superclass, the constructor of the superclass is not automatically called unless explicitly done so using the `super` keyword. You can use `super()` to call the constructor of the superclass from the subclass.

#### Example:

```java
class Animal {
    String name;

    // Superclass constructor
    Animal(String name) {
        this.name = name;
        System.out.println("Animal constructor called");
    }
}

class Dog extends Animal {
    String breed;

    // Subclass constructor
    Dog(String name, String breed) {
        // Calling superclass constructor
        super(name);
        this.breed = breed;
        System.out.println("Dog constructor called");
    }

    void display() {
        System.out.println("Name: " + name + ", Breed: " + breed);
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Buddy", "Golden Retriever");
        dog.display();
    }
}
```

**Output:**

```
Animal constructor called
Dog constructor called
Name: Buddy, Breed: Golden Retriever
```

In this example, `super(name)` calls the constructor of the superclass `Animal`, initializing the `name` field before the `Dog` class's constructor executes.

### 2. Accessing Superclass Methods

If a subclass overrides a method from the superclass, the overridden method in the subclass can still access the superclass's version of the method using the `super` keyword.

#### Example:

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

    void makeSound() {
        // Calling the superclass method
        super.sound();
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.sound(); // Calls overridden method in Dog class
        dog.makeSound(); // Calls superclass method in Animal class
    }
}
```

**Output:**

```
Dog barks
Animal makes a sound
```

In this example, the `Dog` class overrides the `sound()` method of the `Animal` class. By using `super.sound()`, the `makeSound()` method in the `Dog` class calls the `sound()` method from the `Animal` class.

### 3. Accessing Superclass Variables

If a subclass has a variable with the same name as a variable in its superclass, the subclass can use the `super` keyword to access the superclass's variable, while using `this` or just the variable name would refer to the subclass's variable.

#### Example:

```java
class Animal {
    String name = "Animal";
}

class Dog extends Animal {
    String name = "Dog";

    void display() {
        System.out.println("Name in superclass: " + super.name);
        System.out.println("Name in subclass: " + this.name);
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.display();
    }
}
```

**Output:**

```
Name in superclass: Animal
Name in subclass: Dog
```

In this example, the `Dog` class has a `name` variable that hides the `name` variable in the `Animal` class. By using `super.name`, the `Dog` class can access the `name` variable from the `Animal` class.

### Key Points to Remember:

- **Constructor Call:** The `super()` call to the superclass constructor must be the first statement in the subclass constructor. If not explicitly called, Java automatically inserts a no-argument `super()` call to the parent constructor unless the parent class doesn't have a no-argument constructor, in which case you must explicitly call one of the parent's constructors.
- **Method Access:** You can use `super` to invoke a method from the superclass that has been overridden in the subclass.
- **Variable Access:** `super` can also be used to access a hidden variable from the superclass when a subclass declares a variable with the same name.

The `super` keyword is a fundamental part of inheritance in Java, helping maintain and extend the functionality of classes in a clear and controlled manner.

## Synchronized keyword in java

The `synchronized` keyword in Java is used to control the access of multiple threads to shared resources. It ensures that only one thread can access a synchronized block or method at a time, which helps prevent thread interference and consistency problems when multiple threads interact with shared data.

### Key Concepts

1. **Synchronization of Methods**
2. **Synchronization of Blocks**
3. **Object-Level Lock vs. Class-Level Lock**
4. **Reentrant Locks**

Let's explore each of these concepts in detail:

### 1. Synchronization of Methods

When a method is declared with the `synchronized` keyword, the thread holding the lock for that method's object can execute it. Other threads attempting to execute any synchronized method on the same object must wait until the lock is released.

#### Example:

```java
class Counter {
    private int count = 0;

    // Synchronized method
    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Final count: " + counter.getCount());
    }
}
```

**Output:**

```
Final count: 2000
```

In this example, the `increment()` method is synchronized, ensuring that only one thread can increment the `count` variable at a time, preventing race conditions.

### 2. Synchronization of Blocks

If only a part of a method needs to be synchronized, you can use a synchronized block. This approach is more efficient than synchronizing the entire method, as it reduces the scope of synchronization, thereby allowing more concurrency.

#### Example:

```java
class Counter {
    private int count = 0;

    public void increment() {
        // Synchronized block
        synchronized (this) {
            count++;
        }
    }

    public int getCount() {
        return count;
    }
}
```

In this case, only the increment operation is synchronized, which can be more efficient if other parts of the method do not require synchronization.

### 3. Object-Level Lock vs. Class-Level Lock

- **Object-Level Lock:** When you synchronize a non-static method or a block on the `this` object, it locks the instance of the class. Only one thread can execute any synchronized instance method on that object.

- **Class-Level Lock:** When you synchronize a static method or block, it locks the class itself, which is shared among all instances of the class. This means only one thread can execute any synchronized static method or block for that class, across all instances.

#### Example:

```java
class Counter {
    private static int count = 0;

    // Synchronized static method
    public static synchronized void increment() {
        count++;
    }

    public static int getCount() {
        return count;
    }
}
```

Here, the `increment()` method is synchronized at the class level. This ensures that only one thread can increment the static `count` variable, regardless of how many instances of `Counter` exist.

### 4. Reentrant Locks

Java's synchronization is reentrant, meaning that if a thread holds the lock for an object, it can enter other synchronized blocks or methods on the same object without getting blocked.

#### Example:

```java
class Display {
    public synchronized void method1() {
        System.out.println("In method1");
        method2();
    }

    public synchronized void method2() {
        System.out.println("In method2");
    }
}

public class Main {
    public static void main(String[] args) {
        Display display = new Display();
        display.method1();
    }
}
```

**Output:**

```
In method1
In method2
```

In this example, `method1()` calls `method2()`, which is also synchronized. The thread that holds the lock on the `Display` object is allowed to enter `method2()` without releasing the lock.

### Key Points to Remember:

- **Performance:** Synchronization can slow down the performance of a program because it introduces overhead by controlling thread access.
- **Deadlock:** Careless use of synchronization can lead to deadlock, where two or more threads are waiting indefinitely for each other to release locks.
- **Best Practices:** Synchronize only the critical sections of code that modify shared resources to avoid unnecessary performance degradation.

The `synchronized` keyword is essential in multithreading to ensure that shared resources are accessed in a thread-safe manner, preventing data inconsistencies and race conditions.

## Volatile keyword in java

The `volatile` keyword in Java is used to indicate that a variable's value will be modified by different threads. It ensures that the value of the `volatile` variable is always read from the main memory and not from a thread's local cache, ensuring that all threads see the most recent value of the variable.

### Key Features of `volatile`

1. **Visibility**:
  - The primary purpose of `volatile` is to guarantee visibility of changes to variables across threads. Without `volatile`, if one thread updates a variable, other threads might not see the updated value immediately because they might be working with a cached copy of the variable.
  - When a variable is declared as `volatile`, every read and write operation on that variable is performed directly on the main memory, ensuring that the latest value is visible to all threads.

2. **No Caching**:
  - Normally, the JVM can cache variables in the CPU registers or thread-local memory to improve performance. However, for `volatile` variables, the JVM is instructed not to cache the variable but to always read its value from the main memory.

3. **No Reordering**:
  - The `volatile` keyword prevents instruction reordering by the compiler or the CPU. This is important because reordering can cause issues in a multithreaded environment. Declaring a variable as `volatile` ensures that reads and writes to that variable happen in the exact order specified in the code.

### Example of `volatile`

Consider the following example where `volatile` is necessary:

```java
class VolatileExample extends Thread {
    private volatile boolean running = true;

    public void run() {
        while (running) {
            // Some logic here
        }
        System.out.println("Thread stopped running.");
    }

    public void stopRunning() {
        running = false;
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileExample thread = new VolatileExample();
        thread.start();

        // Allow the thread to run for a while
        Thread.sleep(1000);

        // Stop the thread
        thread.stopRunning();
    }
}
```

In this example:

- The `running` variable is declared as `volatile`.
- The `run()` method continuously checks the `running` flag in a loop.
- The `stopRunning()` method sets `running` to `false`, intending to stop the loop.

**Without `volatile`**:
- The `running` flag might be cached by the thread, and the update made by `stopRunning()` might not be immediately visible to the running thread. This could cause the loop to continue indefinitely.

**With `volatile`**:
- The change made to the `running` variable by `stopRunning()` is immediately visible to the running thread, so the loop stops as expected.

### When to Use `volatile`

- **Flags**: When you have a boolean flag that controls whether a thread should keep running, like in the example above.
- **State Indicators**: For variables that act as indicators of the state or condition in a multithreaded environment.
- **Simple Counters**: For simple counters that do not involve compound operations (though atomic types might be preferable).

### Limitations of `volatile`

- **No Atomicity**: `volatile` does not guarantee atomicity for compound operations. For example, operations like `x++` (read-modify-write) are not atomic, even if `x` is `volatile`. For atomic operations, you should use `synchronized` blocks or classes from the `java.util.concurrent.atomic` package, like `AtomicInteger`.

- **No Mutual Exclusion**: `volatile` does not provide mutual exclusion. If you need to prevent multiple threads from accessing a block of code at the same time, you should use the `synchronized` keyword or a `Lock`.

### Summary

- **Visibility Guarantee**: `volatile` ensures that the most up-to-date value of a variable is visible to all threads.
- **No Caching**: Variables declared as `volatile` are not cached; they are read from and written to the main memory directly.
- **No Instruction Reordering**: Prevents the compiler and the CPU from reordering instructions involving `volatile` variables, ensuring predictable execution order.

The `volatile` keyword is an essential tool in Java for ensuring that changes to variables are visible across threads, making it a critical component in writing correct multithreaded programs. However, it should be used carefully, as it does not provide atomicity or mutual exclusion.
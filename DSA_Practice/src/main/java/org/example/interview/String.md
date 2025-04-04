# Java String Interview Questions

## Basic Questions:

1. **What is a `String` in Java? How is it different from `StringBuffer` and `StringBuilder`?**
    - `String`: Immutable sequence of characters.
    - `StringBuffer`: Thread-safe, mutable sequence of characters.
    - `StringBuilder`: Non-thread-safe but faster, mutable sequence of characters.

   Example:
   ```java
   String str = "Hello";
   StringBuffer sb = new StringBuffer("Hello");
   StringBuilder sbd = new StringBuilder("Hello");
   ```

2. **How are `String` objects stored in memory in Java?**
    - Strings are stored in the **String Pool** to save memory by reusing objects.

   Example:
   ```java
   String str1 = "Hello";
   String str2 = "Hello"; // str1 and str2 share the same memory in the String Pool.
   ```

3. **Why are `String` objects immutable in Java?**
    - Security, performance, and thread-safety benefits.

   Example:
   ```java
   String str = "Hello";
   str.concat(" World");
   System.out.println(str); // Output: "Hello"
   ```

4. **Explain the concept of the String Pool in Java.**
    - A pool of strings maintained by the JVM to reuse identical string literals.

   Example:
   ```java
   String str1 = "Hello";
   String str2 = "Hello";
   System.out.println(str1 == str2); // Output: true (same reference)
   ```

5. **How do you compare two strings in Java?**
    - `==`: Checks reference equality.
    - `equals()`: Checks content equality.

   Example:
   ```java
   String str1 = new String("Hello");
   String str2 = new String("Hello");
   System.out.println(str1 == str2); // Output: false
   System.out.println(str1.equals(str2)); // Output: true
   ```

6. **What’s the difference between `equals()` and `compareTo()`?**
    - `equals()`: Boolean result indicating equality.
    - `compareTo()`: Integer result indicating lexical comparison.

   Example:
   ```java
   String str1 = "apple";
   String str2 = "banana";
   System.out.println(str1.equals(str2)); // Output: false
   System.out.println(str1.compareTo(str2)); // Output: -1
   ```

---

## Intermediate Questions:

7. **How can you concatenate strings in Java?**
    - `+`, `concat()`, `StringBuilder`, or `StringBuffer`.

   Example:
   ```java
   String str1 = "Hello";
   String str2 = " World";
   String result = str1 + str2;
   System.out.println(result); // Output: "Hello World"
   ```

8. **How can you convert a `String` to an array of characters?**
    - Using `toCharArray()`. Example:
   ```java
   String str = "Hello";
   char[] arr = str.toCharArray();
   for (char c : arr) {
       System.out.print(c + " ");
   }
   // Output: H e l l o
   ```

9. **How do you convert a `String` to uppercase or lowercase?**
    - `toUpperCase()` and `toLowerCase()` methods.

   Example:
   ```java
   String str = "Hello";
   System.out.println(str.toUpperCase()); // Output: HELLO
   System.out.println(str.toLowerCase()); // Output: hello
   ```

10. **How can you check if a `String` contains a particular substring?**
    - `contains()`, `indexOf()`, or `matches()` methods.

    Example:
    ```java
    String str = "Hello World";
    System.out.println(str.contains("World")); // Output: true
    ```

11. **Explain the `intern()` method.**
    - Moves the string to the String Pool and returns the pooled reference.

    Example:
    ```java
    String str1 = new String("Hello");
    String str2 = str1.intern();
    System.out.println(str1 == str2); // Output: false
    ```

12. **How does the `split()` method work in Java?**
    - Splits a string based on a regex pattern and returns an array of substrings.

    Example:
    ```java
    String str = "a,b,c";
    String[] arr = str.split(",");
    for (String s : arr) {
        System.out.println(s);
    }
    ```

13. **How do you remove leading and trailing whitespaces from a string?**
    - `trim()`, `strip()`, `stripLeading()`, and `stripTrailing()` methods.

    Example:
    ```java
    String str = "  Hello  ";
    System.out.println(str.trim()); // Output: "Hello"
    ```

14. **How can you check if a `String` is empty or null?**
    - `isEmpty()`, `length() == 0`, or `Objects.isNull()`.

    Example:
    ```java
    String str = "";
    System.out.println(str.isEmpty()); // Output: true
    ```

15. **What is the difference between `String.trim()`, `strip()`, `stripLeading()`, and `stripTrailing()`?**
    - `trim()`: Removes leading and trailing spaces.
    - `strip()`: Removes all types of whitespace.
    - `stripLeading()`: Removes leading whitespace.
    - `stripTrailing()`: Removes trailing whitespace.

    Example:
    ```java
    String str = "  Hello  \u2002";
    System.out.println(str.strip()); // Output: "Hello"
    ```

---

## Advanced Questions:

16. **What are the performance differences between `String`, `StringBuilder`, and `StringBuffer`?**
    - `String`: Slow due to immutability.
    - `StringBuilder`: Fast but not thread-safe.
    - `StringBuffer`: Thread-safe but slower.

    Example:
    ```java
    StringBuilder sb = new StringBuilder("Hello");
    sb.append(" World");
    System.out.println(sb); // Output: "Hello World"
    ```

17. **How does the `replace()` method work in Java?**
    - Replaces all occurrences of a character or substring with another.

    Example:
    ```java
    String str = "Hello World";
    System.out.println(str.replace("World", "Java")); // Output: "Hello Java"
    ```

18. **How would you reverse a string in Java?**
    - `StringBuilder.reverse()` or manual iteration.

    Example:
    ```java
    String str = "Hello";
    String reversed = new StringBuilder(str).reverse().toString();
    System.out.println(reversed); // Output: "olleH"
    ```

19. **What is the difference between `String.getBytes()` and `String.toCharArray()`?**
    - `getBytes()`: Returns a byte array.
    - `toCharArray()`: Returns a character array.

    Example:
    ```java
    String str = "Hello";
    byte[] bytes = str.getBytes();
    char[] chars = str.toCharArray();
    ```

20. **What is the use of the `format()` method in Java?**
    - Formats a string using placeholders (e.g., `%s`, `%d`).

    Example:
    ```java
    String formatted = String.format("%s is %d years old", "John", 30);
    System.out.println(formatted); // Output: "John is 30 years old"
    ```

21. **Explain the `String.valueOf()` method and its purpose.**
    - Converts any object to its string representation.

    Example:
    ```java
    int num = 10;
    String str = String.valueOf(num);
    System.out.println(str); // Output: "10"
    ```

22. **What is a `StringJoiner` in Java?**
    - A utility class for joining strings with a delimiter.

    Example:
    ```java
    StringJoiner joiner = new StringJoiner(", ");
    joiner.add("Apple").add("Banana").add("Cherry");
    System.out.println(joiner); // Output: "Apple, Banana, Cherry"
    ```

23. **How does the `matches()` method work for regular expressions in Java?**
    - Checks if the string matches the given regex.

    Example:
    ```java
    String str = "abc123";
    System.out.println(str.matches("\\w+\\d+")); // Output: true
    ```

24. **How can you split a string by multiple delimiters?**
    - Use `split()` with regex (e.g., `split("[,|;|\\s]")`).

    Example:
    ```java
    String str = "apple,banana;cherry";
    String[] fruits = str.split(",|;");
    ```

25. **How does Java handle substring operations? Are they memory-efficient?**
    - Newer Java versions create new objects for substrings, ensuring efficiency.

    Example:
    ```java
    String str = "Hello World";
    String sub = str.substring(0, 5);
    System.out.println(sub); // Output: "Hello"
    ```

---

## Scenario-Based Questions:

26. **How would you count the occurrence of a particular character in a `String`?**
    - Iterate through the string and increment a counter for each match.

    Example:
    ```java
    String str = "Hello World";
    char target = 'o';
    int count = 0;
    for (char c : str.toCharArray()) {
        if (c == target) {
            count++;
        }
    }
    System.out.println(count); // Output: 2
    ```

27. **How can you remove all vowels from a `String`?**
    - Use `replaceAll("[aeiouAEIOU]", "")`.

    Example:
    ```java
    String str = "Hello World";
    String result = str.replaceAll("[aeiouAEIOU]", "");
    System.out.println(result); // Output: "Hll Wrld"
    ```

28. **Write a program to check if a `String` is a palindrome.**
    ```java
    public boolean isPalindrome(String str) {
        String reversed = new StringBuilder(str).reverse


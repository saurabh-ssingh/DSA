In Java, you can create arrays in a few different ways. Here are some common methods:

### 1. Declaring and Initializing an Array
You can declare and initialize an array in one line or separately.

**One Line Initialization:**

```java
int[] array = {1, 2, 3, 4, 5};
```

**Separate Declaration and Initialization:**

```java
int[] numbers;           // Declare
numbers = new int[5];    // Initialize with size 5

// Assign values later
numbers[0] = 1;
numbers[1] = 2;
// and so on...

```

### 2. Creating Arrays of Objects
You can also create arrays of objects:

```java
String[] names = {"Alice", "Bob", "Charlie"};
```

### 3. Multidimensional Arrays
Java supports multidimensional arrays, such as 2D arrays:

**Declaration and Initialization:**

```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};
```

**Separate Declaration and Initialization:**
```java
int[][] matrix = new int[3][3];  // 3x3 matrix
matrix[0][0] = 1;
matrix[0][1] = 2;
// and so on...

```

### 4. Using the new Keyword
You can create an array with the new keyword:

```java
int[] numbers = new int[5]; // Creates an array of integers with 5 elements
numbers[0] = 10;            // Assign values later

```

**Accessing Array Elements:**

You can access array elements using their index:
```java
int firstElement = numbers[0];  // Accesses the first element
numbers[1] = 20;                // Modifies the second element

```
**Iterating Over Arrays:**
You can iterate over arrays using loops:

* For Loop:
```java
for(int i = 0; i < numbers.length; i++) {
    System.out.println(numbers[i]);
}

```
* Enhanced For Loop (For-each):
```java
for(int number : numbers) {
    System.out.println(number);
}

```

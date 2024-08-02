## Hashing in Java

Hashing in Java refers to the process of converting an input (or key) into a fixed-size string of bytes, typically for the purpose of indexing data. This is done using a hash function, which takes the input and returns a hash code. This hash code is then used to index an array of buckets or slots, where the data associated with the input is stored.

### Key Concepts of Hashing

- **Hash Function**: A function that takes an input (or key) and returns a hash code, which is typically an integer. A good hash function should distribute inputs uniformly across the hash table to minimize collisions.

- **Hash Code**: The integer result produced by the hash function. It determines the index where the data will be stored in the hash table.

- **Buckets**: The array or list where data is stored. Each bucket can hold multiple entries in case of collisions.

- **Collisions**: Occur when two different inputs produce the same hash code. There are various methods to handle collisions, such as chaining and open addressing.

### How Hashing Works in Java

#### Hash Function

Java uses the `hashCode()` method to generate a hash code for objects. The `hashCode()` method is defined in the `Object` class, and every Java object inherits this method. Classes can override this method to provide their own hash code implementation.

```java
@Override
public int hashCode() {
    int hash = 7;
    hash = 31 * hash + (name == null ? 0 : name.hashCode());
    hash = 31 * hash + age;
    return hash;
}

```
In this example, the `hashCode()` method uses the fields `name` and `age` to compute a hash code. The `hash` variable is initialized to 7 and then multiplied by 31, a common prime number used to generate hash codes, and the fields' hash codes are added.

The modulo hash function is a simple and commonly used hash function that helps distribute entries across an array (or hash table). It works by taking the hash code of a key and applying the modulo operation to determine the index in the hash table where the key-value pair should be stored.

### How It Works

1. **Hash Code Calculation**: Compute the hash code for the key. This is usually done using the `hashCode()` method in Java, which generates an integer based on the key.

2. **Modulo Operation**: Apply the modulo operation with the size of the hash table to the hash code. This gives an index in the range of the hash table's size.

#### Formula

If `h` is the hash code of the key and `N` is the size of the hash table, the index `i` is computed as:

\[ i = h \mod N \]

Here, `i` is the index where the key-value pair will be placed in the hash table.

#### Example

Suppose you have a hash table with 10 buckets (i.e., size `N` is 10), and you want to insert a key-value pair with the hash code of the key being 123456.

- **Compute Index**:

\[ i = 123456 \mod 10 = 6 \]

- **Store**: Place the key-value pair in bucket 6 of the hash table.

#### Code Example

Here's an example of how you might implement a simple hash table using the modulo hash function in Java:
```java
import java.util.LinkedList;

public class SimpleHashTable {
  private static final int SIZE = 10; // Size of the hash table
  private LinkedList<Entry>[] table;

  public SimpleHashTable() {
    table = new LinkedList[SIZE];
    for (int i = 0; i < SIZE; i++) {
      table[i] = new LinkedList<>();
    }
  }

  public void put(int key, String value) {
    int index = hashFunction(key);
    table[index].add(new Entry(key, value));
  }

  public String get(int key) {
    int index = hashFunction(key);
    for (Entry entry : table[index]) {
      if (entry.key == key) {
        return entry.value;
      }
    }
    return null;
  }

  private int hashFunction(int key) {
    return key % SIZE;
  }

  private static class Entry {
    int key;
    String value;

    Entry(int key, String value) {
      this.key = key;
      this.value = value;
    }
  }

  public static void main(String[] args) {
    SimpleHashTable hashTable = new SimpleHashTable();
    hashTable.put(1, "One");
    hashTable.put(2, "Two");
    hashTable.put(12, "Twelve"); // This will hash to the same bucket as 2

    System.out.println(hashTable.get(1)); // Output: One
    System.out.println(hashTable.get(12)); // Output: Twelve
  }
}

```



### HashTable and HashMap

- **Hashtable**: A synchronized implementation of a hash table.
- **HashMap**: A part of the Java Collections Framework, HashMap is an implementation of the Map interface and uses hashing for storing key-value pairs. It is not synchronized.

```java
import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        // Creating a HashMap
        HashMap<Integer, String> map = new HashMap<>();

        // Adding key-value pairs to the HashMap
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        // Retrieving a value using its key
        String value = map.get(2);
        System.out.println("Value at key 2: " + value);

        // Checking if a key is present
        boolean containsKey = map.containsKey(3);
        System.out.println("Contains key 3: " + containsKey);

        // Checking if a value is present
        boolean containsValue = map.containsValue("Two");
        System.out.println("Contains value 'Two': " + containsValue);

        // Removing a key-value pair
        map.remove(1);

        // Printing the size of the map
        System.out.println("Size of map: " + map.size());
    }
}

```

# Array of Linked Lists

An array of linked lists is a data structure that combines the properties of both arrays and linked lists. Here's a breakdown of what each component contributes and how they work together:

## Array

- **Fixed Size (Capacity):** An array has a fixed size, meaning it can store a predefined number of elements. In the context of a hash map, the array's size is typically referred to as the number of "buckets".
- **Index-Based Access:** Elements in an array can be accessed quickly using their index. This allows for fast retrieval of a specific bucket in a hash map.

## Linked List

- **Dynamic Size:** A linked list can grow or shrink dynamically, allowing it to store a variable number of elements.
- **Sequential Access:** Elements in a linked list are accessed sequentially, meaning you need to traverse the list from the beginning to access or search for an element.

## Array of Linked Lists

When you combine these two data structures, you get an array where each element is a linked list. This combination is often used in hash maps to handle collisions (situations where multiple keys hash to the same index). Here’s how it works in a hash map:

### Hashing

When a key-value pair is added to the hash map, a hash function computes an index based on the key. This index determines which bucket (i.e., which linked list in the array) the key-value pair should go into.

### Buckets

Each element of the array is a linked list that can store multiple key-value pairs. This is useful for handling collisions because multiple pairs can be stored in the same bucket.

### Chaining

When a collision occurs (multiple keys hash to the same index), the key-value pairs are added to the linked list at that index. This method is called "chaining."

## Example Visualization

Here's a simple visualization of an array of linked lists:

```rust
Array (buckets)          Linked Lists (nodes in each bucket)
+---+    0    --->   [Node(key1, value1)] -> [Node(key2, value2)] -> null
|   |
+---+    1    --->   [Node(key3, value3)] -> null
|   |
+---+    2    --->   null
|   |
+---+    3    --->   [Node(key4, value4)] -> [Node(key5, value5)] -> null
|   |
+---+

```

In this example:

- The array has four buckets (indexed from 0 to 3).
- Bucket 0 has a linked list with two nodes.
- Bucket 1 has a linked list with one node.
- Bucket 2 is empty (null).
- Bucket 3 has a linked list with two nodes.

## Code Example

In your code, the array of linked lists is represented by the bucket array, where each element is a `LinkedList<Node>`:

```java
private LinkedList<Node>[] bucket;

private void initBucket(int N) {
    bucket = new LinkedList[N];
    for (int i = 0; i < bucket.length; i++) {
        bucket[i] = new LinkedList<>();
    }
}

```

- The bucket array is initialized with `N` buckets.
- Each bucket is an empty `LinkedList<Node>`, ready to store nodes (key-value pairs) when collisions occur.
- This structure allows your hash map to handle collisions efficiently by storing colliding key-value pairs in linked lists within the appropriate buckets.

## Steps to Retrieve the Value Associated with a Specified Key in the Map

### Calculate the Index

- Use the hash function to compute the index of the bucket where the key might be stored. This is done by taking the hash code of the key and using modulo operation with the bucket array length.

```java
int bucketIndex = hashFunc(key);
```

### Access the Bucket

- Retrieve the linked list (bucket) at the computed index in the bucket array.

```java
LinkedList<Node> currentBucket = bucket[bucketIndex];
```

### Search for the Key
- Traverse the linked list to find the node with the specified key. This is done using the searchInBucket method, which returns the index of the node in the linked list or -1 if the key is not found.

```java
int entryIndex = searchInBucket(currentBucket, key);
```

### Check if Key Exists

- If the index returned by searchInBucket is not -1, the key exists in the map.

```java

if (entryIndex != -1) {
    Node currentNode = currentBucket.get(entryIndex);
    return currentNode.value;
}

```

### Return the Value or null

- If the key exists, retrieve and return the value associated with the key.
- If the key does not exist, return null.
package org.example.hashTable;

import java.util.LinkedList;

/**
 * This class provides a basic implementation of a hash map using an array of linked lists.
 *
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 */
public class HashMapImplementation {

  /**
   * A nested class representing the hash map with key-value pairs.
   *
   * @param <K> the type of keys maintained by this map
   * @param <V> the type of mapped values
   */
  static class MyHashMap<K,V> {

    /**
     * The default capacity of the bucket array.
     */
    public static final int DEFAULT_CAPACITY = 4;

    /**
     * The default load factor of the hash map.
     */
    public static final float DEFAULT_LOAD_FACTOR = 0.75f;

    /**
     * A nested class representing a node in the hash map, which holds a key-value pair.
     */
    private class Node {
      K key;
      V value;

      /**
       * Constructs a new node with the specified key and value.
       *
       * @param key the key
       * @param value the value
       */
      Node(K key, V value) {
        this.key = key;
        this.value = value;
      }
    }

    private int n; // number of entries in the map
    private LinkedList<Node>[] bucket;

    /**
     * Initializes the bucket array with the specified capacity.
     *
     * @param N the capacity size of the bucket array
     */
    private void initBucket(int N) {
      bucket = new LinkedList[N];
      for (int i = 0; i < bucket.length; i++) {
        bucket[i] = new LinkedList<>();
      }
    }

    /**
     * Computes the hash code for the specified key.
     *
     * @param key the key
     * @return the hash code for the key
     */
    private int hashFunc(K key) {
      int hashCode = key.hashCode();
      return (Math.abs(hashCode)) % bucket.length;
    }

    /**
     * Constructs a new hash map with the default capacity.
     */
    public MyHashMap() {
      initBucket(DEFAULT_CAPACITY);
    }

    /**
     * Searches for the specified key in the given bucket.
     *
     * @param ll the linked list representing the bucket
     * @param key the key to search for
     * @return the index of the key in the bucket, or -1 if not found
     */
    private int searchInBucket(LinkedList<Node> ll, K key) {
      for (int i = 0; i < ll.size(); i++) {
        if (ll.get(i).key == key) {
          return i;
        }
      }
      return -1;
    }

    /**
     * Returns the number of entries in the map.
     *
     * @return the number of entries in the map
     */
    public int size() {
      return n;
    }

    /**
     * Associates the specified value with the specified key in this map.
     * If the map previously contained a mapping for the key, the old value is replaced.
     *
     * @param key the key with which the specified value is to be associated
     * @param value the value to be associated with the specified key
     */
    public void put(K key, V value) {
      int bi = hashFunc(key);
      LinkedList<Node> currBucket = bucket[bi];
      int ei = searchInBucket(currBucket, key);
      if (ei == -1) { // key does not exist, we have to insert new node
        Node newNode = new Node(key, value);
        currBucket.add(newNode);
        n++;
      } else {
        Node currentNode = currBucket.get(ei);
        currentNode.value = value;
      }
    }


    /**
     * Retrieves the value associated with the specified key in the map.
     *
     * @param key the key whose associated value is to be returned
     * @return the value associated with the specified key, or null if the key does not exist in the map
     */
    public V get(K key) {
      // Calculate the index for the given key using the hash function
      int bucketIndex = hashFunc(key);

      // Get the bucket (linked list) at the calculated index
      LinkedList<Node> currentBucket = bucket[bucketIndex];

      // Search for the key in the current bucket
      int entryIndex = searchInBucket(currentBucket, key);

      // If the key exists, retrieve and return the associated value
      if (entryIndex != -1) {
        Node currentNode = currentBucket.get(entryIndex);
        return currentNode.value;
      }

      // If the key does not exist, return null
      return null;
    }

  }



  public static void main(String[] args) {
    // Test the hash map implementation here
  }
}

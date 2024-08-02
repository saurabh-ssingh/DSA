package org.example.hashTable;

public class HashTable {
  private int size = 7;
  private Node[] datamap;

  class Node{
    String key;
    int value;
    Node next;
    Node(String key,int value){
      this.key = key;
      this.value = value;
    }
  }

}

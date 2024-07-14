package org.example.stack.implementation;

public class LinkedListImplementation {
  public static class Node{
    int value;
    Node next;
    Node(int value){
      this.value = value;
    }

    public static class LLStack{
      Node head = null;
      int size = 0;
      void push(int x){
        Node newNode = new Node(x);
      }
    }
  }

}

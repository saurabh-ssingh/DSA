package org.example.queue.implementation;

public class LinkedListImplementationQueue {
  /**
   * Represents a node in a singly linked list.
   */
  public static class Node {
    int value;   // Value stored in the node
    Node next;   // Reference to the next node in the list

    /**
     * Constructor to create a new node with the given value.
     * @param value The integer value to be stored in the node.
     */
    Node(int value) {
      this.value = value;
    }
  }


  /**
   * Implementation of a queue using a singly linked list.
   */
  public static class QueueLL {
    Node head = null;   // Points to the first node in the queue
    Node tail = null;   // Points to the last node in the queue
    int size = 0;       // Number of elements in the queue

    /**
     * Adds an element to the end of the queue.
     * @param data The integer value to be added to the queue.
     */
    public void add(int data) {
      Node newNode = new Node(data);   // Create a new node with the given data
      if (size == 0) {
        // If the queue is empty, initialize both head and tail to newNode
        head = tail = newNode;
      } else {
        // Otherwise, append newNode to the end of the queue
        tail.next = newNode;
        tail = newNode;   // Update tail to point to the new last node
      }
      size++;   // Increment the size of the queue
    }

    /**
     * Removes and returns the front element of the queue.
     * If the queue is empty, prints a message and returns -1.
     * @return The value of the removed front element in the queue, or -1 if the queue is empty.
     */
    public int remove() {
      if (size == 0) {
        System.out.println("Queue is empty");
        return -1;
      } else {
        int removedValue = head.value;  // Store the value of the current head
        head = head.next;  // Move the head pointer to the next node (removing the current head)
        size--;  // Decrease the size of the queue
        return removedValue;  // Return the removed value
      }
    }

    /**
     * Retrieves the value of the front element of the queue without removing it.
     * If the queue is empty, prints a message and returns -1.
     * @return The value of the front element in the queue, or -1 if the queue is empty.
     */
    public int peek() {
      if (size == 0) {
        System.out.println("Queue is empty");
        return -1;
      } else {
        return head.value;  // Return the value of the current head (front element)
      }
    }

    /**
     * Displays all elements currently in the queue.
     * If the queue is empty, prints a message indicating so.
     */
    public void display() {
      if (size == 0) {
        System.out.println("Queue is empty");
        return;
      }
      Node currentNode = head;
      while (currentNode != null) {
        System.out.print(currentNode.value + " ");
        currentNode = currentNode.next;
      }
      System.out.println();
    }


    public boolean isEmpty(){
      if(size == 0){
        return true;
      }else {
        return false;
      }
    }


  }

}

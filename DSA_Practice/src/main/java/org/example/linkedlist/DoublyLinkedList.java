package org.example.linkedlist;

import java.util.NoSuchElementException;

/**
 * A class representing a doubly linked list data structure.
 */
public class DoublyLinkedList {
  Node head;
  Node tail;
  private int size;

  /**
   * A class representing a node in a doubly linked list.
   */
  public static class Node {
    int value;
    Node next;
    Node previous;

    /**
     * Constructs a new node with the specified value.
     *
     * @param value the value of the new node
     */
    public Node(int value) {
      this.value = value;
    }
  }

  /**
   * Inserts a new node with the specified value at the tail of the list.
   *
   * @param value the value of the new node
   */
  public void insertAtTail(int value) {
    Node newNode = new Node(value);
    if (head == null) {
      head = newNode;
    } else {
      tail.next = newNode;
      newNode.previous = tail;
    }
    tail = newNode;
    size++;
  }

  /**
   * Inserts a new node with the specified value at the head of the list.
   *
   * @param value the value of the new node
   */
  public void insertAtHead(int value) {
    Node newNode = new Node(value);
    newNode.next = head;
    if (head != null) {
      head.previous = newNode;
    }
    head = newNode;
    size++;
  }

  /**
   * Inserts a new node with the specified value at the specified position in the list.
   *
   * @param value    the value of the new node
   * @param position the position at which to insert the new node
   * @throws IllegalArgumentException if the position is less than or equal to 0 or greater than the length of the list
   */
  public void insertAt(int value, int position) {
    if (position <= 0) {
      throw new IllegalArgumentException("Position must be greater than 0.");
    }

    if (position == 1) {
      insertAtHead(value);
      size++;
      return;
    }

    Node currentNode = head;
    for (int i = 1; currentNode != null && i < position - 1; i++) {
      currentNode = currentNode.next;
    }

    if (currentNode == null) {
      throw new IllegalArgumentException("Position is greater than the length of the list.");
    }

    Node newNode = new Node(value);
    Node nextNode = currentNode.next;
    newNode.next = nextNode;
    currentNode.next = newNode;
    newNode.previous = currentNode;

    if (nextNode != null) {
      nextNode.previous = newNode;
    }
    size++;
  }

  /**
   * Displays the elements of the list from head to tail.
   */
  public void display() {
    Node currentNode = head;
    while (currentNode != null) {
      System.out.print(currentNode.value + " ");
      currentNode = currentNode.next;
    }
    System.out.println();
  }

  /**
   * Displays the elements of the list from tail to head.
   */
  public void displayRev() {
    Node currentNode = tail;
    while (currentNode != null) {
      System.out.print(currentNode.value + " ");
      currentNode = currentNode.previous;
    }
    System.out.println();
  }

  /**
   * Displays the elements of the list starting from a random node to the end of the list.
   *
   * @param random the node from which to start displaying the list
   */
  public void displayFrom(Node random) {
    // Move to the head of the list from the random node
    while (random.previous != null) {
      random = random.previous;
    }

    // Display from the current random node to the end
    Node currentNode = random;
    while (currentNode != null) {
      System.out.print(currentNode.value + " ");
      currentNode = currentNode.next;
    }
    System.out.println();
  }

  /**
   * Retrieves the value of the node at the specified position in the list.
   *
   * @param position the position of the node whose value is to be retrieved
   * @return the value of the node at the specified position
   */
  public int getAt(int position) {
    Node currentNode = head;
    for (int i = 1; i < position; i++) {
      currentNode = currentNode.next;
    }
    return currentNode.value;
  }


  /**
   * Removes and returns the value of the first node in the doubly linked list.
   * Throws NoSuchElementException if the list is empty.
   *
   * @return The value of the removed first node.
   * @throws NoSuchElementException If the list is empty.
   */
  public int removeFirst() {
    // Check if the list is empty
    if (head == null) {
      throw new NoSuchElementException("List is empty");
    }

    // Case 1: List has only one node
    if (head.next == null) {
      int x = head.value;
      head = null; // Remove the only node
      tail = null; // Update tail as list is now empty
      size--;
      return x;
    }

    // Save the value of the current head node
    int x = head.value;

    // Move head to the next node
    head = head.next;

    // Update previous reference of the new head to null
    if (head != null) {
      head.previous = null;
    } else {
      tail = null; // If head is null, a list becomes empty, update tail
    }
    size--;
    return x; // Return the value of the removed first node
  }


  /**
   * Removes and returns the value of the last node in the doubly linked list.
   * Throws NoSuchElementException if the list is empty.
   *
   * @return The value of the removed last node.
   * @throws NoSuchElementException If the list is empty.
   */
  public int removeLast() {
    // Check if the list is empty
    if (head == null) {
      throw new NoSuchElementException("List is empty");
    }

    // Case 1: List has only one node
    if (head.next == null) {
      int x = head.value;
      head = null; // Remove the only node
      tail = null; // Update tail as list is now empty
      size--;
      return x;
    }

    // Case 2: List has more than one node
    Node currentNode = tail; // Start from the current tail node
    int x = currentNode.value; // Save the value of the current tail node

    tail = tail.previous; // Move tail to its previous node
    if (tail != null) {
      tail.next = null; // Update the next reference of the new tail to null
    } else {
      head = null; // If tail is null, list becomes empty, update head
    }
    size--;
    return x; // Return the value of the removed last node
  }

  public int removeAt(int position) {
    if (position < 0 || position >= size) {
      throw new IndexOutOfBoundsException("Invalid position");
    }

    // Check if the list is empty
    if (head == null) {
      throw new NoSuchElementException("List is empty");
    }

    int removedValue;

    // Case 1: Remove from the head
    if (position == 0) {
      removedValue = removeFirst();
    } else if (position == size - 1) {
      // Case 2: Remove from the tail
      removedValue = removeLast();
    } else {
      // Case 3: Remove from other positions
      Node current = head;
      int index = 0;

      // Traverse to the node at the specified position
      while (index < position) {
        current = current.next;
        index++;
      }

      removedValue = current.value;
      current.previous.next = current.next;
      current.next.previous = current.previous;
      size--;
    }

    return removedValue;
  }



  /**
   * The main method to demonstrate the functionality of the DoublyLinkedList class.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    DoublyLinkedList dll = new DoublyLinkedList();
    dll.insertAtTail(45);
    dll.insertAtTail(65);
    dll.insertAtTail(18);
    dll.insertAtTail(78);
    dll.insertAtTail(65);

    dll.display();

    System.out.println("Last node ==> " + dll.removeLast());
    dll.display();
  }
}

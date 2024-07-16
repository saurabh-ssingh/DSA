package org.example.stack.implementation;

/**
 * Implementation of a stack using a linked list.
 */
public class LinkedListImplementation {

  /**
   * Node class representing each element in the linked list.
   */
  public static class Node {
    int value;
    Node next;

    /**
     * Constructor to create a new node.
     *
     * @param value The value to be stored in the node.
     */
    Node(int value) {
      this.value = value;
    }

    /**
     * LLStack class representing the stack implemented using a linked list.
     */
    public static class LLStack {
      Node head = null;
      int size = 0;

      /**
       * Pushes a value onto the stack.
       *
       * @param x The value to be pushed onto the stack.
       */
      private void push(int x) {
        Node newNode = new Node(x);
        newNode.next = head;
        head = newNode;
        size++;
      }

      /**
       * Displays the elements in the stack.
       */
      private void display() {
        Node temp = head;
        while (temp != null) {
          System.out.print(temp.value + " ");
          temp = temp.next;
        }
        System.out.println();
      }

      /**
       * Returns the size of the stack.
       *
       * @return The size of the stack.
       */
      private int size() {
        return size;
      }

      /**
       * Pops the topmost value from the stack.
       *
       * @return The value popped from the stack. Returns -1 if the stack is empty.
       */
      private int pop() {
        if (head == null) {
          System.out.println("Stack is empty");
          return -1;
        }
        int x = head.value;
        head = head.next;
        size--;
        return x;
      }

      /**
       * Peeks at the topmost value of the stack without removing it.
       *
       * @return The topmost value of the stack. Returns -1 if the stack is empty.
       */
      private int peek() {
        if (head == null) {
          System.out.println("Stack is empty");
          return -1;
        }
        return head.value;
      }

      /**
       * Checks if the stack is empty.
       *
       * @return True if the stack is empty, false otherwise.
       */
      private boolean isEmpty() {
        return size == 0;
      }

      /**
       * Main method to demonstrate the functionality of the stack.
       *
       * @param args Command line arguments (not used).
       */
      public static void main(String[] args) {
        LLStack ll = new LLStack();
        ll.push(25);
        ll.push(30);
        ll.push(78);
        ll.display();
        System.out.println("Topmost element " + ll.peek());
        System.out.println("Removing topmost element " + ll.pop());
        ll.display();
        System.out.println("Size of linked list " + ll.size);
        System.out.println("Check linked list is empty " + ll.isEmpty());
      }
    }
  }
}

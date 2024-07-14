package org.example.stack.implementation;

/**
 * Implementation of a stack using an array.
 */
public class ArrayImplementation {

  /**
   * Stack class to demonstrate stack operations using an array.
   */
  public static class Stack {

    private final int[] arr = new int[5];
    private int idx = 0;

    /**
     * Main method to demonstrate stack operations.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
      Stack st = new Stack();
      st.push(1);
      System.out.println("Size of stack: " + st.size());
    }

    /**
     * Pushes an element onto the stack.
     *
     * @param x the element to be pushed onto the stack
     */
    private void push(int x) {
      if (isFull()) {
        System.out.println("Stack is full");
        return;
      }
      arr[idx] = x;
      idx++;
    }

    /**
     * Returns the top element of the stack without removing it.
     *
     * @return the top element of the stack, or -1 if the stack is empty
     */
    private int peek() {
      if (idx == 0) {
        System.out.println("Stack is empty");
        return -1;
      }
      return arr[idx - 1];
    }

    /**
     * Removes the top element of the stack and returns it.
     *
     * @return the top element of the stack, or -1 if the stack is empty
     */
    private int pop() {
      if (idx == 0) {
        System.out.println("Stack is empty");
        return -1;
      }
      int top = arr[idx - 1];
      arr[idx - 1] = 0;
      idx--;
      return top;
    }

    /**
     * Displays the elements of the stack.
     */
    private void display() {
      for (int i = 0; i < idx; i++) {
        System.out.print(arr[i] + " ");
      }
      System.out.println();
    }

    /**
     * Returns the current size of the stack.
     *
     * @return the number of elements in the stack
     */
    private int size() {
      return idx;
    }

    /**
     * Checks if the stack is empty.
     *
     * @return {@code true} if the stack is empty, {@code false} otherwise
     */
    private boolean isEmpty() {
      return idx == 0;
    }

    /**
     * Checks if the stack is full.
     *
     * @return {@code true} if the stack is full, {@code false} otherwise
     */
    private boolean isFull() {
      return idx == arr.length;
    }

    /**
     * Returns the capacity of the stack.
     *
     * @return the maximum number of elements the stack can hold
     */
    private int capacity() {
      return arr.length;
    }
  }
}

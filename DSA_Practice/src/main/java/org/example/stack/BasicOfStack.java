package org.example.stack;

import java.util.Stack;

/**
 * Demonstrates basic operations of a Stack in Java.
 */
public class BasicOfStack {

  /**
   * The main method where the stack operations are performed.
   *
   * @param args Command line arguments (not used in this example).
   */
  public static void main(String[] args) {
    // Creating a stack of integers
    Stack<Integer> st = new Stack<>();

    // Pushing elements onto the stack
    st.push(1); //O(1)
    st.push(98);
    st.push(98);

    // Printing the stack contents
    System.out.println(st);

    // Popping the top element from the stack
    st.pop(); //O(1)

    // Printing the stack contents after pop
    System.out.println(st);

    // Peeking the top element of the stack
    System.out.println(st.peek()); //O(1)
    System.out.println("Size :" + st.size());

    while (st.size()>1){
      st.pop();
    }
    System.out.println(st);
    System.out.println(st.empty());
  }

  //Time complexity of getting an element from stack is O(n) and  space complexity O(n)
}


package org.example.stack.question;

import java.util.Stack;

public class CopyContentFromStack {

  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    stack.push(1);
    stack.push(100);
    stack.push(50);
    stack.push(90);
    stack.push(78);

    System.out.println("Original stack : " + stack);
    Stack<Integer> tempStack = new Stack<>();
    while (stack.size()>0){
      int x = stack.peek();
      tempStack.push(x);
      stack.pop();
    }
    System.out.println("Reverse stack : " + tempStack);

    Stack<Integer> copiedStack = new Stack<>();
    while (tempStack.size()>0){
      int x = tempStack.peek();
      copiedStack.push(x);
      tempStack.pop();
    }
    System.out.println("Copied stack : " + copiedStack );
  }

  //Time Complexity: O(n)
  //Space Complexity: O(n)

}

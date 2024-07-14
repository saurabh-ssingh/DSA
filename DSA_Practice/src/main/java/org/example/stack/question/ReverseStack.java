package org.example.stack.question;

import java.util.Stack;
public class ReverseStack {

  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    stack.push(1);
    stack.push(100);
    stack.push(50);
    stack.push(90);
    stack.push(78);

    System.out.println("Original stack :" + stack);

    Stack<Integer> tempStack = new Stack<>();
    while (stack.size()>0){
      tempStack.push(stack.pop());
    }

    System.out.println("Temporary stack : " + tempStack);

    Stack<Integer> secondTempStack = new Stack<>();
    while (tempStack.size()>0){
      secondTempStack.push(tempStack.pop());
    }

    System.out.println("Second temporary stack : " + secondTempStack);

    while (secondTempStack.size()>0){
      stack.push(secondTempStack.pop());
    }
    System.out.println("Original reverse stack : " + stack);
  }

  // TODO Reverse your stack using recursion

}

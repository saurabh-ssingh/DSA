package org.example.stack.question;

import java.util.Stack;
public class DisplayStack {
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
      tempStack.push(stack.pop());
    }

    while (tempStack.size()>0){
      int x = tempStack.pop();
      System.out.print(x + " ");
      stack.push(x);
    }

    System.out.println("Original stack : " + stack);

    //TODO try above question by array
    //TODO display reverse stack using recursion
    //TODO push at bottom using recursion
  }
}

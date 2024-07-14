package org.example.stack.question;

import java.util.Stack;

public class PushAtBottom {
  public static void main(String[] args) {
    int x = 77;
    Stack<Integer> stack = new Stack<>();
    stack.push(1);
    stack.push(100);
    stack.push(50);
    stack.push(90);
    stack.push(78);

   System.out.println("Origin stack : " + stack);
//    Stack<Integer> tempStack = new Stack<>();
//    while (stack.size() > 0) {
//      tempStack.push(stack.pop());
//    }
//    System.out.println("Temporary stack : " + tempStack);
//
//    stack.push(x);
//    while (tempStack.size() > 0) {
//      stack.push(tempStack.pop());
//    }
//
//    System.out.println("Original stack after insertion : " + stack);
    pushAtBottom(stack,x);
    System.out.println("Original stack after insertion : " + stack);

  }


  //TODO push an number at bottom of stack using recursion
  public static void pushAtBottom(Stack<Integer> stack, int x){
    if(stack.isEmpty()){
      stack.push(x);
      return;
    }
    int top = stack.pop();
    pushAtBottom(stack,x);
    stack.push(top);
  }
}

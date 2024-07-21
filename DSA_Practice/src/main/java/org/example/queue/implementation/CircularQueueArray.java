package org.example.queue.implementation;

public class CircularQueueArray {

  public static class CQA {

    int front = -1;
    int rear = -1;
    int size = 0;
    int[] arr = new int[5];

    public void add(int value) throws Exception {
      if (size == arr.length) {
        throw new Exception("Queue is full");
      } else if (size == 0) {
        front = rear = 0;
        arr[rear] = value;
        return;
      } else if (rear < arr.length - 1) {
        arr[++rear] = value;
      } else if (rear == arr.length - 1) {
        rear = 0;
        arr[0] = value;
      }
      size++;
    }

    public int remove() throws Exception {
      if (size == 0) {
        throw new Exception("Size is empty");
      } else {
        int value = arr[front];
        if (front == arr.length - 1) {
          front = 0;
        } else {
          front++;
        }
        size--;
        return value;
      }

    }

    public int peek() throws Exception {
      if (size == 0){
        throw new Exception("Queue is empty");
      }else {
        return arr[front];
      }
    }

    public boolean isEmpty(){
      if(size == 0){
        return true;
      }else {
        return false;
      }
    }

    public void display(){
      if(size == 0){
        System.out.println("Queue is empty");
      } else if (front<= rear) {
        for (int i = front;i<=rear;i++){
          System.out.print(arr[i]+ " ");
        }
      }else {
        for (int i=front;i<=rear;i++){
          System.out.print(arr[i]+ " ");
        }
        for(int i=0;i<=rear;i++){
          System.out.print(arr[i]+ " ");
        }
      }
      System.out.println();
    }
  }

}

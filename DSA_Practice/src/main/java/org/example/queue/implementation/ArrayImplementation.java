package org.example.queue.implementation;

public class ArrayImplementation {
  public static class QueueArray{
    private int front = -1;
    private int rear = -1;
    int size = 0;
    int[] arr = new int[100];

    public void add(int value){
      if(rear == arr.length-1){
        System.out.println("Queue is full");
        return;
      }
      if(front == -1){
        front = 0;
        rear = 0;
        arr[0] = value;
      }else{
       // arr[++rear] = value;
        arr[rear+1]=value;
        rear ++;
      }
      size++;
    }

    public int remove(){
      if(size == 0){
        System.out.println("Queue is empty");
        return -1;
      }
      int x = arr[front];
      front ++;
      size--;
      return x;
    }

    public int peek(){
      if(size == 0){
        System.out.println("Queue is empty");
        return -1;
      }
      return arr[front];
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
        return;
      }else {
        for (int i = front;i<=rear;i++){
          System.out.print(arr[i]+ " ");
        }
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    QueueArray queueArray = new QueueArray();
    System.out.println(queueArray.isEmpty());
    queueArray.display();
    queueArray.add(5);
    queueArray.add(25);
    System.out.println("Size : " + queueArray.size);
    queueArray.display();
    queueArray.add(42);
    queueArray.add(78);
    queueArray.display();
    System.out.println("Peek : " +queueArray.peek());
    queueArray.remove();
    queueArray.display();
    System.out.println(queueArray.isEmpty());

  }

}

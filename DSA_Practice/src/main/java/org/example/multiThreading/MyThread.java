package org.example.multiThreading;

public class MyThread extends Thread{
  public MyThread(String threadName){
    super(threadName);
  }
  @Override
  public void run() {
    System.out.println("Current thread :" + Thread.currentThread().getName());
  }

  public static void main(String[] args) throws InterruptedException {
    MyThread myThread = new MyThread("thread-1");
    myThread.start(); //start execution of my thread
    myThread.join(); //makes the main thread (which is executing the main method) wait until the myThread has finished its execution
    System.out.println("Thread inside main method : " + Thread.currentThread().getName());
  }
}

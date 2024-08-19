package org.example.multiThreading;

public class MyThread1 implements Runnable{

  @Override
  public void run() {
    System.out.println("MyThread class thread : " + Thread.currentThread().getName());
  }

  public static void main(String[] args) {
    MyThread1 myThread1 = new MyThread1();
    Thread thread = new Thread(myThread1);
    thread.start();
  }
}

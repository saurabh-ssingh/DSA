package org.example.multiThreading;

public class ThreadPriority extends Thread{
  public ThreadPriority(String name){
    super(name);
  }

  @Override
  public void run() {
    System.out.println("Thread is running");
    for(int i=1;i<=5;i++){
      for(int j=0;j<5;j++){
        System.out.println(Thread.currentThread().getName() + " - Priority: " + Thread.currentThread().getPriority() + " - count: " + i);
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    }
  }

  public static void main(String[] args) {
    ThreadPriority l = new ThreadPriority("Low priority thread");
    ThreadPriority m = new ThreadPriority("Medium priority thread");
    ThreadPriority n = new ThreadPriority("High priority thread");
    l.setPriority(Thread.MIN_PRIORITY);
    m.setPriority(Thread.NORM_PRIORITY);
    n.setPriority(Thread.MAX_PRIORITY);
    l.start();
    m.start();
    n.start();
  }
}

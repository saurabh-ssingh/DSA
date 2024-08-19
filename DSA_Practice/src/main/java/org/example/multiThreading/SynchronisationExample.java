package org.example.multiThreading;

class Counter {
  private int count = 0; // shared resource

  public synchronized void increment() {
    count++;
  }

  public int getCount() {
    return count;
  }
}

public class SynchronisationExample extends Thread {
  private Counter counter;

  public SynchronisationExample(Counter counter) {
    this.counter = counter;
  }

  @Override
  public void run() {
    for (int i = 0; i < 1000; i++) {
      counter.increment();
    }
  }

  public static void main(String[] args) {
    Counter counter = new Counter();
    SynchronisationExample t1 = new SynchronisationExample(counter);
    SynchronisationExample t2 = new SynchronisationExample(counter);
    t1.start();
    t2.start();
    try {
      t1.join();
      t2.join();
    }catch (Exception e){

    }
    System.out.println(counter.getCount()); // Expected: 2000, Actual will be random <= 2000
  }
}
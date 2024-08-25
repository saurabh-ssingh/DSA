package org.example.multiThreading.executer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task implements Runnable{
  private String name;
  public Task(String name){
    this.name=name;
  }
  @Override
  public void run() {
    System.out.println(name + " is being executed by " + Thread.currentThread().getName());
  }
}
public class ExecuterExample3 {
  public static void main(String[] args) throws InterruptedException {
    // Create a fixed thread pool with 3 threads
    ExecutorService executorService = Executors.newFixedThreadPool(3);
    // Submit tasks for execution
    for (int i = 1; i <= 5; i++) {
      Runnable task = new Task("Task " + i);
      executorService.submit(task);
    }

    // Shut down the executor service
    executorService.shutdown();
  }
}

package org.example.multiThreading.executer;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExecutorExample {

  public static void main(String[] args) {
    Executor executor = Executors.newSingleThreadExecutor();
    executor.execute(() -> System.out.println(
        "Task is running inside thread " + Thread.currentThread().getName()));
    
  }

}

package org.example.multiThreading.executer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample2 {

  public static void main(String[] args) {
    ExecutorService executorService =Executors.newFixedThreadPool(9);
  }

}

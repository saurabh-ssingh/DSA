package org.example.queue;

import java.util.LinkedList;
import java.util.Queue;

public class BasicQueue {
  public static void main(String[] args) {
    Queue<Integer> q = new LinkedList<>();
    q.add(12);
    q.add(78);
    q.add(45);
    q.add(99);
    q.add(16);
    System.out.println(q);
    System.out.println("q.removed()  :" + q.remove());
    q.remove();
    System.out.println(q);
    System.out.println("q.poll()  :" + q.poll());
    q.poll();
    System.out.println(q);
  }

}

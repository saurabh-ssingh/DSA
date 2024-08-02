package org.example.linkedlist.Question;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListVsArrayList {

  // Question which list takes less time LinkedList or ArrayList
  public static void main(String[] args) {
    List<Integer> list = new LinkedList<>();
    //List<Integer> list = new ArrayList<>();
    for(int i = 0;i<10000;i++){
      list.add(i);
    }

    long startTime = System.currentTimeMillis();
    for(int i=0;i<10000;i++){
      list.remove(0);
    }
    long endTime = System.currentTimeMillis();

    System.out.println("Time taken " + (endTime - startTime) + " ms");
  }

}

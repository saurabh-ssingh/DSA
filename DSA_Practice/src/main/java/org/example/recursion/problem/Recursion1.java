package org.example.recursion.problem;

public class Recursion1 {
  private int sum(int n){
    int sum = 0;
    for(int i=0;i<n;i++){
      sum = sum + i;
    }

    sum(n);
    return sum;


  }

  public static void main(String[] args) {
    Recursion1 recursion1 = new Recursion1();
    int sum = recursion1.sum(10);
    System.out.println("Sum of first n natual number " + sum);
  }

}

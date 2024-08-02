package org.example.random;

public class CharArray {


  public static void main(String[] args) {
    final String var = "Random String";
    final char[] characterArray= var.toCharArray();
    System.out.println("length of string ===> " + var.length());
    for (int i=0;i<characterArray.length;i++){
      System.out.print(characterArray[i] + ",");
    }
    System.out.println();
  }

}

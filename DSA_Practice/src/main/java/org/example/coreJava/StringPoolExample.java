package org.example.coreJava;

public class StringPoolExample {
  public static void main(String[] args) {
    String str1 = "Hello";
    String str2 = "Hello";
    System.out.println(str1 == str2);
    String str3 = new String("Hello");
    System.out.println(str1 == str3);
    String str4 = str3.intern();
    System.out.println(str1 == str4);
  }
}

package org.example.coreJava;
class Test{
   int a = 10;
   String s = "Saurabh";
   void display(){
    System.out.println("Test display method ");
  }
}

class A extends Test{
  public static void main(String[] args) {
    A obj = new A();
    obj.a = 20;
    obj.s = "Singh";
    System.out.println(obj.a);
    System.out.println(obj.s);

  }
}





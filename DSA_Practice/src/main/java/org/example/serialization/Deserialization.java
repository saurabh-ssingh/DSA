package org.example.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Deserialization {

  public static void main(String[] args) {
    Person person = new Person();
    person.id = 1;
     person.name = "Saurabh";

    try {
      FileOutputStream fileOutputStream = new FileOutputStream("/home/saurabhs/Documents/code/DSA/DSA_Practice/src/main/java/org/example/serialization/sample.txt");
      ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
      objectOutputStream.writeObject(person);
      objectOutputStream.flush();


      ObjectInputStream in=new ObjectInputStream(new FileInputStream("/home/saurabhs/Documents/code/DSA/DSA_Practice/src/main/java/org/example/serialization/sample.txt"));
      Person newper=(Person)in.readObject();
      System.out.println("The ID of the Person is "+newper.id);
      System.out.println("The name of the Person is "+newper.name);

    } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
    } catch (IOException e) {
      throw new RuntimeException(e);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
}
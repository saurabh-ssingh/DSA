package org.example.serialization;

import java.io.Serializable;

public class Person implements Serializable {
  public int id;
  transient public String name;

}

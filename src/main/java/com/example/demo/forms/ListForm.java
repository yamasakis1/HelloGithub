package com.example.demo.forms;

public class ListForm {
  public String name;
  public int price;

  public ListForm(String name, int price) {
    this.name = name;
    this.price = price;
  }

  //getterSetter

  public String getName() {
    return name;
  }
  public int getPrice() {
    return price;
  }
  public void setName(String name) {
    this.name = name;
  }
  public void setPrice(int price) {
    this.price = price;
  }

}

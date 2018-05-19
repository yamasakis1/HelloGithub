package com.example.demo.data;

public class Order {
  public Item item;
  public int num;
  public String name;

//  public Order(Item item,int num) {
  public void userOrder(Item item,int num) {
    this.item = item;
    this.num = num;
  }

  //getterとSetter

  public Item getItem() {
    return item;
  }
  public int getNum() {
    return this.num;
  }
  public String getname() {
    return name;
  }
  public void setItem(Item item) {
    this.item = item;
  }
  public void setNum(int num) {
    this.num = num;
  }
  public void setName(String name) {
    this.name = name;
  }
}

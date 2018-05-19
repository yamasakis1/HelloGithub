package com.example.demo.data;

import java.util.List;

public class Cart {
  public List<Order> cart;

  public void OrderList(List<Order> cart) {
    this.cart = cart;
  }

  public void setCart(List<Order> cart) {
    this.cart = cart;
  }

}

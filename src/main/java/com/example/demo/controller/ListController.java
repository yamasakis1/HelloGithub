package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.data.Cart;
import com.example.demo.data.Item;
import com.example.demo.data.Order;
import com.example.demo.forms.ListForm;
import com.example.demo.services.ListService;

@Controller
public class ListController {
  @Autowired
  HttpSession session;

  @Autowired
  private ListService listService;

  @RequestMapping(value="/shop",method = RequestMethod.GET)
  public ModelAndView show(ModelAndView mav) {


    Cart userCart = (Cart) session.getAttribute("Cart");
    session.removeAttribute("Cart");
    if (userCart != null) {
      mav.addObject("message","購入しました");
    }
    mav.addObject("Order", new Order());

    List<Cart> carts = (List<Cart>) session.getAttribute("CartList");
    if( carts == null) {
        carts = new ArrayList<Cart>();
        session.setAttribute("CartList", carts);
    }
    mav.addObject("carts", carts);

    BindingResult bindingResult = (BindingResult) session.getAttribute("result");
    if (bindingResult != null) {
      mav.addObject("bindingResult", bindingResult);
    }

    List<Item> itemList = listService.getItemlist();
    List<ListForm> forms = new ArrayList<>();
    for (Item item : itemList) {
      forms.add(new ListForm(item.name, item.price));
    }

    mav.addObject("forms",forms);

    mav.setViewName("ListView");
    return mav;

//    return new ModelAndView("ListView","forms",forms);
  }


  @RequestMapping(value="/shop",method = RequestMethod.POST)
  public ModelAndView order(ModelAndView mav, @Valid Cart userCart, BindingResult bindingResult, HttpServletRequest request) {

    List<Cart> carts = (List<Cart>)session.getAttribute("Cart");
    if(carts == null) {
      carts = new ArrayList<Cart>();
      session.setAttribute("Cart", carts);
    }



    //Cart cart = new Cart();
    //session.setAttribute("cart", userCart);
    return new ModelAndView("redirect:/shop");
  }
}

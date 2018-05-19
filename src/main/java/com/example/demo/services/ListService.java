package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.data.Item;

@Service
public class ListService {
  private static final List<Item> ITEM_LIST = new ArrayList<>();
  static {
    ITEM_LIST.add(new Item("参考書", 1080));
    ITEM_LIST.add(new Item("文庫本", 880));
    ITEM_LIST.add(new Item("ブックカバー", 540));
  }
  
  public List<Item> getItemlist(){
    return ITEM_LIST;
  }

}

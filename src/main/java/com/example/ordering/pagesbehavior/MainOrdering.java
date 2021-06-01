package com.example.ordering.pagesbehavior;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainOrdering {
    private String shop_name;

    private List<Items> items;

    public MainOrdering(String shop_name) {
        this.shop_name = shop_name;
        this.items=new ArrayList<>();

    }
    public boolean add_item(Items item){

        int pos=check_item(item.getName());
        if(pos<0){
            this.items.add(item);
            return true;
        }else {
            System.out.println("Item => "+item.getName()+" already exist");
        }
        return false;
    }

    public int check_item(String item){
        int i=0;
        for (Items item1:this.items
        ) {
            if(item1.getName().trim().toLowerCase().equals(item.trim().toLowerCase())){
                return i;
            }
            i++;
        }
        return -1;
    }

    public String getShop_name() {
        return shop_name;
    }

    public List<Items> getItems() {
        return items;
    }

}

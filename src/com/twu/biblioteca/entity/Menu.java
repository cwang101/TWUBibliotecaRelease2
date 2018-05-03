package com.twu.biblioteca.entity;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    List<String> items;


    public Menu(List<String> items) {
        this.items = items;
    }

    public List<String> getAllItems(){
        List<String> clone=new ArrayList<>();
        clone.addAll(items);
        return clone;
    }

    public boolean isValidIndex(int index){
        return index<=items.size();
    }
}

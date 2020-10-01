package com.codegym.model;

import java.util.HashMap;
import java.util.Map;

public class FavouriteList {
    private Map<Blog,Integer> list;

    public FavouriteList() {
        list = new HashMap<>();
    }

    public void addToList(Blog blog){
        if (list.containsKey(blog)){
            list.replace(blog,list.get(blog),list.get(blog)+1);
        }else
            list.put(blog,1);
    }

    public void removeList(Blog blog){
        list.remove(blog);
    }
    public int amount(Blog blog){
        return list.get(blog);
    }
    public Map<Blog,Integer> getList(){
        return list;
    }
    public void sub(Blog blog){
        if(list.containsKey(blog)){
            list.replace(blog,list.get(blog),list.get(blog)-1);
        }
        if(list.get(blog)==0){
            list.remove(blog);
        }
    }
}

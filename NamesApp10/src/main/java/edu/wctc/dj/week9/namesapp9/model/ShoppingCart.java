package edu.wctc.dj.week9.namesapp9.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart implements Serializable {
    private List<Name> contents = new ArrayList<>();

    public List<Name> getContents() {
        return contents;
    }

    public void setContents(List<Name> contents) {
        this.contents = contents;
    }
    
    public int getItemsInCart(){
        return contents.size();
    }
    
    public void add(Name name){
        contents.add(name);
    }
    
    public void remove(Name name){
        contents.remove(name);
    }
    
    public void removeAll(){
        contents.clear();
    }
    
}

package com.greenduck.vendingmachine.foods;

public abstract class Food {
    
    private String name;
    private PriceTag priceTag;
    
    public String getName() {
        return name;
    }
        
    public PriceTag getPriceTag() {
        return priceTag;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setPriceTag(PriceTag priceTag) {
        this.priceTag = priceTag;
    }
    
}

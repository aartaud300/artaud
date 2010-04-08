package com.springsource.pizzashop.domain;

import com.springsource.pizzashop.domain.Base;
import com.springsource.pizzashop.domain.Topping;
import java.lang.String;
import java.util.Set;

privileged aspect Pizza_Roo_JavaBean {
    
    public String Pizza.getName() {
        return this.name;
    }
    
    public void Pizza.setName(String name) {
        this.name = name;
    }
    
    public double Pizza.getPrice() {
        return this.price;
    }
    
    public void Pizza.setPrice(double price) {
        this.price = price;
    }
    
    public Base Pizza.getBase() {
        return this.base;
    }
    
    public void Pizza.setBase(Base base) {
        this.base = base;
    }
    
    public Set<Topping> Pizza.getToppings() {
        return this.toppings;
    }
    
    public void Pizza.setToppings(Set<Topping> toppings) {
        this.toppings = toppings;
    }
    
}

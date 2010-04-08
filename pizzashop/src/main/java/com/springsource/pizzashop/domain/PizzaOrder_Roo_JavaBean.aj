package com.springsource.pizzashop.domain;

import com.springsource.pizzashop.domain.Pizza;
import java.lang.String;
import java.util.Date;
import java.util.Set;

privileged aspect PizzaOrder_Roo_JavaBean {
    
    public String PizzaOrder.getName() {
        return this.name;
    }
    
    public void PizzaOrder.setName(String name) {
        this.name = name;
    }
    
    public String PizzaOrder.getAddress() {
        return this.address;
    }
    
    public void PizzaOrder.setAddress(String address) {
        this.address = address;
    }
    
    public Date PizzaOrder.getDeliveryDate() {
        return this.deliveryDate;
    }
    
    public void PizzaOrder.setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
    
    public Set<Pizza> PizzaOrder.getPizzas() {
        return this.pizzas;
    }
    
    public void PizzaOrder.setPizzas(Set<Pizza> pizzas) {
        this.pizzas = pizzas;
    }
    
    public double PizzaOrder.getTotal() {
        return this.total;
    }
    
    public void PizzaOrder.setTotal(double total) {
        this.total = total;
    }
    
}

package com.springsource.pizzashop.domain;

import java.lang.String;

privileged aspect Base_Roo_JavaBean {
    
    public String Base.getName() {
        return this.name;
    }
    
    public void Base.setName(String name) {
        this.name = name;
    }
    
}

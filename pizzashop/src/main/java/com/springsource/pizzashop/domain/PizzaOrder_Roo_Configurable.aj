package com.springsource.pizzashop.domain;

import org.springframework.beans.factory.annotation.Configurable;

privileged aspect PizzaOrder_Roo_Configurable {
    
    declare @type: PizzaOrder: @Configurable;
    
}

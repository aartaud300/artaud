package com.springsource.pizzashop.domain;

import org.springframework.beans.factory.annotation.Configurable;

privileged aspect Topping_Roo_Configurable {
    
    declare @type: Topping: @Configurable;
    
}

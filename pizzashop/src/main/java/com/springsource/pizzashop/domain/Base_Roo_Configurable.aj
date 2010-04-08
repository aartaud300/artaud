package com.springsource.pizzashop.domain;

import org.springframework.beans.factory.annotation.Configurable;

privileged aspect Base_Roo_Configurable {
    
    declare @type: Base: @Configurable;
    
}

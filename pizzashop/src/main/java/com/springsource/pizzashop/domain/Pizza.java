package com.springsource.pizzashop.domain;

import javax.persistence.Entity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.roo.addon.entity.RooEntity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;
import com.springsource.pizzashop.domain.Base;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import java.util.Set;
import com.springsource.pizzashop.domain.Topping;
import java.util.HashSet;
import javax.persistence.ManyToMany;
import javax.persistence.CascadeType;

@Entity
@RooJavaBean
@RooToString
@RooEntity
public class Pizza {

    @NotNull
    @Size(min = 2)
    private String name;

    @Min(0L)
    private double price;

    @NotNull
    @ManyToOne(targetEntity = Base.class)
    @JoinColumn
    private Base base;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Topping> toppings = new HashSet<Topping>();
}

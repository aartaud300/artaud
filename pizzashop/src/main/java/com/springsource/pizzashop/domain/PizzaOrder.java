package com.springsource.pizzashop.domain;

import javax.persistence.Entity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.roo.addon.entity.RooEntity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Set;
import com.springsource.pizzashop.domain.Pizza;
import java.util.HashSet;
import javax.persistence.ManyToMany;
import javax.persistence.CascadeType;
import javax.validation.constraints.Min;

@Entity
@RooJavaBean
@RooToString
@RooEntity
public class PizzaOrder {

    @NotNull
    @Size(min = 2)
    private String name;

    @Size(max = 50)
    private String address;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "S-")
    private Date deliveryDate;

    @Size(min = 1)
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Pizza> pizzas = new HashSet<Pizza>();

    @Min(0L)
    private double total;
}

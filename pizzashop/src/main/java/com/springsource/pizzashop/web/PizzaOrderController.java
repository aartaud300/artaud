package com.springsource.pizzashop.web;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import com.springsource.pizzashop.domain.PizzaOrder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@RooWebScaffold(path = "pizzaorder", automaticallyMaintainView = true, formBackingObject = PizzaOrder.class)
@RequestMapping("/pizzaorder/**")
@Controller
public class PizzaOrderController {
}

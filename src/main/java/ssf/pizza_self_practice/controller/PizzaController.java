package ssf.pizza_self_practice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import ssf.pizza_self_practice.model.Delivery;
import ssf.pizza_self_practice.model.Order;
import ssf.pizza_self_practice.model.Pizza;
import ssf.pizza_self_practice.service.PizzaService;

@Controller
@RequestMapping
public class PizzaController {

    @Autowired
    PizzaService pizzaService;


    @GetMapping(path="/")
    public String showIndex(Model model, HttpSession session) {

        session.invalidate();

        Pizza pizza = new Pizza();

        model.addAttribute("pizza", pizza);
        
        return "index";
    }

    
    @PostMapping(path="/pizza")
    public String placeOrder(Model model, HttpSession session, @Valid Pizza pizza, BindingResult bindingResult) {

        if (bindingResult.hasErrors())
			return "index";

        // System.out.println("Pizza>>>" + pizza.toString());

        session.setAttribute("pizza", pizza);

        model.addAttribute("delivery", new Delivery());

        return "delivery";
    }

    @PostMapping(path="/pizza/order")
    public String processOrder(Model model, HttpSession session, @Valid Delivery delivery, BindingResult bindingResult){

        if (bindingResult.hasErrors())
			return "delivery";

        Pizza pizza = (Pizza)session.getAttribute("pizza"); 

        // System.out.println("Order>>>" + pizza.toString());
        
        pizzaService.savePizzaOrder(pizza, delivery);

        // model.addAttribute("order", order);

        return "holder";
    }

    
}

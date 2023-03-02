package ssf.pizza_self_practice.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import ssf.pizza_self_practice.model.Delivery;
import ssf.pizza_self_practice.model.Order;
import ssf.pizza_self_practice.model.Pizza;

@Service
public class PizzaService {

    // public void processOrder(Pizza pizza, Delivery delivery){

    //     System.out.println("Order>>>" + pizza.toString());
    //     System.out.println("Order>>>" + delivery.toString());

    //     Order order = new Order(pizza, delivery);
    //     String orderId = UUID.randomUUID().toString().substring(0, 8);
    //     order.setOrderId(orderId);
    //     order.toString();
        


        
    // }

    public Order createPizzaOrder(Pizza pizza, Delivery delivery) {
		String orderId = UUID.randomUUID().toString().substring(0, 8);
		Order order = new Order(pizza, delivery);
		order.setOrderId(orderId);
		return order;
	}

    public Order savePizzaOrder(Pizza pizza, Delivery delivery) {
        // System.out.println("Save>>>" + pizza.toString());
		Order order = createPizzaOrder(pizza, delivery);
		return order;

	}

   
    
}

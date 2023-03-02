package ssf.pizza_self_practice.model;

import java.io.Serializable;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Order implements Serializable {
    
    private String orderId;
    private double orderCost;

    private final Pizza pizza;
	private final Delivery delivery;

    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public double getOrderCost() {
        return orderCost;
    }
    public void setOrderCost(Integer calculatedCost) {
        this.orderCost = calculatedCost;
    }

    public Order(Pizza pizza, Delivery delivery) {
        this.pizza = pizza;
		this.delivery = delivery;
    }

    public String getPizza() { return this.pizza.getPizza(); }
	public String getSize() { return this.pizza.getSize(); }
	public String getQuantity() { return this.pizza.getQuantity(); }
	public String getName() { return this.delivery.getName(); }
	public String getAddress() { return this.delivery.getAddress(); }
	public String getPhone() { return this.delivery.getPhone(); }
	public boolean isRush() { return this.delivery.isRush(); }
	public String getComments() { return this.delivery.getComments(); }

    double calculatedCost = calculateCost(getPizza(), getSize(), getQuantity(), isRush());

    public double calculateCost(String pizzaName, String pizzaSize, String pizzaQUantity, boolean rush){

        Integer pizzaCost;

        if (pizzaName.equals("marinara") || pizzaName.equals("bella") || pizzaName.equals("spiniatacalbrese")){
            pizzaCost = 30;
        } else if (pizzaName.equals("margherita")){
            pizzaCost = 22;
        } else {
            pizzaCost = 25;
        }

        double multiplier;
        if (pizzaSize.equals("lg")){
            multiplier = 1.5;
        } else if (pizzaSize.equals("md")){
            multiplier = 1.2;
        } else {
            multiplier = 1;
        }

        double calculatedCost = pizzaCost * multiplier * Integer.parseInt(pizzaQUantity);

        System.out.println(calculatedCost);

        if (rush == true){
            return calculatedCost +2;
        }
        return calculatedCost;
    }


    // public JsonObject toJSON() {
	// 	return Json.createObjectBuilder()
	// 		.add("orderId", orderId)
	// 		.add("name", getName())
	// 		.add("address", getAddress())
	// 		.add("phone", getPhone())
	// 		.add("rush", isRush())
	// 		.add("comments", getComments())
	// 		.add("pizza", getPizza())
	// 		.add("size", getSize())
	// 		.add("quantity", getQuantity())
	// 		.add("total", calculatedCost)
	// 		.build();
	// }
    // @Override
    // public String toString() {
    //     return "Order [orderId=" + orderId + ", orderCost=" + orderCost + ", pizza=" + pizza + ", delivery=" + delivery
    //             + ", calculatedCost=" + calculatedCost + "]";
    // }


    

    
    


}

package ssf.pizza_self_practice.model;

import java.io.Serializable;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class Pizza implements Serializable {

    @NotNull(message = "must be selected")
    private String pizza;

    @NotNull(message = "must be selected")
    private String size;

    @NotNull(message = "must be selected")
    @Min(value=1, message = "minimum 1")
    @Max(value=10, message ="maximum 10")
    private String quantity;

    public Pizza() {
    }

    public Pizza(@NotNull(message = "must be selected") String pizza,
            @NotNull(message = "must be selected") String size,
            @NotNull(message = "must be selected") @Min(value = 1, message = "minimum 1") @Max(value = 100, message = "maximum 10") String quantity) {
        this.pizza = pizza;
        this.size = size;
        this.quantity = quantity;
    }

    public String getPizza() {
        return pizza;
    }

    public void setPizza(String pizza) {
        this.pizza = pizza;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Pizza [pizza=" + pizza + ", size=" + size + ", quantity=" + quantity + "]";
    }

    

    
    
}

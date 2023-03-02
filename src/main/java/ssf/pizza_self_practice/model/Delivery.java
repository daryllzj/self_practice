package ssf.pizza_self_practice.model;

import java.io.Serializable;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Delivery implements Serializable {

    @NotNull(message="Please state your address")
    @Size (min = 3, message = "min 3 char")
    private String name;

    @NotNull(message="Please state your address")
    private String address;

    @NotNull(message="Please state your address")
    @Size(min = 8, message = "min 8 digits")
    private String phone;

    private boolean rush = false;

    private String comments = "";

    public Delivery() {
    }

    public Delivery(@NotNull(message = "Please state your address") @Size(min = 3, message = "min 3 char") String name,
            @NotNull(message = "Please state your address") String address,
            @NotNull(message = "Please state your address") @Size(min = 8, message = "min 8 digits") String phone,
            boolean rush, String comments) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.rush = rush;
        this.comments = comments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isRush() {
        return rush;
    }

    public void setRush(boolean rush) {
        this.rush = rush;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Delivery [name=" + name + ", address=" + address + ", phone=" + phone + ", rush=" + rush + ", comments="
                + comments + "]";
    }

    
    
    


    
}

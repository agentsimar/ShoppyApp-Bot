package com.example.akal.shoppyapp;

import java.io.Serializable;
import java.text.NumberFormat;

/**
 * Created by Akal on 09-11-2017.
 */

public class ShoppingItem implements Serializable {
    public String name,type,description;
    public int price,quantity,productID;

    public ShoppingItem(String name) {
        this.name = name;
    }

    public ShoppingItem(int productID, String name, String type, String description, int price, int quantity){
        this.productID=productID;
        this.name= name;
        this.type=type;
        this.description=description;
        this.price=price;
        this.quantity=quantity;
    }

    public ShoppingItem() {

    }

    public void setQuantity(int quantity){
            this.quantity=quantity;
        }
        public int getProductID(){
            return productID;
        }
        public String getTitle(){
            return name;
        }

    public String getType() {
        return type;
    }
    public String getDescription(){
        return description;
    }
    public int getQuantity(){
        return quantity;
    }
    public String getPrice(){
        return NumberFormat.getCurrencyInstance().format(price);
    }
}

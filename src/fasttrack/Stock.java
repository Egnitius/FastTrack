/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fasttrack;

import java.awt.image.BufferedImage;

/**
 *
 * @author Paledi.Egnitius
 */
public class Stock {

    private int itemID;
    private double price;
    private int quantity;
    private String item;
    private double totalPrice;

    public Stock(int itemID, double price, int quantity, String item, double totalPrice) {
        this.item = item;
        this.itemID = itemID;
        this.price = price;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public int getItemID() {
        return itemID;
    }

    public String getItem() {
        return item;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}

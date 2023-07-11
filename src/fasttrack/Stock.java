/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fasttrack;

/**
 *
 * @author Paledi.Egnitius
 */
public class Stock {
    private int itemID;
    private double price;
    private int quantity;
    private String item;
    
    public Stock(int itemID, double price, int quantity, String item){
        this.item = item;
        this.itemID = itemID;
        this.price = price;
        this.quantity = quantity;
    }
    
    public int getItemID(){
        return itemID;
    }
    
    public String getItem(){
        return item;
    }
    
    public double getPrice(){
        return price;
    }
    
    public int getQuantity(){
        return quantity;
    }
}

package models;

import java.awt.*;

public class Tshirts {

    private int id;
    private String name;
    private String brand;
    private int size;
    private Color color;
    private int qty;
    private float price;

    public Tshirts(int expectedId, String expectedName, String expectedBrand, int expectedSize, Color expectedColor, int expectedQty, float expectedPrice) {
        this.id = expectedId;
        this.name = expectedName;
        this.brand = expectedBrand;
        this.size = expectedSize;
        this.color =expectedColor;
        this.qty = expectedQty;
        this.price = expectedPrice;
    }

    public void setName(String expected) {
        this.name = expected;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public String getBrand() {
        return this.brand;
    }

    public int getSize() {
        return this.size;
    }

    public int getQty() {
        return this.qty;
    }

    public Color getColor() {
        return this.color;
    }

    public float getPrice() {
        return this.price;
    }

    public void setQty(int qty){this.qty = qty;}

    @Override
    public String toString(){
        return "Id: "+this.id+" Name: "+this.name+" Brand: "+this.brand+" Size: "+this.size
                +" Quantity; "+this.qty+" Color: "+this.color+" Price: "+this.price+"\n";
    }
}

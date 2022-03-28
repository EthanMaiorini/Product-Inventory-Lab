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

    public void setName(String expected) {
        this.name = expected;
    }

    public String getName() {
        return this.name;
    }
}

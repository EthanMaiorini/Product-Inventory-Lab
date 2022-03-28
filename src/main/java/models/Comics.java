package models;

public class Comics {
    private int id;
    private String name;
    private String publisher;
    private int qty;
    private double grade;
    private float price;

    public void setName(String expected) {
        this.name = expected;
    }

    public String getName() {
        return this.name;
    }
}

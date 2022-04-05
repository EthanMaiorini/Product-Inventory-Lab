package models;

public class Comics {
    private int id;
    private String name;
    private String publisher;
    private int issueNumber;
    private int qty;
    private double grade;
    private float price;

    public Comics(int expectedId, String expectedName, String expectedPublisher, int expectedIssueNumber, int expectedQty, double expectedGrade, float expectedPrice) {
        this.id = expectedId;
        this.name = expectedName;
        this.publisher = expectedPublisher;
        this.issueNumber = expectedIssueNumber;
        this.qty = expectedQty;
        this.grade = expectedGrade;
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

    public String getPublisher() {
        return this.publisher;
    }

    public int getIssueNumber() {
        return this.issueNumber;
    }

    public int getQty() {
        return this.qty;
    }

    public double getGrade() {
        return this.grade;
    }

    public float getPrice() {
        return this.price;
    }

    public void setQty(int qty){this.qty = qty;}
    @Override
    public String toString(){
        return "Id: "+this.id+" Name: "+this.name+" Publisher: "+this.publisher+" Issue Number: "+this.issueNumber
                +" Quantity; "+this.qty+" Grade: "+this.grade+" Price: "+this.price+"\n";
    }

}

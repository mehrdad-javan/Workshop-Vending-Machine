package se.lexicon.model;

public class Fruit implements Product {

    private final int id;
    private String fruitType;
    private final String color;
    private double price;

    public Fruit(String fruitType, String color, double price) {
        this.id = ProductSequencer.nextId();
        this.fruitType = fruitType;
        this.color = color;
        this.price = price;
    }

    @Override
    public String examine() {
        return "{ id: " + id + ", fruit: " + color + " " + fruitType + " }";
    }

    @Override
    public String use() {
        return fruitType + " taste delicious!";
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getProductName() {
        return fruitType;
    }

    @Override
    public void setProductName(String productName) {
        this.fruitType = productName;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }
}

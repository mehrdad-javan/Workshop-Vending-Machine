package se.lexicon.model;

public class Snack extends Product {


    public Snack(double price, String snack) {
        super(price, snack);
    }

    @Override
    public String examine() {
        return "{ id: " + getId() + ", snack: " + getProductName() + " }";
    }

    @Override
    public String use() {
        return "You eat some " + getProductName();
    }

}

package se.lexicon.model;

public class Beverage extends Product {

    private final boolean alcoholic;
    private final int sugarPercentage;

    public Beverage(String productName, boolean alcoholic, int sugarPercentage, double price) {
        super(price, productName);
        this.alcoholic = alcoholic;
        this.sugarPercentage = sugarPercentage;
    }

    @Override
    public String examine() {
        return "{ id: " + getId() + ", beverage: " + getProductName() + " with " + sugarPercentage + "% sugar }";
    }

    @Override
    public String use() {
        String description = "You drink some " + getProductName();
        description += alcoholic ? " and feel a bit tipsy" : "";
        return description;
    }


}

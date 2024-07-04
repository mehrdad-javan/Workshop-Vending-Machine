package se.lexicon;

import se.lexicon.data.VendingMachine;
import se.lexicon.data.VendingMachineManager;
import se.lexicon.model.Beverage;
import se.lexicon.model.Fruit;
import se.lexicon.model.Product;
import se.lexicon.model.Snack;


public class App {
    public static void main(String[] args) {
        Product[] products = {
                new Beverage("Beer", true, 30, 75),
                new Beverage("Orange Juice", false, 25, 20),
                new Fruit("Orange", "Orange", 10),
                new Fruit("Banana", "Yellow", 11),
                new Snack(20, "Snickers"),
                new Snack(1000, "Exclusive snack")
        };
        VendingMachine vendingMachine = new VendingMachineManager(products);

        for (String string : vendingMachine.getProducts()) {
            System.out.println(string);
            System.out.println("-----");
        }

        vendingMachine.addCurrency(50);
        Product banana = vendingMachine.request(4);
        System.out.println(banana.use());
        System.out.println(vendingMachine.getBalance());


    }
}

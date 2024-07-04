package se.lexicon.data;

import se.lexicon.model.Product;

public class VendingMachineManager implements VendingMachine {

    public static final int[] VALID_DENOMINATIONS = {1, 2, 5, 10, 20, 50, 100, 200, 500, 1000};
    private final Product[] products;
    public int depositPool;

    public VendingMachineManager(Product[] products) {
        this.products = products;
    }

    @Override
    public void addCurrency(int amount) {
        if (isValidDenomination(amount)) {
            depositPool += amount;
        } else {
            throw new IllegalArgumentException("Invalid denomination: " + amount);
        }
    }

    private boolean isValidDenomination(int amount) {
        for (int denomination : VALID_DENOMINATIONS) {
            if (denomination == amount) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int getBalance() {
        return depositPool;
    }

    @Override
    public Product request(int id) {
        Product requestedProduct = findProductById(id);
        if (requestedProduct != null) {
            if (requestedProduct.getPrice() <= depositPool) {
                depositPool -= requestedProduct.getPrice();
                return requestedProduct;
            } else {
                throw new IllegalArgumentException("Insufficient funds for product: " + requestedProduct.getProductName());
            }
        } else {
            throw new IllegalArgumentException("Product not found with id: " + id);
        }
    }

    private Product findProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public int endSession() {
        int balance = depositPool;
        depositPool = 0;
        return balance;
    }

    @Override
    public String getDescription(int id) {
        Product product = findProductById(id);
        if (product != null) {
            return product.examine() + " price: " + product.getPrice();
        } else {
            return "Product not found with id: " + id;
        }
    }

    @Override
    public String[] getProducts() {
        String[] productsAsString = new String[products.length];
        for (int i = 0; i < products.length; i++) {
            productsAsString[i] = products[i].examine().concat(" price: " + products[i].getPrice());
        }
        return productsAsString;
    }
}

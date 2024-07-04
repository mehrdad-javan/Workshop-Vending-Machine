package se.lexicon.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {

    @Test
    void testExamine() {
        Product product = new Snack( 1.5, "Chips");
        assertEquals("{ id: 1, snack: Chips }", product.examine());
    }

    @Test
    void testUse() {
        Product product = new Fruit( "Apple", "Red", 0.75);
        assertEquals("Apple taste delicious!", product.use());
    }
}
package domain;


import domain.basket.Basket;
import domain.product.ProductFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BasketTest {
    static Basket basket;

    @BeforeAll
    static void setUp() {
        basket = new Basket();
        basket.addCommand(ProductFactory.createProduct("Stylo Bic bleu",
                "Un très beau stylo bic bleu",
                1));
    }

    @Test
    void addCommand() {
    }

    @Test
    void testAddCommand() {
    }

    @Test
    void increaseCommandQuantityByProductName() {
    }

    @Test
    void decreaseCommandQuantityByProductName() {
    }

    @Test
    void removeProductByName() {
    }
}
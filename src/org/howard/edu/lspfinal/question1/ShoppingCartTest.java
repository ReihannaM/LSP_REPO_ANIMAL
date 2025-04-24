package org.howard.edu.lspfinal.question1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {

    @Test
    @DisplayName("Test for adding valid item")
    public void testAddValidItem() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Laptop", 1000.00);
        assertEquals(1000.00, cart.getTotalCost(), 0.01);
    }

    @Test
    @DisplayName("Test for adding item with 0 price (expect exception)")
    public void testAddItemWithZeroPrice() {
        ShoppingCart cart = new ShoppingCart();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem("Pen", 0.0);
        });
        assertEquals("Price cannot be negative.", exception.getMessage());
    }

    @Test
    @DisplayName("Test for adding item with negative price (expect exception)")
    public void testAddItemWithNegativePrice() {
        ShoppingCart cart = new ShoppingCart();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem("Notebook", -10.0);
        });
        assertEquals("Price cannot be negative.", exception.getMessage());
    }

    @Test
    @DisplayName("Test for applying SAVE10")
    public void testApplySave10Discount() {
        ShoppingCart cart = new ShoppingCart();
        cart.applyDiscountCode("SAVE10");
        assertEquals(10.0, cart.getDiscountPercentage());
    }

    @Test
    @DisplayName("Test for applying SAVE20")
    public void testApplySave20Discount() {
        ShoppingCart cart = new ShoppingCart();
        cart.applyDiscountCode("SAVE20");
        assertEquals(20.0, cart.getDiscountPercentage());
    }

    @Test
    @DisplayName("Test for applying invalid code (expect exception)")
    public void testApplyInvalidDiscountCode() {
        ShoppingCart cart = new ShoppingCart();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cart.applyDiscountCode("SAVE50");
        });
        assertEquals("Invalid discount code.", exception.getMessage());
    }

    @Test
    @DisplayName("Test total cost without discount")
    public void testTotalCostWithoutDiscount() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Chair", 50);
        cart.addItem("Table", 150);
        assertEquals(200.0, cart.getTotalCost(), 0.01);
    }

    @Test
    @DisplayName("Test total cost with discount")
    public void testTotalCostWithDiscount() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Monitor", 200);
        cart.addItem("Keyboard", 100);
        cart.applyDiscountCode("SAVE10");
        assertEquals(270.0, cart.getTotalCost(), 0.01);
    }

    @Test
    @DisplayName("Test total cost with empty cart")
    public void testTotalCostWithEmptyCart() {
        ShoppingCart cart = new ShoppingCart();
        assertEquals(0.0, cart.getTotalCost(), 0.01);
    }
}

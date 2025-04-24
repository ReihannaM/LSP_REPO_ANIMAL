package org.howard.edu.lspfinal.question1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class ShoppingCartTest {

    private ShoppingCart cart;

    @BeforeEach
    public void setUp() {
        cart = new ShoppingCart();
    }

    @Test
    @DisplayName("Test adding a valid item")
    public void testAddItem() {
        cart.addItem("Laptop", 1000.0);
        assertEquals(1, cart.getItemCount());
    }

    @Test
    @DisplayName("Test adding an item with zero price (expect exception)")
    public void testAddItemWithZeroPrice() {
        try {
            cart.addItem("Free Item", 0.0);
            fail("Expected IllegalArgumentException to be thrown.");
        } catch (IllegalArgumentException e) {
            assertEquals("Price cannot be negative.", e.getMessage());
        }
    }

    @Test
    @DisplayName("Test adding an item with negative price (expect exception)")
    public void testAddItemWithNegativePrice() {
        try {
            cart.addItem("Invalid Item", -50.0);
            fail("Expected IllegalArgumentException to be thrown.");
        } catch (IllegalArgumentException e) {
            assertEquals("Price cannot be negative.", e.getMessage());
        }
    }

    @Test
    @DisplayName("Test applying valid discount code 'SAVE10'")
    public void testApplySave10() {
        cart.addItem("Laptop", 1000.0);
        cart.applyDiscountCode("SAVE10");
        assertEquals(10.0, cart.getDiscountPercentage());
    }

    @Test
    @DisplayName("Test applying valid discount code 'SAVE20'")
    public void testApplySave20() {
        cart.addItem("Laptop", 1000.0);
        cart.applyDiscountCode("SAVE20");
        assertEquals(20.0, cart.getDiscountPercentage());
    }

    @Test
    @DisplayName("Test applying an invalid discount code (expect exception)")
    public void testApplyInvalidDiscountCode() {
        try {
            cart.applyDiscountCode("SAVE50");
            fail("Expected IllegalArgumentException to be thrown.");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid discount code.", e.getMessage());
        }
    }

    @Test
    @DisplayName("Test total cost without discount")
    public void testTotalCostWithoutDiscount() {
        cart.addItem("Laptop", 1000.0);
        cart.addItem("Mouse", 50.0);
        assertEquals(1050.0, cart.getTotalCost());
    }

    @Test
    @DisplayName("Test total cost with discount")
    public void testTotalCostWithDiscount() {
        cart.addItem("Laptop", 1000.0);
        cart.applyDiscountCode("SAVE10");
        assertEquals(900.0, cart.getTotalCost());
    }

    @Test
    @DisplayName("Test total cost with an empty cart")
    public void testTotalCostWithEmptyCart() {
        assertEquals(0.0, cart.getTotalCost());
    }

    @Test
    @DisplayName("Test removing an existing item")
    public void testRemoveItem() {
        cart.addItem("Laptop", 1000.0);
        cart.addItem("Mouse", 50.0);
        cart.removeItem("Mouse");
        assertEquals(1, cart.getItemCount());  // Only 1 item should remain
    }

    @Test
    @DisplayName("Test removing a non-existent item (expect exception)")
    public void testRemoveNonExistentItem() {
        try {
            cart.removeItem("NonExistent Item");
            fail("Expected IllegalArgumentException to be thrown.");
        } catch (IllegalArgumentException e) {
            assertEquals("Item not found in the cart.", e.getMessage());
        }
    }
}

   

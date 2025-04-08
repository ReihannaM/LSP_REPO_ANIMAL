package org.howard.edu.assignment6;

import org.howard.edu.lsp.assignment5.IntegerSet;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;

public class IntegerSetTest {
    private IntegerSet set1;
    private IntegerSet set2;

    @BeforeEach
    public void setUp() {
        set1 = new IntegerSet();
        set2 = new IntegerSet();
    }

    @Test
    @DisplayName("Test case for add and toString")
    public void testAddAndToString() {
        set1.add(5);
        set1.add(10);
        set1.add(5); // Duplicate
        assertEquals("[5, 10]", set1.toString());
    }

    @Test
    @DisplayName("Test case for clear and isEmpty")
    public void testClearAndIsEmpty() {
        set1.add(1);
        set1.clear();
        assertTrue(set1.isEmpty());
    }

    @Test
    @DisplayName("Test case for length")
    public void testLength() {
        assertEquals(0, set1.length());
        set1.add(1);
        set1.add(2);
        assertEquals(2, set1.length());
    }

    @Test
    @DisplayName("Test case for equals")
    public void testEquals() {
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(1);
        assertTrue(set1.equals(set2));
    }

    @Test
    @DisplayName("Test case for contains")
    public void testContains() {
        set1.add(3);
        assertTrue(set1.contains(3));
        assertFalse(set1.contains(4));
    }

    @Test
    @DisplayName("Test case for largest and exception")
    public void testLargest() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            set1.largest();
        });

        set1.add(10);
        set1.add(5);
        assertEquals(10, set1.largest());
    }

    @Test
    @DisplayName("Test case for smallest and exception")
    public void testSmallest() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            set1.smallest();
        });

        set1.add(10);
        set1.add(5);
        assertEquals(5, set1.smallest());
    }

    @Test
    @DisplayName("Test case for remove")
    public void testRemove() {
        set1.add(3);
        set1.remove(3);
        assertFalse(set1.contains(3));
    }

    @Test
    @DisplayName("Test case for union")
    public void testUnion() {
        set1.add(1);
        set2.add(2);
        set1.union(set2);
        assertTrue(set1.contains(1));
        assertTrue(set1.contains(2));
    }

    @Test
    @DisplayName("Test case for intersection")
    public void testIntersect() {
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(3);
        set1.intersect(set2);
        assertEquals("[2]", set1.toString());
    }

    @Test
    @DisplayName("Test case for diff")
    public void testDiff() {
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set1.diff(set2);
        assertEquals("[1]", set1.toString());
    }

    @Test
    @DisplayName("Test case for complement")
    public void testComplement() {
        set1.add(1);
        set1.add(3);
        set2.add(1);
        set2.add(2);
        set2.add(3);
        set1.complement(set2);
        assertEquals("[2]", set1.toString());
    }
}

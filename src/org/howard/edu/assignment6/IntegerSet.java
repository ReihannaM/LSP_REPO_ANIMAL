package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.List;

/**
 * IntegerSet class represents a mathematical set of integers.
 * It provides various set operations such as union, intersection, difference, and complement.
 */
public class IntegerSet {
    private List<Integer> set = new ArrayList<Integer>();

    /**
     * Default constructor for IntegerSet.
     */
    public IntegerSet() {
    }

    /**
     * Constructor that initializes the set with a given list of integers.
     * @param set A list of integers.
     */
    public IntegerSet(ArrayList<Integer> set) {
        this.set = new ArrayList<>(set);
    }

    /**
     * Clears all elements from the set.
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns the number of elements in the set.
     * @return The size of the set.
     */
    public int length() {
        return set.size();
    }

    /**
     * Checks if two sets are equal (contain the same elements in any order).
     * @param o Another IntegerSet object.
     * @return True if sets are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof IntegerSet)) return false;
        IntegerSet other = (IntegerSet) o;
        return set.containsAll(other.set) && other.set.containsAll(set);
    }

    /**
     * Checks if the set contains a specific value.
     * @param value The integer to check.
     * @return True if the set contains the value, false otherwise.
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns the largest value in the set.
     * @return The largest integer in the set.
     */
    public int largest() {
        if (set.isEmpty()) throw new RuntimeException("Set is empty");
        return set.stream().max(Integer::compare).get();
    }

    /**
     * Returns the smallest value in the set.
     * @return The smallest integer in the set.
     */
    public int smallest() {
        if (set.isEmpty()) throw new RuntimeException("Set is empty");
        return set.stream().min(Integer::compare).get();
    }

    /**
     * Adds an integer to the set (if it doesn't already exist).
     * @param item The integer to add.
     */
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes an integer from the set (if it exists).
     * @param item The integer to remove.
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /**
     * Performs union operation with another IntegerSet.
     * @param intSetb Another IntegerSet.
     */
    public void union(IntegerSet intSetb) {
        for (int item : intSetb.set) {
            this.add(item);
        }
    }

    /**
     * Performs intersection operation with another IntegerSet.
     * @param intSetb Another IntegerSet.
     */
    public void intersect(IntegerSet intSetb) {
        set.retainAll(intSetb.set);
    }

    /**
     * Performs set difference (this set - another set).
     * @param intSetb Another IntegerSet.
     */
    public void diff(IntegerSet intSetb) {
        set.removeAll(intSetb.set);
    }

    /**
     * Performs complement operation (elements not in this set).
     * @param intSetb Another IntegerSet.
     */
    public void complement(IntegerSet intSetb) {
        List<Integer> complementSet = new ArrayList<>(intSetb.set);
        complementSet.removeAll(this.set);
        this.set = complementSet;
    }

    /**
     * Checks if the set is empty.
     * @return True if the set is empty, false otherwise.
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Returns the string representation of the set.
     * @return A formatted string containing set elements.
     */
    @Override
    public String toString() {
        return set.toString();
    }
}

package org.howard.edu.lsp.assignment5;

/**
 * Driver class to test IntegerSet operations.
 */
public class Driver {
    public static void main(String[] args) {
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        System.out.println("Set1: " + set1);

        System.out.println("Smallest value in Set1: " + set1.smallest());
        System.out.println("Largest value in Set1: " + set1.largest());

        IntegerSet set2 = new IntegerSet();
        set2.add(3);
        set2.add(4);
        set2.add(5);
        System.out.println("\nSet2: " + set2);

        System.out.println("\nUnion of Set1 and Set2:");
        set1.union(set2);
        System.out.println("Result: " + set1);

        System.out.println("\nIntersection of Set1 and Set2:");
        set1.intersect(set2);
        System.out.println("Result: " + set1);

        System.out.println("\nDifference (Set1 - Set2):");
        set1.diff(set2);
        System.out.println("Result: " + set1);

        System.out.println("\nComplement of Set1 in Set2:");
        set1.complement(set2);
        System.out.println("Result: " + set1);

        System.out.println("\nChecking if Set1 is empty: " + set1.isEmpty());
        set1.clear();
        System.out.println("After clearing, is Set1 empty? " + set1.isEmpty());
    }
}

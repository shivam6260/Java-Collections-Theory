package com.collections.list;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnArrayListDemo4 {
    public static void main(String[] args) {
//        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        // "Copy on Write" means that whenever a write operation
        // like adding or removing an element
        // instead of directly modifying the existing list
        // a new copy of the list is created, and the modification is applied to that copy
        // This ensures that other threads reading the list while it’s being modified are unaffected.

        // Read Operations: Fast and direct, since they happen on a stable list without interference from modifications.
        // Write Operations: A new copy of the list is created for every modification.
        //                  The reference to the list is then updated so that subsequent reads use this new list.

        // notepad --> notepad-copy

        // read more

        List<String> shoppingList = new CopyOnWriteArrayList<>();
        shoppingList.add("Milk");
        shoppingList.add("Eggs");
        shoppingList.add("Bread");
        System.out.println("Initial Shopping List: " + shoppingList);

        for (String item : shoppingList) {
            System.out.println(item);
            // Try to modify the list while reading
            if (item.equals("Eggs")) {
                shoppingList.add("Butter");
                System.out.println("Added Butter while reading.");
            }
        }
        // purani = new
        System.out.println("Updated Shopping List: " + shoppingList);




        /*
        The first loop runs without throwing an exception, adding "Guava" to the list.
        The second loop throws a ConcurrentModificationException when trying to add "Kiwi".
         */

        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Mango");
        list.add("Banana");
        list.add("Grapes");
        System.out.println(list);

        // First loop: Traditional for loop
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("Mango")) {
                list.add("Guava");
            }
        }
        System.out.println(list);

        // Second loop: Enhanced for-each loop ( Throwing exception )
        for (String item : list) {
            if (item.equals("Mango")) {
                list.add("Kiwi");
            }
        }
        System.out.println(list);

        /*
        First Loop (Traditional for Loop):

        The traditional for loop doesn’t use an Iterator internally.
        It relies on direct index access (get(i)), so adding elements to the end of the
        list doesn’t break the loop’s logic.
         */

        /*
        Second Loop (Enhanced for-each Loop):
        How it Works:

        The enhanced for-each loop internally uses an Iterator to traverse the ArrayList.
        The Iterator is created at the start of the loop and keeps track of the list’s structure (e.g., its size and elements).

        When list.add("Kiwi") is called (after finding "Mango"),
        the list is modified structurally by adding an element, which changes its size and internal state.

        The Iterator detects this modification (via a mechanism called modCount in ArrayList) and
        throws a ConcurrentModificationException to prevent inconsistent iteration.

        Why the Exception?:
        Java’s ArrayList is not thread-safe, and its Iterator is fail-fast,
        meaning it throws a ConcurrentModificationException
        if the list is structurally modified (e.g., by adding or removing elements) during iteration,
        except through the Iterator’s own methods (e.g., Iterator.remove()).

        Adding "Kiwi" changes the list’s structure, invalidating the Iterator’s state,
        so the exception is thrown when the Iterator tries to fetch the next element.
         */
    }
}

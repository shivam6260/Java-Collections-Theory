package com.collections.map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class HashMap6 {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Hashtable<Integer, Integer> table = new Hashtable<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 4);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        /*
        🧠 What is a HashMap?

        HashMap<K, V> is a part of the Java Collections Framework, used to store key-value pairs.
        It allows constant-time performance for get() and put() operations in the average case, by using hashing.

        🔧 1. Internal Data Structure
        Internally:

        transient Node<K,V>[] table;
        table is an array of Node<K, V>.

        Each index in this array is called a bucket.

        Each bucket can store:

        A single Node if no collision

        A Linked List of Nodes (if collision happens and size < 8)

        A Red-Black Tree (if collision + size ≥ 8 and table size ≥ 64)


        📦 2. The Node Class

        static class Node<K,V> implements Map.Entry<K,V> {
            final int hash;
            final K key;
            V value;
            Node<K,V> next;
        }

        hash: The hashed value of the key
        key: The key object
        value: The value object
        next: Pointer to the next node in case of collisions (like a linked list)

        TreeNode Class
        static final class TreeNode<K,V> extends LinkedHashMap.Entry<K,V> {
            TreeNode<K,V> parent;  // Parent node in the tree
            TreeNode<K,V> left;    // Left child
            TreeNode<K,V> right;   // Right child
            TreeNode<K,V> prev;    // For linked list compatibility
            boolean red;           // Color (red or black)
            // Methods for tree operations
        }

        🧮 3. Hashing & Hash Function
        When you insert a key-value pair:

        map.put("Apple", 100);
        HashMap computes the hash value:

        int hash = hash(key.hashCode());
        Java 8 uses a hash spreading function:
        static final int hash(Object key) {
            int h;
            return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        }
        This function:
        Takes the key’s hashCode
        Mixes the high and low bits for better bucket distribution
        Index in table:

        index = (n - 1) & hash; // n = table.length
        This uses bitwise AND to get the bucket index.

        🪢 4. Handling Collisions
        If two keys hash to the same index:
        a) Initially — Linked List
        The entries are chained using the next field.

        Time complexity: O(n)

        b) Java 8+ — Treeify after threshold
        If a bucket has ≥ 8 nodes (and array length ≥ 64), HashMap converts the bucket from LinkedList → Red-Black Tree

        Time complexity: Improves from O(n) → O(log n)

        This helps improve performance in worst-case hash collisions (e.g., malicious attacks).

        🌳 5. Red-Black Tree in HashMap
        It's a self-balancing binary search tree with O(log n) insert, delete, and search.
        Java uses a specialized TreeNode<K, V> that extends Node<K, V>.
        Tree is used only for buckets with ≥ 8 entries, and only if table size is ≥ 64.
        If size goes below 6 after deletions, it reverts back to a Linked List.

        💡 6. Load Factor & Threshold
        What is Load Factor?
        float loadFactor = 0.75f; // default
        It defines how full the map can be before resizing.

        A load factor of 0.75 means: resize when 75% of the table is full.

        Threshold:

        threshold = capacity * loadFactor;
        When size > threshold, HashMap resizes.

        🔁 7. Resizing / Rehashing
        When the threshold is crossed:
        Capacity is doubled (e.g., 16 → 32)
        All existing entries are rehashed and redistributed to new buckets
        Tree structures in buckets are preserved where needed

        Resizing is an expensive operation, so you should initialize the map with an estimated capacity when possible.

        ⏱️ Time Complexities
        Operation	        Best Case	    Worst Case (Before Java 8)	    Worst Case (Java 8+)
        put() / get()	    O(1)	        O(n) (linked list)	            O(log n) (RB tree)
        remove()	        O(1)	        O(n)	                        O(log n)

        ✅ Summary of Java 8 HashMap Internals
        Component	            Description
        table[]	                Array of Nodes
        Node class	            Stores key, value, hash, next
        Hashing function	    Spreads bits to reduce collisions
        Collision handling	    Linked List or Red-Black Tree
        Load factor	            When to resize (default 0.75)
        Resize threshold	    capacity * loadFactor
        Treeify threshold	    When a bucket becomes a red-black tree (≥ 8 nodes)
        Untreeify threshold	    Revert back to list (≤ 6 nodes)
         */
    }
}

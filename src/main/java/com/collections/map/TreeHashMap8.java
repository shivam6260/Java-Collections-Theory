package com.collections.map;

import java.util.Map;
import java.util.TreeMap;

public class TreeHashMap8 {
    public static void main(String[] args) {
        Map<Integer,String> map = new TreeMap<Integer,String>();

        /*
        🌳 What is TreeMap?
TreeMap is a Map implementation that stores key-value pairs in a sorted order
based on the natural ordering of keys or a custom Comparator.

It is implemented using a Red-Black Tree, a type of self-balancing Binary Search Tree (BST).

📦 Key Internal Structure

public class TreeMap<K,V> extends AbstractMap<K,V>
    implements NavigableMap<K,V>, Cloneable, Serializable {

    private transient Entry<K,V> root;
    private transient int size = 0;
    private final Comparator<? super K> comparator;
}

🌿 Node Structure (TreeMap.Entry)
Each node of the tree is an Entry<K,V>:

static final class Entry<K,V> implements Map.Entry<K,V> {
    K key;
    V value;
    Entry<K,V> left;
    Entry<K,V> right;
    Entry<K,V> parent;
    boolean color = BLACK; // RED or BLACK (RBT property)
}

Summary:
Each entry stores a key-value pair
Pointers to left, right, parent

A color flag (RED or BLACK) used for balancing the tree

🔺 TreeMap uses Red-Black Tree (RBT)
RBT Properties:
Each node is either red or black
The root is always black
Red nodes cannot have red children (no two red nodes in a row)
Every path from root to leaf must have the same number of black nodes

New nodes are initially inserted as red

These rules ensure:
O(log n) time for put(), get(), remove() operations


⚙️ Internal Working of put(K key, V value)
1. Search for the key position
Start from the root and compare keys using compareTo() or custom Comparator
Traverse left if new key is smaller
Traverse right if new key is larger

2. Insert as a new leaf (like BST)
Attach the new Entry<K,V> to appropriate parent’s left or right

3. Rebalance the Tree (Red-Black rules)

If inserting a red node violates any RBT property (e.g. red parent), recoloring or rotations (left/right) are triggered

🔁 Rotations:
Left Rotation: Pivot around a node to shift balance left
Right Rotation: Pivot around a node to shift balance right

Java uses fixAfterInsertion() internally for this logic.


🔍 Internal Working of get(K key)
Start from root
Recursively (or iteratively) compare the key with current node
Go left/right based on comparator result
Return the value once a node with matching key is found

O(log n) time due to balanced tree



🗑️ Internal Working of remove(K key)
1. Locate the node to be deleted (same logic as get)
2. Handle 3 cases:
Node has no child → simply remove
Node has one child → replace with child
Node has two children → find in-order successor, swap values, then remove the successor

3. Rebalance
If deleting a black node, Red-Black Tree properties may be violated

Java calls fixAfterDeletion() to restore balance

🧠 Comparator and Ordering
If you create a TreeMap with a custom Comparator, that comparator is used to order keys.

TreeMap<String, Integer> map = new TreeMap<>(Comparator.reverseOrder());
If no comparator is given, the key type must implement Comparable<K>.

📊 Performance
Operation	    Time Complexity
put	            O(log n)
get	            O(log n)
remove	        O(log n)
iteration	    O(n) (in-order traversal)

👁️ Example Walkthrough
Let’s insert the keys: 10, 20, 30, 15, 25:

       20(B)
      /     \
   10(R)   30(R)
              /
           25(B)
          /
       15(R)
Balancing will rotate and recolor nodes to ensure red-black rules

All paths from root to leaf contain same number of black nodes

🔄 TreeMap Entry Order
Iteration over TreeMap always returns keys in sorted order:

map.put(5, "A");
map.put(1, "B");
map.put(3, "C");

for (Map.Entry e : map.entrySet()) {
   System.out.println(e.getKey());
}
Output:

1
3
5

🔐 Summary
Concept	                Explanation
Data Structure	        Red-Black Tree (Balanced BST)
Node Class	            Entry<K,V>: key, value, left, right, parent, color
Sorting	                Uses compareTo() or Comparator
put()	                Insert as red node → balance tree using rotations & recoloring
get()	                Traverse like BST (O(log n))
remove()	            BST removal + balance
Iteration Order	        Sorted key order
         */
    }
}

package com.collections.set;

import java.util.Set;
import java.util.TreeSet;

public class TreeSet3 {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<Integer>();

        /*
🔍 What is TreeSet?

TreeSet<E> is a part of the Java Collections Framework and
implements the NavigableSet interface, which extends SortedSet.

✅ Key Features:

| Feature                    | Description                              |
| -------------------------- | ---------------------------------------- |
| **No Duplicates**          | Follows Set contract                     |
| **Sorted Order**           | Automatically sorts elements             |
| **Self-balancing BST**     | Internally uses a **Red-Black Tree**     |
| **Allows custom ordering** | Via `Comparator`                         |
| **Time Complexity**        | O(log n) for `add`, `remove`, `contains` |
| **Thread-safe**            | ❌ No                                     |

🔧 Internal Data Structure of TreeSet
public class TreeSet<E> extends AbstractSet<E> implements NavigableSet<E>, Cloneable, java.io.Serializable {

    private transient NavigableMap<E,Object> m;

    private static final Object PRESENT = new Object();
}

🔹 It uses TreeMap<E, Object> internally
Just like:

HashSet uses HashMap
LinkedHashSet uses LinkedHashMap
TreeSet uses TreeMap

So when you do:

TreeSet<String> set = new TreeSet<>();
set.add("apple");

Internally it becomes:
map.put("apple", PRESENT);

🌳 Under the Hood: TreeMap and Red-Black Tree
TreeMap is based on a Red-Black Tree.
A Red-Black Tree (RBT) is a self-balancing binary search tree that guarantees:
O(log n) insert, delete, search

Worst-case height: 2 * log(n+1)

Each Node contains:
static final class Entry<K,V> implements Map.Entry<K,V> {
    K key;
    V value;
    Entry<K,V> left;
    Entry<K,V> right;
    Entry<K,V> parent;
    boolean color; // RED or BLACK
}

✅ Summary Table

| Concept                   | Details                   |
| ------------------------- | ------------------------- |
| Underlying Data Structure | `TreeMap<E,Object>`       |
| Core Mechanism            | Red-Black Tree            |
| Operations Time           | O(log n)                  |
| Maintains Order           | Yes (sorted)              |
| Duplicates Allowed        | ❌ No                      |
| Null Allowed              | ❌ (by default)            |
| Custom Sort Order         | ✅ Yes, using `Comparator` |
| Thread-safe               | ❌ No                      |



| Feature         | `HashSet` | `LinkedHashSet` | `TreeSet`                           |
| --------------- | --------- | --------------- | ----------------------------------- |
| Order           | No        | Insertion order | Sorted                              |
| Backed By       | HashMap   | LinkedHashMap   | TreeMap                             |
| Time Complexity | O(1)      | O(1)            | O(log n)                            |
| Allows null?    | Yes (one) | Yes (one)       | ❌ No (unless Comparator handles it) |
| Thread-safe     | ❌         | ❌               | ❌                                   |

         */

    }
}

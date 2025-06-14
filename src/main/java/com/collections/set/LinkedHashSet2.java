package com.collections.set;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSet2 {
    public static void main(String[] args) {
        Set<Integer> set = new LinkedHashSet<Integer>();
        /*
🔍 What is LinkedHashSet?

LinkedHashSet<E> is a part of Java Collections Framework that:
Implements Set interface (no duplicates)
Maintains insertion order (unlike HashSet)
Allows one null element
Backed internally by a LinkedHashMap<E, Object>


| Feature                             | Description                          |
| ----------------------------------- | ------------------------------------ |
| **No duplicates**                   | Like all `Set` types                 |
| **Maintains insertion order**       | Unlike `HashSet`                     |
| **Uses `LinkedHashMap` internally** | Same structure and behavior          |
| **Null elements**                   | One null allowed                     |
| **Thread-safe?**                    | ❌ No                                 |
| **Time complexity**                 | O(1) for `add`, `remove`, `contains` |

🔧 Internal Structure
LinkedHashSet uses:

private transient LinkedHashMap<E,Object> map;

It uses:
The key to represent the element in the set
The value is a dummy constant:

private static final Object PRESENT = new Object();

So, when you add an element:

LinkedHashSet<String> set = new LinkedHashSet<>();
set.add("A");

Internally becomes:
map.put("A", PRESENT);


🧠 How Insertion Order is Maintained?
The secret lies inside LinkedHashMap.

LinkedHashMap internally uses a doubly-linked list on top of the hash buckets:

static class Entry<K,V> extends HashMap.Node<K,V> {
    Entry<K,V> before, after;
}
before and after form a doubly-linked list connecting entries in insertion order.
LinkedHashMap maintains two pointers:
head → first inserted element
tail → most recently inserted
This is how insertion order is preserved when you iterate over the set.


🧪 Operations and Internal Behavior
✅ add(E e) — What Happens Internally?

public boolean add(E e) {
    return map.put(e, PRESENT) == null;
}

Hash code is calculated for the element
If hash bucket is empty:
Store element in that bucket
Also add a new Entry node to the doubly linked list at the end

If already present:
Do not add again (returns false)

🔍 contains(E e)
Internally:
return map.containsKey(e);

Looks up the hash map for the key
Uses .equals() to verify match

❌ remove(E e)
Internally:

return map.remove(e) != null;
Removes the entry from hash table bucket
Also removes the node from the linked list by updating before and after links

🔄 Iteration
Iterating over a LinkedHashSet uses the linked list defined by before and after pointers.

So:
LinkedHashSet<String> set = new LinkedHashSet<>();
set.add("Z");
set.add("A");
set.add("B");

for (String s : set) {
    System.out.println(s); // Output: Z, A, B
}
Even though hash codes could place elements in random order in buckets,
the doubly linked list keeps track of the insertion order.

🔗 Internal Class Hierarchy

LinkedHashSet
   └── uses LinkedHashMap
         └── extends HashMap
               └── has array of buckets (Node<K,V>)
                      └── Nodes are connected by next (for hash collisions)
                      └── AND linked by before/after (insertion order)


📊 Load Factor & Rehashing

Because LinkedHashSet uses a LinkedHashMap, it also inherits:
Default initial capacity: 16
Default load factor: 0.75
When threshold is exceeded, table is resized (doubled), and all entries are rehased.
Doubly linked list order is preserved during rehashing.

🚀 Example

LinkedHashSet<String> set = new LinkedHashSet<>();
set.add("One");
set.add("Two");
set.add("Three");
set.add("Two"); // Ignored

Internally stored as:
Buckets (hash table):
[0] -> Entry ("One")
[4] -> Entry ("Two")
[9] -> Entry ("Three")

Doubly Linked List (Insertion Order):
"One" <-> "Two" <-> "Three"

| Concept                 | Value                           |
| ----------------------- | ------------------------------- |
| Internal Data Structure | `LinkedHashMap<E, Object>`      |
| Underlying Storage      | Hash table + doubly-linked list |
| Order Maintained?       | ✅ Yes                           |
| Duplicates?             | ❌ No                            |
| Null Elements?          | ✅ One                           |
| Resizing Strategy       | Same as HashMap                 |
| Performance             | O(1) for add, remove, contains  |


🆚 LinkedHashSet vs HashSet
| Feature       | `HashSet`       | `LinkedHashSet`                      |
| ------------- | --------------- | ------------------------------------ |
| Order         | Unordered       | Maintains insertion order            |
| Backed by     | `HashMap`       | `LinkedHashMap`                      |
| Performance   | Slightly faster | Slightly slower (due to linked list) |
| Null allowed? | One null        | One null                             |
| Use case      | Unique elements | Unique elements + predictable order  |


         */
    }
}

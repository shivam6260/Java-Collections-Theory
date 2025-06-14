package com.collections.map;

public class HashMapVSHashTable10 {
    public static void main(String[] args) {
        /*
        | Feature                            | `HashMap`                                                                                                | `Hashtable`                                            |
| ---------------------------------- | -------------------------------------------------------------------------------------------------------- | ------------------------------------------------------ |
| **Introduced In**                  | Java 1.2                                                                                                 | Java 1.0 (legacy)                                      |
| **Part of Collections Framework?** | ✅ Yes                                                                                                    | ❌ No (legacy class)                                    |
| **Thread Safety**                  | ❌ Not synchronized (unsuitable for multi-threaded use unless manually synchronized)                      | ✅ Synchronized (all public methods are `synchronized`) |
| **Null Allowed?**                  | ✅ 1 null key, multiple null values                                                                       | ❌ No null keys or null values                          |
| **Underlying Structure**           | Array of buckets with **Linked List**, or **TreeNodes (Red-Black Tree)** for large chains (since Java 8) | Array of buckets with **Linked List only**             |
| **Load Factor (Default)**          | `0.75f`                                                                                                  | `0.75f`                                                |
| **Initial Capacity**               | 16 (default)                                                                                             | 11 (default)                                           |
| **Resizing**                       | Doubles size when threshold exceeded (threshold = capacity \* load factor)                               | Doubles + 1 (`2n + 1`) strategy                        |
| **Hash Function**                  | Improved hash spreading: `hash(key.hashCode())` uses bit manipulation to reduce collisions               | Simple `key.hashCode()` directly                       |
| **Entry Class**                    | `Node<K,V>` or `TreeNode<K,V>` (Java 8+)                                                                 | `Entry<K,V>`                                           |
| **Collision Resolution**           | **Chaining** → linked list, converted to **tree** when bucket exceeds 8 elements (and capacity ≥ 64)     | **Chaining** → linked list only                        |
| **Iteration**                      | Uses **Iterator** (fail-fast)                                                                            | Uses **Enumeration** (not fail-fast)                   |


1 - Hashing Logic
Hashtable:

Index calculation:

index = (hash & 0x7FFFFFFF) % table.length;
Ensures positive index, but can cause more collisions.

HashMap:

Uses better hash spreading:

int hash = (key == null) ? 0 : key.hashCode() ^ (key.hashCode() >>> 16);
index = hash & (table.length - 1);
Ensures more even distribution of entries.



2 - Rehashing / Resizing
Hashtable:
Increases capacity using capacity = 2 * old + 1
Rehashes all entries and recalculates index

HashMap:
Capacity is always a power of 2
Doubles size when threshold is exceeded (e.g. from 16 → 32)

Rehashing process can be optimized with treeification in large chains

3 - Treeification (HashMap only)
Introduced in Java 8:
If a single bucket (linked list) grows beyond 8 entries,
and the table size is at least 64, it converts to a Red-Black Tree for faster lookup
Drastically improves performance in worst-case scenarios

📌 Hashtable does not have this optimization. Its linked lists can grow long, leading to degraded O(n) performance.
         */
    }
}

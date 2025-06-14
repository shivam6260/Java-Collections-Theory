package com.collections.map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMap7 {
    public static void main(String[] args) {
        // Linked HashMap maintain the insertion order.
        Map<String,Integer> map = new LinkedHashMap<String,Integer>();
        map.put("Shivam",1);
        map.put("Shweta",2);
        map.put(null,null);
        map.put("Mayank",null);
        System.out.println(map);

        /*
        🔑 What is LinkedHashMap?
    LinkedHashMap<K, V> is a subclass of HashMap that maintains insertion order or access order of key-value pairs.
    ➡️ Unlike a plain HashMap, which does not guarantee order, LinkedHashMap gives you predictable iteration.

    🚧 Key Characteristics:
    Feature	            Value
    Inherits from	    HashMap<K, V>
    Maintains Order	    ✅ Yes (Insertion or Access order)
    Underlying DS	    Hash table + Doubly Linked List
    Performance	        Almost same as HashMap



    📦 1. Internal Data Structures
    Base Field in HashMap

    transient Node<K,V>[] table;
    Extra Fields in LinkedHashMap:

    transient LinkedHashMap.Entry<K,V> head;
    transient LinkedHashMap.Entry<K,V> tail;

    This means LinkedHashMap adds a doubly-linked list on top of the hash table of HashMap.

    🔧 2. Internal Node / Entry Class

    static class Entry<K,V> extends HashMap.Node<K,V> {
        Entry<K,V> before, after;
    }
    This extends HashMap.Node with two pointers:
    before: points to previous node in insertion/access order
    after: points to next node

    So you get a doubly-linked list threading all entries in order.

🔄 3. Insertion / Access Order
🔹 Insertion Order (default)
Maintains the order in which entries are added.

🔸 Access Order (if enabled)

new LinkedHashMap<>(initialCapacity, loadFactor, true);
Each time you call get(key), that key is moved to the end.

Useful for LRU Caches.

🧮 4. Hashing & Indexing (same as HashMap)
LinkedHashMap uses the same hashing logic from Java 8's HashMap.

int hash = key.hashCode();
index = (n - 1) & hash;
Each key's hash determines its bucket index.

Bucket still uses array of nodes with next pointers for collisions.

🪢 5. Handling Collisions (same as HashMap)
Buckets in the table[] are still:
null (if empty)
A single Entry (if no collision)
A linked list (if collisions)
A red-black tree (if many collisions)

Treeify Threshold = 8
If a bucket gets ≥ 8 entries, it is treeified into a Red-Black Tree (Java 8+).
Nodes become instances of TreeNode (which still support the before/after links).



🔁 6. Iteration Order via Doubly Linked List
Let’s suppose you insert entries like:

map.put("A", 1);
map.put("B", 2);
map.put("C", 3);
Internally:

head -> A <-> B <-> C <- tail
When you iterate, this linked list is traversed, not the hash buckets.

If you access "B" and access-order is enabled, then:
head -> A <-> C <-> B <- tail

✅ Summary Table
Component	            Description
table[]	                Array of buckets storing Nodes
Entry<K,V>	            Node class with extra before/after pointers
head, tail	            Start and end of doubly-linked list
Hash Function	        Same as HashMap (bit-mixing)
Collision Handling	    Linked List → Tree (Java 8+)
Iteration               Order	Maintained via doubly linked list
Resizing	            Same as HashMap + relinking
Access Order	        Optional via constructor flag

📌 Visualization
Hash Table:
[0] → Entry (A)
[1] → Entry (B) → Entry (Z)  ← collision list
[2] → Entry (C)

Doubly Linked List:
head → A ↔ B ↔ Z ↔ C ← tail

HashMap itself does not store any order — it just uses an array and handles collisions via chains or trees.
But LinkedHashMap maintains a doubly linked list of entries across the hash table, not within a bucket.

🌿 Visual Structure of LinkedHashMap
Each Entry<K,V> is a node that:
Belongs to a bucket (used for fast hash-based access)
Also participates in a doubly linked list using before and after

static class Entry<K,V> extends HashMap.Node<K,V> {
    Entry<K,V> before, after;
}

🧠 Concept:
Let’s say we insert in order: "A", "B", "C".
The hash table looks like this (simplified):

table[3] → Entry("A")
table[5] → Entry("B")
table[8] → Entry("C")

But the linked list formed by before and after looks like:
head → A ↔ B ↔ C ← tail

A.before = null
A.after = B
B.before = A, B.after = C
C.before = B
C.after = null

🧱 What Are head and tail?
transient LinkedHashMap.Entry<K,V> head;
transient LinkedHashMap.Entry<K,V> tail;

These represent:
head: oldest entry (first inserted or first accessed)
tail: youngest entry (most recent one)
They help you iterate over the map in insertion/access order:
Start from head, keep going via .after

⚙️ What Happens Internally on put(key, value)
1. Hashing

int hash = hash(key);
int index = (n - 1) & hash;

Standard HashMap logic — find the bucket using hash

2. Insert into Hash Table

Node<K,V> e = table[index];
Insert node in the appropriate bucket
If collision, insert in linked list or tree within that bucket

3. Insert into Doubly Linked List
This is the LinkedHashMap’s key logic:

linkNodeLast(newNode); // appends to the end of the doubly-linked list

linkNodeLast(Entry<K,V> newNode) logic:

Entry<K,V> last = tail;
tail = newNode;
if (last == null) {
    head = newNode;
} else {
    newNode.before = last;
    last.after = newNode;
}
If this is the first node, set both head and tail
Else, update the current tail to point to the new node



         */
    }
}

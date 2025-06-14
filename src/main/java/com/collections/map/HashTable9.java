package com.collections.map;

import java.util.Hashtable;
import java.util.Map;

public class HashTable9 {
    public static void main(String[] args) {
        Map<Integer, String> map = new Hashtable<Integer, String>();
        map.put(1,"a");
        map.put(2,"b");
        map.put(3,"c");
        //System.out.println(map);
        for (Map.Entry<Integer,String> e : map.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }

        /*

🧠 What is Hashtable?
Hashtable<K, V> is a part of legacy Java collections (from JDK 1.0).
It implements the Map interface and stores key-value pairs based on the hashing technique.

It is synchronized, making it thread-safe, but also slower compared to HashMap.

🔧 Internal Data Structure
Internally, Hashtable uses:

private transient Entry<?,?>[] table;
It uses an array of buckets: each bucket stores a linked list (chain of entries with same hash index).

Each entry is a node with key, value, hash, and next reference.

📦 Internal Entry class

private static class Entry<K,V> implements Map.Entry<K,V> {
    final int hash;
    final K key;
    V value;
    Entry<K,V> next;
}


⚙️ Internal Working of put(K key, V value)

Step-by-step Process:
Check for null
Hashtable does not allow null keys or values
If key or value is null → throw NullPointerException

Compute Hash
int hash = key.hashCode();
Uses the object's hashCode() to compute a hash value.

Determine Bucket Index

int index = (hash & 0x7FFFFFFF) % table.length;
% table.length ensures the hash maps within bounds of array.
& 0x7FFFFFFF ensures non-negative index.

Traverse Chain (Linked List) at Index

If key already exists (using equals()), update value.
Otherwise, insert a new Entry at the head of the list.

Insert New Entry

Entry<K,V> e = table[index];
table[index] = new Entry<>(hash, key, value, e);
Increment size

Resize (Rehash) if needed
When the number of entries exceeds the threshold, it resizes the array (typically doubles) and rehashes all entries.



🔍 Internal Working of get(K key)
Step-by-step Process:
Check for null key
Throws NullPointerException

Compute hash & index
int hash = key.hashCode();
int index = (hash & 0x7FFFFFFF) % table.length;

Traverse the chain at index
Iterate over the linked list at table[index]
Use equals() to compare keys
Return value if key found
Return null if not found

🔒 Synchronization
Hashtable is synchronized:
All public methods (get, put, remove, etc.) are synchronized
This means only one thread can access them at a time
Ensures thread safety, but degrades performance in single-threaded applications
         */
    }
}

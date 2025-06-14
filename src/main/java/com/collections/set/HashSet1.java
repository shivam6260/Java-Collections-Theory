package com.collections.set;

import java.util.HashSet;
import java.util.Set;

public class HashSet1 {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<Integer>();
        /*
        🔍 What is HashSet?
HashSet<E> is part of Java Collections and implements the Set interface, meaning:
It does not allow duplicate elements
It does not maintain insertion order
It allows one null element

🔧 Internal Structure of HashSet
Internally, HashSet uses a HashMap to store elements.

private transient HashMap<E,Object> map;

Every element added to the HashSet is stored as a key in this internal HashMap

The value is a dummy constant object:
private static final Object PRESENT = new Object();

This means:
HashSet<String> set = new HashSet<>();
set.add("A");

Internally becomes:
map.put("A", PRESENT);


💡 Why Use HashMap Inside HashSet?
Because HashMap provides:
Fast lookups (via hashing)
Uniqueness of keys → perfect for enforcing Set rules
Efficient insertion/removal


🧠 Core Operations: Internal Working

✅ add(E e)
Hash code is calculated for the element using hashCode()
A hash value is generated (in HashMap) to determine the bucket index

It checks if the element already exists as a key

If not present:
Adds a new key-value pair: map.put(e, PRESENT)
Returns true

If already present:
Returns false (because Set must be unique)


🔍 contains(Object o)
Delegates to map.containsKey(o)
Calculates hash and checks bucket for presence
Uses .equals() to match the element


❌ remove(Object o)
Calls map.remove(o)
Removes the key from map
Returns true if the element existed and was removed

🧪 Example
Set<String> set = new HashSet<>();
set.add("apple");   // stored as map.put("apple", PRESENT)
set.add("banana");
set.add("apple");   // duplicate, ignored
Internally:

map = {
  "apple" -> Object@123,
  "banana" -> Object@123
}


📊 HashSet and Rehashing

Default Settings
Initial capacity: 16
Load factor: 0.75

When the number of elements exceeds capacity * loadFactor,
the internal HashMap resizes (doubles in size) and rehashes all elements.
This ensures that performance stays close to O(1) for add, remove, contains.

🔄 Hashing Process
For any element e added:
hashCode() is called

HashMap processes it using:

hash = (h = key.hashCode()) ^ (h >>> 16)
Index is calculated:

index = hash & (table.length - 1)
If no collision, node is stored

If collision:
Stored in a linked list or
In Java 8+, if the chain length exceeds 8, a Red-Black Tree is used

🧩 Uniqueness Check
HashSet uses .equals() and .hashCode() for comparison
Two objects are considered equal if:

obj1.hashCode() == obj2.hashCode()
&& obj1.equals(obj2) == true

That’s how it ensures no duplicates

⚠️ Null Handling

set.add(null); // ✅ Allowed
set.add(null); // ❌ Ignored — only one null allowed
Null is handled as a special case with null key in the map

| Concept            | HashSet                               |
| ------------------ | ------------------------------------- |
| Backed by          | `HashMap`                             |
| Data Stored        | Keys only (`value = PRESENT`)         |
| Duplicate Handling | Uses `.equals()` & `.hashCode()`      |
| Null Handling      | One null allowed                      |
| Performance        | O(1) for most operations              |
| Java Version       | Since 1.2                             |
| Tree Optimization  | Yes (via internal HashMap in Java 8+) |

         */
    }
}

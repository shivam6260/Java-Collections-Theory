package com.collections;

public class CollectionsHierarchy1 {
    public static void main(String[] args) {
        /*
java.lang.Iterable (interface)
   |
   └── java.util.Collection (interface)
         |
         ├── java.util.List (interface)
         |     ├── ArrayList
         |     ├── LinkedList
         |     └── Vector
         |           └── Stack
         |
         ├── java.util.Set (interface)
         |     ├── HashSet
         |     |     └── LinkedHashSet
         |     └── SortedSet (interface)
         |           └── NavigableSet (interface)
         |                 └── TreeSet
         |
         └── java.util.Queue (interface)
               ├── PriorityQueue
               ├── LinkedList
               └── Deque (interface)
                     ├── ArrayDeque
                     └── LinkedList

java.util.Map (interface)  ⟶ Not part of Collection but part of the Collections Framework
   ├── HashMap
   |     └── LinkedHashMap
   ├── Hashtable
   |     └── Properties
   └── SortedMap (interface)
         └── NavigableMap (interface)
               └── TreeMap

         */
    }
}

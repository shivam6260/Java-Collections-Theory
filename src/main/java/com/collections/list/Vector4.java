package com.collections.list;

import java.util.List;
import java.util.Vector;

public class Vector4 {
    public static void main(String[] args) {
        Vector<Integer> vector1 = new Vector<Integer>();

        List<Integer> vector2 = new Vector<Integer>();

        /**
         In Java, Vector is a legacy class in the Java Collection Framework that implements a growable array of objects.
         It is part of java.util package and implements the List interface, making it similar to ArrayList,
         but with synchronization support.

         Here's a comprehensive explanation of Vector from its internal workings to usage:

         🔧 1. Internal Working of Vector
         ✅ Storage Mechanism
         Internally, Vector uses an Object[] array to store elements.

         When the array fills up, it is resized to accommodate new elements.

         Initial capacity can be specified during construction; if not, default is 10.

         When capacity is exceeded, the array size is doubled by default.

         protected Object[] elementData; // backing array
         protected int elementCount;     // number of elements



         🔄 2. Growth Policy
         When adding elements beyond current capacity:
         Vector creates a new array with a larger size, usually twice the current capacity.
         Copies all elements from old array to new array.

         Growth Calculation

         int newCapacity = oldCapacity + ((capacityIncrement > 0) ? capacityIncrement : oldCapacity);

         capacityIncrement: Optional value provided during construction to grow linearly instead of exponentially.

         🔐 3. Thread Safety (Synchronization)
         All public methods of Vector are synchronized.

         Hence, Vector is thread-safe by default.

         This makes it slower in single-threaded scenarios compared to ArrayList.

         Example:

         public synchronized boolean add(E e) {
         ensureCapacityHelper(elementCount + 1);
         elementData[elementCount++] = e;
         return true;
         }


         🔄 4. Important Methods
         Method	                    Description
         add(E e)	                Appends element
         add(int index, E element)	Inserts element at index
         get(int index)	            Gets element at index
         remove(int index)	        Removes element at index
         size()	                    Returns number of elements
         capacity()	                Returns current capacity
         trimToSize()	            Trims capacity to match size
         clear()	                Removes all elements

         🆚 5. Vector vs ArrayList

         Feature	            Vector	                ArrayList
         Synchronization	    Yes	                    No
         Performance	        Slower (due to sync)	Faster
         Growth Rate	        Doubles size	        50% increase
         Legacy?	            Yes	                    No
         Use Case	        Multi-threaded	        Single-threaded

         🧵 6. Usage Example
         import java.util.Vector;

         public class VectorExample {
         public static void main(String[] args) {
         Vector<String> vector = new Vector<>(2); // initial capacity

         vector.add("Apple");
         vector.add("Banana");
         vector.add("Cherry"); // triggers growth

         System.out.println("Vector elements: " + vector);
         System.out.println("Size: " + vector.size());
         System.out.println("Capacity: " + vector.capacity());
         }
         }


         🛠️ 7. Best Practices
         Use Vector only when thread-safety is required and you cannot use external synchronization.

         Otherwise, prefer ArrayList for better performance.

         For thread-safe collections, prefer Collections.synchronizedList(new ArrayList<>()) or
         CopyOnWriteArrayList from java.util.concurrent.

         🧠 8. Why Vector is Legacy?
         Introduced in Java 1.0, before the Collection framework.

         Retroactively made to implement List in Java 1.2.

         Considered outdated due to intrinsic synchronization and lower flexibility compared to newer concurrent utilities.

         ✅ Summary
         Aspect	                Detail
         Type	                Legacy synchronized List
         Thread-safe	            Yes (method-level)
         Resizing	            Doubles on overflow
         Backing store	        Object array
         Use case	            Rare, multi-threaded apps
         Preferred alternative	ArrayList (single-threaded), CopyOnWriteArrayList (concurrent)

         */
    }
}

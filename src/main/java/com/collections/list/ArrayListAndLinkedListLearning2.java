/*
 * This class provides a detailed exploration of the internal workings of ArrayList and LinkedList in Java,
 * including their data structures, operations, performance characteristics, memory usage, and use cases.
 * It includes a comparison of their differences and an example to demonstrate their behavior.
 */
package com.collections.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListAndLinkedListLearning2 {
    public static void main(String[] args) {
        // Example array and list declarations
        int[] arr = new int[10];
        List<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        // Example comparing ArrayList and LinkedList performance
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        // Add 1000 elements to the end
        long startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            arrayList.add(i);
        }
        System.out.println("ArrayList add (end): " + (System.nanoTime() - startTime) / 1000 + " μs");

        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            linkedList.add(i);
        }
        System.out.println("LinkedList add (end): " + (System.nanoTime() - startTime) / 1000 + " μs");

        // Add 1000 elements at index 0
        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            arrayList.add(0, i);
        }
        System.out.println("ArrayList add (start): " + (System.nanoTime() - startTime) / 1000 + " μs");

        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            linkedList.add(0, i);
        }
        System.out.println("LinkedList add (start): " + (System.nanoTime() - startTime) / 1000 + " μs");

        // Random access
        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            arrayList.get(i);
        }
        System.out.println("ArrayList get: " + (System.nanoTime() - startTime) / 1000 + " μs");

        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            linkedList.get(i);
        }
        System.out.println("LinkedList get: " + (System.nanoTime() - startTime) / 1000 + " μs");

        /*
         * Detailed Explanation of ArrayList and LinkedList
         *
         * 1. ArrayList: Internal Working
         *
         * ArrayList is a resizable array implementation of the List interface in Java,
         * located in the java.util package. It provides fast random access and is backed by a dynamic array.
         *
         * 1.1 Underlying Data Structure
         * - Dynamic Array:
         *   - Internally, ArrayList uses a contiguous block of memory (an array) to store elements.
         *   - For an ArrayList<Integer>, the backing array is of type Object[] (before Java 10)
         *     or Object[] with type erasure for generics.
         *   - The array has a capacity (the size of the allocated array) and a size (the number of elements stored).
         *   - When the array runs out of space, it is resized (typically doubled).
         *
         * 1.2 Key Fields in ArrayList
         * - private Object[] elementData: The array that stores the elements.
         * - private int size: The number of elements in the list (not the array’s capacity).
         * - private static final int DEFAULT_CAPACITY = 10: Default initial capacity.
         * - private static final Object[] EMPTY_ELEMENTDATA = {}: Used for empty ArrayList instances.
         *
         * 1.3 Construction
         * - Default Constructor: ArrayList<Integer> list = new ArrayList<>();
         *   - Creates an ArrayList with an empty elementData array (EMPTY_ELEMENTDATA).
         *   - First element addition allocates an array with DEFAULT_CAPACITY (10).
         * - Constructor with Initial Capacity: ArrayList<Integer> list = new ArrayList<>(100);
         *   - Allocates an Object[] of size 100, avoiding resizing until 100+ elements.
         * - Constructor with Collection: ArrayList<Integer> list = new ArrayList<>(someCollection);
         *   - Copies elements from the collection into a new array.
         *
         * 1.4 Core Operations
         *
         * Adding Elements:
         * - add(E e):
         *   - Steps:
         *     1. Check capacity: if (size >= elementData.length).
         *     2. Resize if needed (typically 1.5x growth).
         *     3. Place element at elementData[size].
         *     4. Increment size.
         *   - Time Complexity: O(1) amortized. Resizing is O(n) but infrequent.
         *   - Resizing:
         *     - New capacity: newCapacity = oldCapacity + (oldCapacity >> 1) (1.5x growth).
         *     - Example: Capacity 10 grows to 15 (10 + 5).
         *     - Uses System.arraycopy for efficiency.
         * - add(int index, E element):
         *   - Steps:
         *     1. Validate index (0 <= index <= size).
         *     2. Ensure capacity.
         *     3. Shift elements from index to size-1 right.
         *     4. Insert element at elementData[index].
         *     5. Increment size.
         *   - Time Complexity: O(n) due to shifting.
         *
         * Removing Elements:
         * - remove(int index):
         *   - Steps:
         *     1. Validate index.
         *     2. Save element to return.
         *     3. Shift elements from index+1 to size-1 left.
         *     4. Set elementData[size-1] to null (for GC).
         *     5. Decrement size.
         *   - Time Complexity: O(n) due to shifting.
         * - remove(Object o):
         *   - Searches for first occurrence using equals.
         *   - Time Complexity: O(n) for search and shifting.
         *
         * Accessing Elements: get(int index)
         * - Steps:
         *   1. Validate index.
         *   2. Return elementData[index].
         * - Time Complexity: O(1) due to contiguous memory.
         *
         * Setting Elements: set(int index, E element)
         * - Replaces element at index.
         * - Time Complexity: O(1).
         *
         * Size and Capacity:
         * - size(): Returns size (O(1)).
         * - ensureCapacity(int minCapacity): Resizes if needed.
         * - trimToSize(): Reduces capacity to size.
         *
         * 1.6 Thread Safety
         * - ArrayList is not thread-safe. Concurrent modifications may cause ConcurrentModificationException.
         * - Use Collections.synchronizedList(new ArrayList<>()) or CopyOnWriteArrayList for thread safety.
         *
         * 1.7 Iterator
         * - Provides Iterator and ListIterator for traversal.
         * - Fail-fast: Throws ConcurrentModificationException on structural modification during iteration.
         * - Example:
         *   List<Integer> list = new ArrayList<>();
         *   list.add(1); list.add(2);
         *   for (Integer i : list) {
         *       System.out.println(i);
         *   }
         *
         * 2. LinkedList: Internal Working
         *
         * LinkedList is a doubly-linked list implementation of the List and Deque interfaces.
         * It provides efficient insertions/deletions at both ends but slower random access.
         *
         * 2.1 Underlying Data Structure
         * - Doubly-Linked List:
         *   - Each element is stored in a node with:
         *     - The element (reference to object).
         *     - Reference to next node.
         *     - Reference to previous node.
         *   - Maintains references to first and last nodes.
         *   - Diagram:
         *     null <- [prev|data|next] <-> [prev|data|next] <-> [prev|data|next] -> null
         *            first                                 last
         *
         * 2.2 Key Fields
         * - private transient Node<E> first: Reference to first node.
         * - private transient Node<E> last: Reference to last node.
         * - private int size: Number of elements.
         * - private static class Node<E>:
         *   private static class Node<E> {
         *       E item;
         *       Node<E> next;
         *       Node<E> prev;
         *       Node(Node<E> prev, E element, Node<E> next) {
         *           this.item = element;
         *           this.next = next;
         *           this.prev = prev;
         *       }
         *   }
         *
         * 2.3 Construction
         * - Default Constructor: LinkedList<Integer> list = new LinkedList<>();
         *   - Creates empty list with first = null, last = null, size = 0.
         * - Constructor with Collection: LinkedList<Integer> list = new LinkedList<>(someCollection);
         *   - Adds elements by creating and linking nodes.
         *
         * 2.4 Core Operations
         *
         * Adding Elements:
         * - add(E e):
         *   - Steps:
         *     1. Create new node.
         *     2. If empty, set first and last to new node.
         *     3. Otherwise, link to last, update last, set prev.
         *     4. Increment size.
         *   - Time Complexity: O(1).
         *   - Example Code:
         *     public boolean add(E e) {
         *         linkLast(e);
         *         return true;
         *     }
         *     void linkLast(E e) {
         *         final Node<E> l = last;
         *         final Node<E> newNode = new Node<>(l, e, null);
         *         last = newNode;
         *         if (l == null)
         *             first = newNode;
         *         else
         *             l.next = newNode;
         *         size++;
         *     }
         * - add(int index, E element):
         *   - Traverse to index, adjust pointers.
         *   - Time Complexity: O(n).
         * - addFirst(E e):
         *   - Links new node at start.
         *   - Time Complexity: O(1).
         *
         * Removing Elements:
         * - remove(int index):
         *   - Traverse to index, unlink node.
         *   - Time Complexity: O(n).
         * - remove(Object o):
         *   - Traverse to find object, unlink.
         *   - Time Complexity: O(n).
         * - removeFirst()/removeLast():
         *   - Time Complexity: O(1).
         *
         * Accessing Elements: get(int index)
         * - Traverse from first (if index < size/2) or last.
         * - Time Complexity: O(n).
         *
         * Setting Elements: set(int index, E element)
         * - Traverse and update node.
         * - Time Complexity: O(n).
         *
         * Size:
         * - size(): Returns size (O(1)).
         *
         * 2.5 Memory Usage
         * - Each node stores:
         *   - Element reference (4/8 bytes).
         *   - prev/next references (4/8 bytes each).
         *   - Node object overhead (8–16 bytes).
         * - Higher overhead than ArrayList.
         * - Example: 5 Integer elements use ~5 * (element + 2 pointers + overhead) bytes.
         *
         * 2.6 Thread Safety
         * - Not thread-safe.
         * - Use Collections.synchronizedList(new LinkedList<>()) for thread safety.
         *
         * 2.7 Iterator
         * - Provides Iterator, ListIterator, DescendingIterator.
         * - Fail-fast, supports bidirectional traversal.
         *
         * 3. Differences Between ArrayList and LinkedList
         *
         * 3.1 Data Structure
         * - ArrayList: Dynamic array (contiguous memory).
         * - LinkedList: Doubly-linked list (nodes with pointers).
         *
         * 3.2 Performance (Time Complexity)
         * | Operation        | ArrayList      | LinkedList     | Notes                                            |
         * |------------------|----------------|----------------|--------------------------------------------------|
         * | Add (end)        | O(1) amortized | O(1)           | ArrayList resizes occasionally; LinkedList O(1). |
         * | Add (index)      | O(n)           | O(n)           | ArrayList shifts; LinkedList traverses.          |
         * | Add (first/last) | O(n)/O(1)      | O(1)/O(1)      | LinkedList faster at start.                      |
         * | Remove (index)   | O(n)           | O(n)           | ArrayList shifts; LinkedList traverses.          |
         * | Remove (first/last) | O(n)/O(1)   | O(1)/O(1)      | LinkedList faster at start.                      |
         * | Get (index)      | O(1)           | O(n)           | ArrayList direct access; LinkedList traverses.   |
         * | Set (index)      | O(1)           | O(n)           | Same as get.                                     |
         * | Search (contains)| O(n)           | O(n)           | Linear search unless sorted.                     |
         * | Size             | O(1)           | O(1)           | Both maintain size field.                        |
         *
         * 3.3 Memory Usage
         * - ArrayList:
         *   - More efficient due to contiguous storage.
         *   - Wastes memory if capacity > size (use trimToSize).
         *   - Example: 100 Integers use ~400 bytes + overhead.
         * - LinkedList:
         *   - Higher overhead due to Node objects.
         *   - Example: 100 Integers use ~2400–3200 bytes.
         *
         * 3.4 Use Cases
         * - ArrayList:
         *   - Best for: Random access, iteration, append-heavy operations.
         *   - Examples: Database query results, end-addition lists.
         *   - Not ideal for: Frequent insertions/deletions in middle/start.
         * - LinkedList:
         *   - Best for: Frequent insertions/deletions at start/end, queues/stacks.
         *   - Examples: Task scheduler, playlist with start/end modifications.
         *   - Not ideal for: Random access, iteration.
         *
         * 3.5 Additional Features
         * - ArrayList: Implements List, simple API.
         * - LinkedList: Implements List and Deque, supports addFirst, push, pop, etc.
         *
         * 3.6 Thread Safety
         * - Both not thread-safe.
         * - Use Collections.synchronizedList or CopyOnWriteArrayList/ConcurrentLinkedDeque.
         *
         * 3.7 Cache Performance
         * - ArrayList: Better cache locality due to contiguous memory.
         * - LinkedList: Poor cache locality due to scattered nodes.
         *
         * 3.8 Example Analysis
         * - Add (end): ArrayList slightly faster due to cache locality.
         * - Add (start): LinkedList faster due to pointer updates vs. ArrayList shifting.
         * - Get: ArrayList significantly faster (O(1) vs. O(n)).
         *
         * 5. When to Use Which?
         * - Use ArrayList:
         *   - For fast random access and iteration.
         *   - When memory efficiency matters.
         *   - For end-addition or sequential access.
         *   - Example: Database records display.
         * - Use LinkedList:
         *   - For frequent start/end additions/removals.
         *   - For queue/deque implementations.
         *   - When insertion/deletion performance > memory concerns.
         *   - Example: Playlist with start/end changes.
         *
         * 6. Edge Cases and Pitfalls
         * - ArrayList:
         *   - Pitfall: Frequent resizing degrades performance. Use initial capacity.
         *   - Edge Case: Adding beyond Integer.MAX_VALUE throws OutOfMemoryError.
         * - LinkedList:
         *   - Pitfall: Poor performance for large lists due to traversal/cache misses.
         *   - Edge Case: Excessive node creation increases memory and GC pressure.
         *
         * 7. Conclusion
         * - ArrayList:
         *   - Pros: Fast random access, memory-efficient, cache-friendly.
         *   - Cons: Slow for frequent insertions/deletions in start/middle, resizing overhead.
         * - LinkedList:
         *   - Pros: Fast for start/end insertions/deletions, versatile as Deque.
         *   - Cons: Slow random access, high memory overhead, poor cache performance.
         *
         * Understanding these internals helps select the right data structure based on operation patterns,
         * size, and performance requirements.
         */
    }
}
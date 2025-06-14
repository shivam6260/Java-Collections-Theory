package com.collections.queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueue1 {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Queue<Integer> pq1 = new PriorityQueue<>();

        // Priority Queue is very important Data structure
        /**
         🔷 1. Definition and Purpose

         PriorityQueue<Integer> pq = new PriorityQueue<>();

         A PriorityQueue is a special kind of queue in Java:
         Elements are ordered by priority, not by insertion order.
         Internally, it uses a binary heap data structure.

         By default, it is a min-heap — the smallest element is always at the head of the queue.
         You can change the ordering using a custom Comparator.

         🔷 2. Hierarchy

         public class PriorityQueue<E> extends AbstractQueue<E>
         implements Serializable

         It is part of the java.util package.

         🔷 3. Internal Data Structure
         ✅ Backed by an array-based binary heap (min-heap by default):
         Internally, it maintains:

         transient Object[] queue; // the heap
         private int size = 0;     // number of elements
         The array starts with a default capacity of 11.

         Heap is not sorted entirely — only partially ordered to maintain the heap invariant:
         For min-heap: queue[i] ≤ queue[2i+1] and queue[i] ≤ queue[2i+2] (children).


         🔷 4. Heap Operations (Core of PriorityQueue)

         ✅ Insertion: offer(E e) or add(E e)
         Steps:
         Add element at the end of the array.
         Perform heapify-up (siftUp) to restore heap invariant.

         Code Logic:

         queue[size] = e;
         siftUp(size, e);
         size++;

         Heapify-up compares the element with its parent and swaps
         if it’s smaller (min-heap). It continues until the correct position is found.

         🔹 Time Complexity: O(log n)


         ✅ Removal: poll() (removes head / smallest)
         Steps:
         Replace root (queue[0]) with the last element.
         Set the last slot to null and decrease size.
         Perform heapify-down (siftDown) to fix heap.

         Code Logic:

         E result = (E) queue[0];
         E x = (E) queue[--size];
         queue[size] = null;
         siftDown(0, x);
         Heapify-down compares the new root with its children and
         swaps with the smaller child until the heap property is restored.

         🔹 Time Complexity: O(log n)


         🔷 5. How Binary Heap is Structured in Array
         Heap is a complete binary tree, stored in an array like this:

         Index:      0   1   2   3   4   5   6
         Element:    10 20  15 30  40  50  70
         ↑
         root
         For a node at index i:
         Left child: 2*i + 1
         Right child: 2*i + 2
         Parent: (i - 1) / 2

         🔷 6. Example: PriorityQueue Behavior
         PriorityQueue<Integer> pq = new PriorityQueue<>();
         pq.add(20);
         pq.add(10);
         pq.add(30);
         pq.add(5);

         Internally (heap property maintained):
         5
         / \
         10   30
         /
         20

         Backing array (partially ordered):
         queue = [5, 10, 30, 20]

         Now:
         pq.peek() → 5
         pq.poll() → removes 5 → heapify → 10 becomes new root.

         🔷 8. Important Notes
         | Feature                        | Value                                              |
         | ------------------------------ | -------------------------------------------------- |
         | Allows `null`?                 | ❌ No, throws `NullPointerException`                |
         | Thread-safe?                   | ❌ No (use `PriorityBlockingQueue` for threads)     |
         | Backing structure              | Binary heap (min-heap or max-heap)                 |
         | Maintains full sort?           | ❌ No, just heap order                              |
         | Can be used with custom types? | ✅ Yes, if `Comparable` or `Comparator` is provided |

         🔷 9. Summary of Time Complexities
         | Operation | Time Complexity |
         | --------- | --------------- |
         | `offer()` | O(log n)        |
         | `poll()`  | O(log n)        |
         | `peek()`  | O(1)            |


         🔷 1. What are siftUp() and siftDown()?

         ✅ siftUp(index, element)
         Happens after inserting a new element.
         Goal: Move the element up the tree until the min-heap property is restored.

         ✅ siftDown(index, element)
         Happens after removing the root element (the minimum).
         Goal: Move the element down the tree to restore min-heap.


         🔷 6. Visual Summary
         🔼 siftUp() (after insert):

         Insert → end of array → compare with parent → move up until heap valid

         🔽 siftDown() (after remove):

         Remove root → replace with last element → compare with children → move down until heap valid
         */
    }
}

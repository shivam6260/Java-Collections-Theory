package com.collections.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDeque3 {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<Integer>();
        /// Deque working as Stack
//        deque.push(5);
//        deque.push(10);
//        deque.push(15);
//        System.out.println(deque.peek());
//        System.out.println(deque.poll());

        /// Deque working as Queue
//        deque.add(25);
//        deque.add(30);
//        deque.add(35);
//        System.out.println(deque.peek());
//        System.out.println(deque.poll());
//        System.out.println(deque);

        /// Deque as Both
        deque.addFirst(5);
        deque.addFirst(10);
        deque.addFirst(20);
        deque.addLast(25);
        System.out.println(deque);

        deque.pollFirst();
        System.out.println(deque);
        deque.pollLast();
        System.out.println(deque);


        ///  Double-ended queue
        ///  Allows insertion and removal of elements from both ends
        ///  Versatile than regular queues and stacks because they support all the operations of both

        /**
         INSERTION METHODS
         addFirst(E e): Inserts the specified element at the front.
         addLast(E e): Inserts the specified element at the end.
         offerFirst(E e): Inserts the specified element at the front if possible.
         offerLast(E e): Inserts the specified element at the end if possible.
         */


        /**
         REMOVAL METHODS
         removeFirst(): Retrieves and removes the first element.
         removeLast(): Retrieves and removes the last element.
         pollFirst(): Retrieves and removes the first element, or returns null if empty.
         pollLast(): Retrieves and removes the last element, or returns null if empty.
         */

        /**
         EXAMINATION METHODS
         getFirst(): Retrieves, but does not remove, the first element.
         getLast(): Retrieves, but does not remove, the last element.
         peekFirst(): Retrieves, but does not remove, the first element, or returns null if empty.
         peekLast(): Retrieves, but does not remove, the last element, or returns null if empty.
         */

        /**
         STACK METHODS
         push(E e): Adds an element at the front (equivalent to addFirst(E e)).
         pop(): Removes and returns the first element (equivalent to removeFirst())..
         */

        /**
         🔷 1. What is ArrayDeque?

         Deque<Integer> deque = new ArrayDeque<>();

         ✅ It is a resizable-array-based implementation of the Deque interface.

         This means:
         You can add/remove elements from both ends (addFirst, addLast, removeFirst, removeLast).
         Backed by a circular array, not linked list.
         Faster than LinkedList in most Deque use-cases.

         🔷 2. Class Declaration and Inheritance

         public class ArrayDeque<E> extends AbstractCollection<E>
         implements Deque<E>, Cloneable, Serializable

         Implements Deque — supports stack, queue, and deque behavior.
         Not thread-safe, and does not allow null elements.

         🔷 3. Internal Data Structure
         Internally, ArrayDeque uses a resizable circular array:

         transient Object[] elements;
         transient int head;
         transient int tail;

         ✅ Key fields:
         | Field      | Purpose                                    |
         | ---------- | ------------------------------------------ |
         | `elements` | The actual backing array                   |
         | `head`     | Index of the first element                 |
         | `tail`     | Index after the last element (insert here) |

         🔁 Circular buffer behavior:
         The array is treated as circular — if tail reaches the end, it wraps around to 0.

         🔷 4. How Operations Work Internally

         ✅ addLast(e) / offerLast(e) — Add to tail (right end)
         elements[tail] = e;
         tail = (tail + 1) % elements.length;

         If tail == head after insert → array is full → resize array to 2× size.

         ✅ addFirst(e) / offerFirst(e) — Add to head (left end)
         head = (head - 1 + elements.length) % elements.length;
         elements[head] = e;

         Again, if full → resize.

         ✅ removeFirst() / pollFirst() — Remove from head

         E result = (E) elements[head];
         elements[head] = null;
         head = (head + 1) % elements.length;

         ✅ removeLast() / pollLast() — Remove from tail

         tail = (tail - 1 + elements.length) % elements.length;
         E result = (E) elements[tail];
         elements[tail] = null;

         🔷 5. Array Resizing (When Full)
         When size == capacity, a new array of size 2× is created,
         and elements are copied over in proper order from head to tail.

         Resizing logic example:

         private void doubleCapacity() {
         int p = head;
         int n = elements.length;
         int r = n - p; // number of elements to the right of head
         Object[] a = new Object[n << 1]; // double the size
         System.arraycopy(elements, p, a, 0, r);
         System.arraycopy(elements, 0, a, r, p);
         elements = a;
         head = 0;
         tail = n;
         }

         🚀 This ensures:
         Head is reset to 0
         Elements are in correct logical order

         🔷 7. Time Complexities
         | Operation        | Time Complexity |
         | ---------------- | --------------- |
         | `addFirst`       | O(1) amortized  |
         | `addLast`        | O(1) amortized  |
         | `removeFirst`    | O(1)            |
         | `removeLast`     | O(1)            |
         | `peekFirst/Last` | O(1)            |

         🔷 8. Comparison with Other Structures
         | Feature                | `ArrayDeque`             | `LinkedList`        | `Stack` (legacy)         |
         | ---------------------- | ------------------------ | ------------------- | ------------------------ |
         | Backing structure      | Resizable circular array | Doubly linked list  | Dynamic array (`Vector`) |
         | Null elements allowed? | ❌ No                     | ✅ Yes               | ✅ Yes                    |
         | Thread-safe            | ❌ No                     | ❌ No                | ✅ Yes (synchronized)     |
         | Performance            | 🚀 Best for Deque        | Slower due to nodes | Slower & legacy          |


         */


    }
}

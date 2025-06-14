package com.collections.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueLinkedList2 {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        /**
         We using the LinkedList class from Java Collections Framework,
         but interacting with it through the Queue interface.
         This is a very common and efficient way to use a FIFO (First-In-First-Out) queue.

         Now, let’s go deep into the internal working of LinkedList in Java, including:

         ✅ 1. What is LinkedList using internally?
         Java's LinkedList is implemented as a doubly linked list.
         Each element in the list is represented by a Node object, which contains:

         The data (your actual value)
         A reference to the next node
         A reference to the previous node

         In simplified form, the internal Node class looks like:

         private static class Node<E> {
         E item;
         Node<E> next;
         Node<E> prev;

         Node(Node<E> prev, E element, Node<E> next) {
         this.item = element;
         this.next = next;
         this.prev = prev;
         }
         }

         ✅ 2. How data is stored and managed?
         Let’s see how different operations work:

         ➤ Adding an element: queue.add(10) or offer(10)

         A new node is created with the value 10.
         It is added at the end (tail) of the doubly linked list.
         The tail pointer is updated to point to this new node.
         Time complexity: O(1)

         ➤ Removing an element: queue.poll() or remove()
         The element at the head (first node) is removed.
         The head pointer is updated to point to the next node.
         Time complexity: O(1)

         ➤ Peek element: queue.peek()
         Returns the data from the head node, without removing it.
         Time complexity: O(1)

         ✅ 3. Pointers maintained by LinkedList
         Internally, LinkedList maintains:

         A Node<E> first (the head of the list)
         A Node<E> last (the tail of the list)
         An int size (the number of elements)


         ✅ 4. LinkedList and Queue
         Since LinkedList implements the Queue interface, it provides these methods:
         | Method     | What it does                                   |
         | ---------- | ---------------------------------------------- |
         | `add(e)`   | Adds element to tail; throws exception if full |
         | `offer(e)` | Adds element to tail; returns false if full    |
         | `poll()`   | Removes and returns head or null if empty      |
         | `remove()` | Removes and returns head; exception if empty   |
         | `peek()`   | Returns head without removing                  |


         ✅ 6. Why LinkedList is preferred for Queue
         Queues are mostly used for insertion at end and removal at start, which is O(1) in a doubly linked list.

         No array resizing, no element shifting — perfect for queue use cases.

         */
    }
}

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

         */


    }
}

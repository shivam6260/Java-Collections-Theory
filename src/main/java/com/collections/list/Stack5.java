package com.collections.list;

import java.util.Stack;

public class Stack5 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();

        /*
        📚 Stack in Java Collections – Complete Explanation with Internal Working

In Java, a Stack is a data structure that follows the LIFO principle: Last-In,
First-Out. It means the last element inserted is the first one to be removed.

🔸 Where is Stack in Java Collections?
The Stack class is a part of the Java Collections Framework, and it is defined in the package:


java.util.Stack

It extends the Vector class, which makes it a legacy class but still widely used for stack behavior.

public class Stack<E> extends Vector<E>
So, it inherits all the methods of Vector and also provides additional methods specific to stack behavior.

🔸 Internal Working of Stack in Java
Internally, Stack uses a resizable array, inherited from Vector, to store elements.

🔹 Key Internal Concepts:
Storage: Internally backed by an Object array from Vector.

Resizing: Automatically resizes (doubles capacity) when more elements are added beyond current capacity.

Thread-Safety: Since Vector is synchronized, Stack is also synchronized.

🔸 Common Methods in Stack
Method	            Description
push(E item)	    Adds item on top of stack.
pop()	            Removes and returns the top item.
peek()	            Returns top item without removing it.
empty()	            Checks if stack is empty.
search(Object o)	Returns position (1-based) from top if found; else -1

✅ Example:
import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        stack.push("Apple");
        stack.push("Banana");
        stack.push("Cherry");

        System.out.println("Top element (peek): " + stack.peek()); // Cherry
        System.out.println("Removed element (pop): " + stack.pop()); // Cherry
        System.out.println("New Top element: " + stack.peek()); // Banana

        System.out.println("Is stack empty? " + stack.empty()); // false
        System.out.println("Search 'Apple': " + stack.search("Apple")); // 2
    }
}

🔸 When to Use Java's Stack?
✅ Use it when:

You need thread-safety and don’t want to use external synchronization.

The data access is strictly LIFO.

❌ Avoid it when:

Performance is critical — prefer Deque (ArrayDeque) for non-synchronized stack-like behavior, which is faster.

🔸 Modern Alternative: Deque as Stack

Deque<Integer> stack = new ArrayDeque<>();
stack.push(10);
stack.push(20);
System.out.println(stack.pop()); // 20
✅ ArrayDeque is not synchronized but faster and preferred in most cases today unless you explicitly need synchronization.

🔍 Summary
Feature	Stack	ArrayDeque
Base Class	Vector (synchronized)	Resizable Array (no sync)
Thread-Safe	Yes	No
Performance	Slower (due to sync)	Faster
Preferred for	Legacy, Thread-safe usage	Modern, high-performance

Would you like to explore internal source code of or to see how methods like push() and pop() work line-by-line?
         */
    }
}

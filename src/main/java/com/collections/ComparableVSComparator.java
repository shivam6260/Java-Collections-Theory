package com.collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Student  implements Comparable<Student> {
    private int age ;
    private String name;
    private String college;

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", college='" + college + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        if(this.getName().equals(o.getName())) {
            return this.getAge() - o.getAge();
        }else {
            return this.getName().compareTo(o.getName());
        }
    }
}

public class ComparableVSComparator {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(28,"Shivam","DYP"));
        list.add(new Student(26,"Shivam","MIT"));
        list.add(new Student(27,"Shweta","DYP"));
        list.add(new Student(31,"Akshay","NIT"));

//        Collections.sort(list);
//        list.stream().forEach(x -> System.out.println(x));

        Comparator<Student> customSort = (s1 , s2) -> s1.getAge() - s2.getAge();
        Collections.sort(list , customSort);
        list.stream().forEach(x -> System.out.println(x));



    }
}



/*
✅ 1. What is Comparable in Java?
🔹 Comparable<T> is an interface in java.lang
It allows an object to be compared to another object of the same type, using natural ordering.

🔧 Method to implement:

public interface Comparable<T> {
    public int compareTo(T o);
}
This method returns:
0 if equal
< 0 if this is smaller than o
> 0 if this is greater than o

📦 Example:

class Student implements Comparable<Student> {
    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int compareTo(Student other) {
        return this.id - other.id;
    }

    public String toString() {
        return id + " " + name;
    }
}

Now:
List<Student> list = new ArrayList<>();
list.add(new Student(2, "Ravi"));
list.add(new Student(1, "Amit"));

Collections.sort(list); // Uses compareTo
✔️ Sorted by id because we defined it in compareTo().


✅ 2. What is Comparator in Java?
🔹 Comparator<T> is an interface in java.util
It is used to define custom sorting logic, outside the object’s class.

🔧 Methods to implement (Java 8+):
public interface Comparator<T> {
    int compare(T o1, T o2);
    // Optional: equals(), reversed(), thenComparing() etc.
}
📦 Example:

class SortByName implements Comparator<Student> {
    public int compare(Student a, Student b) {
        return a.name.compareTo(b.name);
    }
}
Now:
Collections.sort(list, new SortByName()); // Sort by name instead of ID
✔️ No need to touch the original Student class.

⚡ Java 8+ Comparator with Lambda
list.sort((a, b) -> a.name.compareTo(b.name));


🆚 3. Difference between Comparable vs Comparator
| Feature                      | `Comparable`                               | `Comparator`                    |
| ---------------------------- | ------------------------------------------ | ------------------------------- |
| Package                      | `java.lang`                                | `java.util`                     |
| Purpose                      | Natural/default sorting                    | Custom sorting                  |
| Method                       | `compareTo(T o)`                           | `compare(T o1, T o2)`           |
| Affects                      | The class itself                           | External to class               |
| Modifiable?                  | Must modify class                          | No need to touch original class |
| Used by                      | `Collections.sort()`, `TreeSet`, `TreeMap` | Same + supports multiple logic  |
| Allows multiple sort orders? | ❌ No                                       | ✅ Yes                           |
| Functional Interface?        | ❌ (Pre-Java 8)                             | ✅ (Java 8+, can use lambdas)    |


💡 4. Why We Need Both?

🔸 Why need Comparator if we have Comparable?

You can't sort in multiple ways using Comparable alone.
You might not own the class (e.g., sorting String, Date).
It's bad design to modify model classes just for sort logic.
Comparator gives more flexibility (chaining, reverse, etc.)

🔸 Why need Comparable if we have Comparator?

If your class has a natural ordering, define it once via Comparable.
Required in some structures like:
TreeSet<T> (without custom comparator)
TreeMap<K, V> if you want default key order

It's more concise and built-in in many APIs

✅ Real-World Scenario

class Product implements Comparable<Product> {
    int id;
    double price;

    public Product(int id, double price) {
        this.id = id;
        this.price = price;
    }

    public int compareTo(Product other) {
        return Double.compare(this.price, other.price); // Natural sort: by price
    }
}
Now, suppose later you want to sort by id:

class SortById implements Comparator<Product> {
    public int compare(Product a, Product b) {
        return a.id - b.id;
    }
}
You can now choose sorting strategy:

Collections.sort(list); // by price
Collections.sort(list, new SortById()); // by id

🧠 Summary
| Concept          | Comparable          | Comparator                               |
| ---------------- | ------------------- | ---------------------------------------- |
| Where Defined    | Inside class        | Outside class                            |
| Interface Method | `compareTo(T o)`    | `compare(T o1, T o2)`                    |
| Used For         | Natural order       | Custom/multiple orders                   |
| Good For         | One default sort    | Multiple flexible sorts                  |
| Example          | `String`, `Integer` | Custom logic (e.g., sort by age, salary) |


 */
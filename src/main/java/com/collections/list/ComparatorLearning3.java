package com.collections.list;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Student {
    public double gpa;
    public String name;
}

/// 1st way - with Class ( Traditional Approach )
class CustomComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        return s1.getName().length() - s2.getName().length();
    }
}
public class ComparatorLearning3 {
    public static void main(String[] args) {
        Student s1 = new Student(4.5,"Shivam");
        Student s2 = new Student(3.5,"Shwta");
        Student s3 = new Student(3.8,"Dink");
        Student s4 = new Student(4.2,"Lucky");
        Student s5 = new Student(4.2,"Mayan");

        List<Student> list = new ArrayList<Student>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);

        /// 2nd Way - With Lambda Expression
        Comparator<Student> customComparator2 = (a , b) -> {
            if(a.getGpa() == b.getGpa()) {
                return a.getName().length() - b.getName().length();
            }
            if(a.getGpa() - b.getGpa() < 0) {
                return 1;
            }else {
                return -1;
            }
        };

        /// 3rd Way - Direct using List.sort()
        list.sort( ( a , b ) -> {
            if(a.getGpa() == b.getGpa()) {
                return a.getName().length() - b.getName().length();
            }
            if(a.getGpa() - b.getGpa() > 0) {
                return 1;
            }else {
                return -1;
            }
        } );
        System.out.println(list);

        Collections.sort(list, customComparator2);
        System.out.println(list);

    }
}

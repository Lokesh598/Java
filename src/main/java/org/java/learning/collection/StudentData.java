package org.java.learning.collection;

import org.java.learning.model.Address;
import org.java.learning.model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class StudentData {

     public List<Student> studentDetails() {
            List<Student> student = new ArrayList<>();
            List<List<Student>> studentsList = new ArrayList<>();

             student.add(new Student("Mayukh", "11th", 130, "Ram lal", "8290048152",
                    new Address(63, "Ganga Sadan", "shri krishna residency", "Sanganer", "Jaipur", 302029 )));
            student.add(new Student("Nikhil", "11th", 140, "Sharma", "834908209482",
                    new Address(63, "Mayavati", "Niketan Marg", "Ratanada", "Jodhpur", 12423)));

        return student;
    }
}

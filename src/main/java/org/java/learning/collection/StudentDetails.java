package org.java.learning.collection;

import org.java.learning.model.Student;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class StudentDetails {
    public static void main(String[] args) {
        StudentData studentData = new StudentData();
        List<Student> list = studentData.studentDetails();
        list.stream()
                .filter(i-> Objects.equals(i.getName(), "Nikhil"))
                .toList()
                .stream()
                .flatMap(lines -> Stream.of(lines.getName(), lines.getRollNumber(), lines.getFatherName(), lines.getContactNumber(), lines.getStandard()))
                .toList()
                .forEach(System.out::println);
        list.stream().toList().stream().forEach(System.out::println);

        printListOfStudents(studentData);
    }
    public static void printListOfStudents(StudentData studentData) {
        List<Student> students = studentData.studentDetails();
        List<List<Student>> listOfStudents = Collections.singletonList(students);
        listOfStudents.stream().toList().stream().forEach(System.out::println);
    }
}

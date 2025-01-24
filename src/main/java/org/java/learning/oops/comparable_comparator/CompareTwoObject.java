package org.java.learning.oops.comparable_comparator;

import java.util.Arrays;
import java.util.Comparator;

public class CompareTwoObject {


    private static class Person implements Comparable<Person> {
        private int age;

        Person() {}
        @Override
        public int compareTo(Person o) {
            return Integer.compare(this.age, o.age);
        }
    }

    public static void main(String[] args) {
        Person p1 = new Person();
        p1.age = 10;

        Person p2 = new Person();
        p2.age = 12;

        Person p = new Person();

        System.out.println(p.compareTo(p1));
        System.out.println(p.compareTo(p2));

    }


    private static class Employee implements Comparable<Employee>{

        private int id;
        private String name;
        private int age;
        private long salary;

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public long getSalary() {
            return salary;
        }

        public Employee(int id, String name, int age, int salary) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.salary = salary;
        }

        @Override
        public int compareTo(Employee emp) {
            System.out.println((this.id - emp.id));
            return (this.id - emp.id);
        }

        @Override
        //this is overridden to print the user-friendly information about the Employee
        public String toString() {
            return "[id=" + this.id + ", name=" + this.name + ", age=" + this.age + ", salary=" +
                    this.salary + "]";
        }

        public static Comparator<Employee> SalaryComparator = new Comparator<>() {

            @Override
            public int compare(Employee e1, Employee e2) {
                return (int) (e1.getSalary() - e2.getSalary());
            }
        };

        public static void main(String[] args) {
            //sorting object array
            Employee[] empArr = new Employee[5];
            empArr[0] = new Employee(10, "Mikey", 25, 10000);
            empArr[1] = new Employee(20, "Arun", 29, 20000);
            empArr[2] = new Employee(5, "Lisa", 35, 5000);
            empArr[3] = new Employee(1, "Pankaj", 32, 50000);
            empArr[4] = new Employee(25, "Pankplpaj", 32, 50000);

//sorting employees array using Comparable interface implementation
//            Arrays.sort(empArr); //classcastexception
            Arrays.sort(empArr, Employee.SalaryComparator);
            System.out.println("Default Sorting of Employees list:\n"+Arrays.toString(empArr));

            System.out.println("Employees list sorted by Salary:\\n"+Arrays.toString(empArr));
        }
    }


}

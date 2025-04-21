package org.java.learning.java8.streams.practive;

import java.util.*;
import java.util.stream.Collectors;

public class Employee {

    static class Employees {
        private String name;
        private String department;
        private double salary;
        private int age;

        public Employees(String name, String department, double salary, int age) {
            this.name = name;
            this.department = department;
            this.salary = salary;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public String getDepartment() {
            return department;
        }

        public double getSalary() {
            return salary;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Employee: {name='" + name + "', department='" + department + "', salary=" + salary + "', age="+age+ '}';
        }

        public static void main(String[] args) {
            List<Employees> employees = Arrays.asList(
                    new Employees("Alice", "HR", 3000, 25),
                    new Employees("Bob", "IT", 4000, 28),
                    new Employees("Charlie", "IT", 4500, 22),
                    new Employees("David", "Finance", 5000, 29),
                    new Employees("Eve", "HR", 3200, 21),
                    new Employees("Ivans", "IT", 3200, 26)
            );

            /**
             * 1. Group Employees by Department
             */

            Map<String, List<Employees>> employeesMap = employees.stream().collect(Collectors.groupingBy(Employees::getDepartment));
            employeesMap.forEach((department, employeeList) ->{
                System.out.println("Department:" + department);
                employeeList.forEach(System.out::println);
            });

            /**
             * 2. salary by department
             *
             */
            Map<String, Double> departementAndAvarageSalary = employees.stream().collect(Collectors.groupingBy(Employees::getDepartment,
                    Collectors.averagingDouble(Employees::getSalary)));
            departementAndAvarageSalary.forEach((department, avgSalary) ->{
                System.out.println("Department:" + department + "average salary" + avgSalary);
            });

            /**
             * 3. Count Employees in Each Department
             */

            Map<String, Long> list = employees.stream().collect(Collectors.groupingBy(Employees::getDepartment,
                    Collectors.counting()));
            list.forEach((department, count) -> {
                System.out.println(department + count);
            });

            /**
             * 4. Find the Highest Salary in Each Department
             */

            Map<String, Optional<Employees>> maxSalaryByDept = employees.stream().collect(Collectors.groupingBy(Employees::getDepartment,
                    Collectors.maxBy(Comparator.comparingDouble(Employees::getSalary))));
            maxSalaryByDept.forEach((department, salary) -> {
                System.out.println(department + salary.orElse(null));
            });

            /**
             * 5. Concatenate Names of Employees by Department
             */

            Map<String, String> concateName = employees.stream().collect(Collectors.groupingBy(Employees::getDepartment,
                    Collectors.mapping(Employees::getName, Collectors.joining(","))));
            concateName.forEach((department, name) -> {
                System.out.println(department+name);
            });

            /**
             * Write code for the list of employees having age between the 25 and 30 and name starts with the ‘i’
             *
             */
            System.out.println("Employees having age b/w the 25-30");
            employees.stream().filter(i -> i.age >= 25 && i.age <= 30).toList().stream().filter(n->n.getName().charAt(0) == 'I').forEach(System.out::println);

        }
    }
}

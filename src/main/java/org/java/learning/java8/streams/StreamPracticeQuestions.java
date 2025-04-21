package org.java.learning.java8.streams;

import org.java.learning.java8.Student;

import javax.lang.model.util.ElementScanner14;
import javax.swing.text.html.parser.Entity;
import java.security.PublicKey;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class StreamPracticeQuestions {
    public static void main(String[] args) {
        Question1 question1 = new Question1();
        Question2 question2 = new Question2();
        Question3 question3 = new Question3();
        Question4 question4 = new Question4();
        question1.findNumberOfStudentsWhoHaveHighestMarks();
        question2.filterDuplicateStudentsAndUppercaseRemaining();
        question3.listOfSquareOfEvenNumbers();
        question4.filterAndCollectNameInList();
    }
}

class Question1 {
    public void findNumberOfStudentsWhoHaveHighestMarks() {
        List<Student> students = List.of((new Student("Lokesh", 100.0)),
                (new Student("Mayukh", 200.0)),
                (new Student("Ank", 10.0)),
                (new Student("Amit", 200.0)),
                (new Student("Anit", 100.0)));

        double maxMarks = students.stream().mapToDouble(Student::getMarks).max().orElseThrow(RuntimeException::new);

        List<Student> studentList = students.stream().filter(student -> student.getMarks() < maxMarks).toList();

        System.out.println( students.stream().map(Student::getMarks).distinct().sorted(Comparator.reverseOrder()).mapToDouble(a->a).skip(1).findFirst().getAsDouble());//        System.out.println("result = "+x);
        System.out.println("lokes");
        studentList.forEach(System.out::println);

    }

}

/**
 * Question 2.
 * Provided a list of Strings,
 * implement code to filter out duplicate Strings and convert the remaining ones to uppercase using Streams.
 */
class Question2 {
    /**
     * String Manipulation
     */
    public void filterDuplicateStudentsAndUppercaseRemaining() {
        List<Student> students = List.of((new Student("Lokesh", 100.0)),
                (new Student("Lokesh", 100.9)),
                (new Student("Amit", 200.9)));

        List<String> studentList = students.stream().map(student -> student.getName().toUpperCase()).collect(Collectors.toList());
        List<String> stringList = studentList.stream().distinct().map(String::toString).collect(Collectors.toList());
        System.out.println(stringList);
    }
}

/**
 * Question 3.
 * Given a list of integers, write code to find the square of each even number using Streams.
 */
class Question3 {
    /**
     * filtering and transformation
     */
    public void listOfSquareOfEvenNumbers() {
        List<Integer> integerList = List.of(1, 3, 4, 6);
        List<Integer> res = integerList.stream().filter(integer -> integer%2 == 0).map(integer -> integer*integer).collect(Collectors.toList());
        System.out.println(res);

        //find minimum
        integerList.stream().min(Integer::compareTo).stream().forEach(System.out::println);

        //find maximum
        integerList.stream().max(Integer::compareTo).stream().forEach(System.out::println);

        //find sum
        System.out.println(integerList.stream().mapToInt(Integer::intValue).sum());

        //find average
        integerList.stream().mapToInt(Integer::intValue).average().stream().forEach(System.out::println);

        /**
         * Custom Filtering:
         * Given a list of integers, filter out the numbers that are greater than 10 and less than 50.
         */
        integerList.stream().filter(i->i>3&&i<6).forEach(System.out::println);

        /**
         * Finding Element:
         * Given a list of integers, find and print the first square that is divisible by 3
         */
        List<Integer> integers = integerList.stream().filter(i->i%3 == 0).map(i->i*i).collect(Collectors.toList());
        System.out.println(integers.get(0));
        /**
         * Partitioning and Mapping:
         * Given a list of integers, partition them into two lists: one with even numbers and the other with odd numbers.
         * Then, square each number in both lists.
         */
        integerList.stream().filter(i->i%2==0).map(i->i*i).toList().forEach(System.out::println);
        integerList.stream().filter(i->i%2!=0).map(i->i*i).toList().forEach(System.out::println);
        /**
         * Using Optional:
         * Given a list of integers, find the maximum value and return it using an Optional.
         */
        Optional<Integer> maxValue = integerList.stream().max(Integer::compareTo);
        maxValue.ifPresent(max -> System.out.println("Max value using Optional : " + max));
    }
}

/**
 * Question 4.
 * Given a list of names, filter out the names that start with the letter 'A' and collect them into a new list.
 */
class Question4 {
    /**
     * Filter, Collect And Sort
     */
    public void filterAndCollectNameInList() {
        List<String> users = List.of("Amit", "Ashok", "Anmol", "Lokesh");
        List<String> userList = users.stream().filter(s -> s.startsWith("A")).collect(Collectors.toList());
        System.out.println(userList);

        /**
         * Sort the list of users
         */
        List<String> sortUser = users.stream().sorted().collect(Collectors.toList());
        System.out.println(sortUser);
        /**
         * Reduce Operation:
         * Given a list of strings, concatenate them into a single string using the reduce operation.
         */
        System.out.println(users.stream().reduce("",(accumulator, str) -> accumulator+" "+str));
        /**
         * Checking Predicate:
         * Given a list of strings, check if all strings have length greater than 3 using the allMatch method.
         */
        System.out.println(users.stream().allMatch(i->i.length()>3));
        /**
         * Grouping By with Downstream Collector:
         * Given a list of words, group them by their lengths and collect the words into a list for each length.
         */
        System.out.println(users.stream().collect(Collectors.groupingBy(i->i.length())));
        /**
         * Custom Sorting:
         * Given a list of strings, sort them based on their lengths in descending order.
         */
        System.out.println(users.stream().sorted((str1, str2) -> Integer.compare(str2.length(),str1.length())).collect(Collectors.toList()));
    }
}

class Question5 {
    /**
     * Combining List**
     */
    public static void main(String[] args) {
        List<Integer> integer1 = List.of(1, 6, 3, 5);
        List<Integer> integer2 = List.of(2, 1, 3, 4);
        List<Integer> resultList = integer1.stream()
                .map(i -> i*i)
                .collect(Collectors.toList())
                .stream()
                .flatMap(x->integer2.stream().map(i->i*i*i+x)).collect(Collectors.toList());
        System.out.println(resultList);

        /**
         * Combining Streams:
         * Given two lists of integers, create a new list that contains the elements of both lists, sorted in ascending order.
         */
        List<Integer> resultList1 = new ArrayList<>();
        resultList1.addAll(integer1);
        resultList1.addAll(integer2);
        System.out.println(resultList1.stream().sorted().collect(Collectors.toList()));
    }
}

/**
 * Question 6
 * Given a list of people with their names and ages, group them by age and print the result.
 */
class Question6 {
    public static void main(String[] args) {
        List<Person> people = List.of((new Person("Lucky", 12)), (new Person("Lalu", 13)));
        Map<Integer, List<Person>> groupedByAge = groupByAge(people);

        groupedByAge.forEach((age, persons) -> {
            System.out.println("Age: " + age);
            persons.forEach(person -> System.out.println("   " + person.getName()));
        });
    }
    public static Map<Integer, List<Person>> groupByAge(List<Person> people) {
        return people.stream().collect(Collectors.groupingBy(Person::getAge));
    }
    static class Person {
        private String name;
        private int age;
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        public String getName() {
            return name;
        }
        public int getAge() {
            return age;
        }
    }
}
/**
 * Given a list of lists of integers, use flatMap to create a single list containing all the integers.
 */
class Question7 {
    public static void main(String[] args) {
        List<List<Integer>> listList = List.of((List.of(1, 2, 3, 4)), List.of(5, 3, 7, 8));
        System.out.println(listList);

        List<Integer> listRes = listList.stream().flatMap(list -> list.stream().parallel()).collect(Collectors.toList());
        System.out.println(listRes);
    }
}
class Question8 {
    public static void main(String[] args) {
        List<Student> students = List.of(new Student("Ramesh", List.of(new Course("Math"), new Course("Science"))),
        new Student("Kamlesh", List.of(new Course("English"), new Course("Hindi"))));

        List<Course> coursesList = flattenIntoSingleList(students);
        System.out.println(coursesList);
    }
    /**
     * Nested Mapping:
     * Given a list of students, where each student has a list of courses,
     * flatten the list of courses into a single list.
     */
    public static List<Course> flattenIntoSingleList(List<Student> students) {
        return students.stream()
//                .flatMap(student -> student.getCourses().stream()).collect(Collectors.toList());
                .map(Student::getCourses)
                .toList()
                .stream()
                .flatMap(List::stream).collect(Collectors.toList());
    }
    public static class Student {
        private String name;
        private List<Course> courses;

        public Student(String name, List<Course> courses) {
            this.name = name;
            this.courses = courses;
        }
        public String getName() {
            return name;
        }
        public List<Course> getCourses() {
            return courses;
        }
    }
    public static class Course {
        private String courseName;

        public Course(String name) {
            this.courseName = name;
        }
        public String getCourseName() {
            return courseName;
        }

        @Override
        public String toString() {
            return courseName;
        }
    }
}

/**
 * Given a list of employees, find highest salary and print the name of employee.
 */
class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
    @Override
    public String toString() {
        return "Employee{name='" + name + "', salary=" + salary + "}";
    }
}
class Question9 {
    public static List<Employee> employees = List.of(
            new Employee("John", 50000),
            new Employee("Jane", 60000),
            new Employee("Mark", 55000),
            new Employee("Sophia", 75000),
            new Employee("Alex", 40000)
    );

    public static void main(String[] args) {
        double maxSal = employees.stream().mapToDouble(Employee::getSalary).max().orElseThrow();
        List<Employee> res1 = employees.stream().filter(employee -> employee.getSalary()==maxSal).collect(Collectors.toList());

        res1.add(new Employee("Ramesh", 100000));
        res1.forEach(System.out::println);

        Optional<Employee> res = employees.stream().max(Comparator.comparingDouble(Employee::getSalary));

        res.ifPresent(System.out::println);
    }
}

// Accumulate names into a List
// List<String> list = people. stream()   .map(Person::getName)   .collect(Collectors. toList());
// Accumulate names into a TreeSet
// Set<String> set = people. stream().map(Person::getName)   .collect(Collectors. toCollection(TreeSet::new));
// Convert elements to strings and concatenate them, separated by commas
// String joined = things. stream()   .map(Object::toString)   .collect(Collectors. joining(", "));
// Compute sum of salaries of employee
// int total = employees. stream()   .collect(Collectors. summingInt(Employee::getSalary));
// Group employees by department
// Map<Department, List<Employee>> byDept = employees. stream()   .collect(Collectors. groupingBy(Employee::getDepartment));
// Compute sum of salaries by department
// Map<Department, Integer> totalByDept = employees. stream()   .collect(Collectors. groupingBy(Employee::getDepartment,                                  Collectors. summingInt(Employee::getSalary)));  // Partition students into passing and failing Map<Boolean, List<Student>> passingFailing = students. stream()   .collect(Collectors. partitioningBy(s -> s. getGrade() >= PASS_THRESHOLD));



class Question10 {

    public static void main(String[] args) {
        List<String> ls = List.of("Apple", "Banana", "Mango", "Orange", "Pineapple", "Pineappl1", "Pineappl2");
        int len = ls.stream().mapToInt(String::length).max().orElseThrow();
        List<Map.Entry<String, Integer>> mp =
                ls.stream().collect(Collectors.toMap(str ->str, str->str.length()))
                                .entrySet()
                                        .stream()
                                                .filter(entry -> entry.getValue() == len)
                        .collect(Collectors.toList());
//                                                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        mp.forEach(i-> System.out.println(i.getKey()));
//        System.out.println(mp);
    }

}

class Question11 {
    public static void main(String[] args) {
        List<Integer> ls = List.of(1, 3, 4, 2, 3);

        int res = ls.stream()
                .collect(Collectors.groupingBy(num -> num, Collectors.counting())) // Count occurrences
                .entrySet().stream() // Stream over the map entries
                .filter(entry -> entry.getValue() > 1) // Retain duplicates
                .flatMap(entry -> Collections.nCopies(entry.getValue().intValue(), entry.getKey()).stream()) // Replicate duplicates
                .mapToInt(Integer::intValue) // Convert to int stream
                .sum();

        System.out.println(res);

        //find sum of duplucaes
//        ls.stream().map(integer -> integer.compareTo(integer ==
//        ls.stream().collect(Collectors.groupingBy(i->i, Collectors.counting())).forEach((k,v)->{
//            if(v>1) {
//                System.out.println(k);
//            }
//        });
//        HashMap<Integer, Integer> mp = new HashMap<>();
//
//        mp.put(0, 1);
//        mp.put(1, 2);
//        mp.put(2, 3);
//        mp.put(5, 4);
//        mp.put()
//        for (int i = 0; i < mp.size(); i++) {
//            ;
//        }

//        for(Map.Entry<Integer, Integer> x : mp.entrySet()) {
//            x.getKey();
//
//        }
//
//        Map<Integer, Long> mp1 = ls.stream().collect(Collectors.groupingBy(i -> i, Collectors.counting()));
////        1 1
////            2 2
////            3 2
////        int sum = 0;
//        int sum = mp1.entrySet().stream().filter(i -> i.getValue()>1).mapToInt(Map.Entry::getKey).sum();
////        System.out.println(sum);
//
//        int duplicateSum = ls.stream()
//                .collect(Collectors.groupingBy(num -> num, Collectors.counting())) // Count occurrences
//                .entrySet().stream() // Stream over the map entries
//                .filter(entry -> entry.getValue() > 1) // Retain duplicates
//                .mapToInt(Map.Entry::getValue) // Extract keys (the duplicate numbers)
//                .sum(); // Sum the duplicate numbers
//
//        System.out.println("Sum of duplicates: " + duplicateSum);
    }
}
/**
* list of strings is given, modify is string by making first char of string as capital.
 */

class Question12 {
    public static void main(String[] args) {
        List<String> st = List.of("lokesh", "sion", "harish", "ankit");
        st.stream().map(i->i.substring(0, 1).toUpperCase()+i.substring(1)).collect(Collectors.toList()).forEach(System.out::println);
    }
}

/**
 * 1)From the list of employees, get the first employee from the list and return his fullName.
 * where fullName = firstname + lastname.
 */
class Question13 {
    private String firstName;
    private String lastName;
    private double salary;

    public Question13(String firstName, String lastName, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSalary() {
        return salary;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}

class Main {
    public static void main(String[] args) {
        List<Question13> employees = List.of(
                new Question13("John", "Doe", 50000),
                new Question13("Jane", "Smith", 60000),
                new Question13("Mark", "Johnson", 55000)
        );

        Optional<String> firstEmployeeFirstName = employees.stream()
                .findFirst()
                .map(Question13::getFirstName);
        Optional<String> firstEmployeeLastName = employees.stream()
                .findFirst()
                .map(Question13::getLastName);

        String fullName = String.valueOf(firstEmployeeFirstName) + String.valueOf(firstEmployeeLastName);

//        firstEmployeeFirstName.ifPresent(System.out::println);
//        firstEmployeeLastName.ifPresent(System.out::println);
        System.out.println(fullName);
    }
}

/**
 * Given a map with the department name as key and value as list of employees belonging to that department.
 * when a search string is given, need to list out the employees whose firstname or lastname is matching(match should be case insensitive).
 *
 * or
 *
 * Consider a list of employees,
 * and if a department name is given as argument, list out the employees which doesn't belong to that department.
 *
 * If deptName is "IT" update salary, use ifpresent
 */


class Question14 {
    private String firstName;
    private String lastName;
    private double salary;
    private String depart;

    public Question14(String firstName, String lastName, String depart, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.depart = depart;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepart() {
        return depart;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return "Question14{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", depart='" + depart + '\'' +
                '}';
    }
}

class Solution14 {

    static public List<Question14> employee = List.of(
            new Question14("John", "Doe", "CS", 50000),
            new Question14("John", "Doe", "CS", 60000),
            new Question14("Mark", "Johnson", "IT", 55000)
    );
    public static void main(String[] args) {

        Map<String, List<Question14>> res = employee.stream().collect(Collectors.groupingBy(i->i.getDepart(), Collectors.toList()));
        System.out.println(res);

        String str = "john";

        List<Question14> res1 = res.entrySet().stream().flatMap(i->i.getValue().stream().filter(s->s.getFirstName().toLowerCase().equals(str) || s.getLastName().toLowerCase() == str)).collect(Collectors.toList()).stream().toList();
//        System.out.println(res1);

        String str1 = "CS";
        List<Question14> res2 = res.entrySet().stream().flatMap(i->i.getValue().stream().filter(s->s.getDepart() != str1)).collect(Collectors.toList()).stream().toList();
        System.out.println(res2);

        String str2 = "IT";
        Optional<Question14> res3 = res.entrySet().stream().flatMap(i->i.getValue().stream().filter(s->s.getDepart().equalsIgnoreCase(str2))).findFirst();
        res3.stream().map(str4->str4.getSalary() + 12).forEach(System.out::println);
    }

}

/**
 * consider list of employees and list of employee ids.
 * return the list of employees matching with the given list of employee ids.
 */

class Question15 {

}

/**
 * 1, Consider a list of employees, get the count of employees based on the Gender
 *
 * 2, get Male and females list separetly and join the employee full names with delimeter -.
 * ex: MALE = {[Jhon-Mike-Jack]} and FEMALE ....
 */

class Question16 {
    private String name;
    private String gender;

    Question16(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Question16{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}

class Solution16 {
    static List<Question16> ls = List.of(new Question16("lokesh", "male"), new Question16("mayukh", "male"),
            new Question16(
            "sion", "female"));

    public static void main(String[] args) {
        Map<String, String> res = ls.stream().collect(Collectors.groupingBy(i->i.getGender(), Collectors.mapping(Question16::getName, Collectors.joining("-"))));
//                .entrySet()
//                .stream()
//                .map(i->i.getValue().stream().filter(x-> Objects.equals(x.getGender(), "female") || Objects.equals(x.getGender(), "male"))).toList().stream().toList();

        System.out.println("MALE = {"+res.getOrDefault("male","")+"}");
        System.out.println("FEMALE = {"+res.getOrDefault("male","")+"}");
//        res.stream().forEach(System.out::println);
    }
}

/**
 * Get all the employees in ascending order based on the salary.
 */
class Question17 {
    static List<Employee> ls = List.of(new Employee("lokesh", 2125), new Employee("sion", 2124),
    new Employee("lokeshsharm", 213445));

    public static void main(String[] args) {
//        System.out.println(
                List<Employee> res = ls.stream().sorted(Comparator.comparingDouble(Employee::getSalary)).toList();
        System.out.println(res);
//        );
        int[] nums = new int[]{4,1,2,1,2};

        Arrays.stream(nums).sum();
        Map<Integer, Integer> mp = new HashMap<>();
        Set<Integer> m1p = new HashSet<>();
        m1p.add(1);
        m1p.contains(1);
        for (int i = 0; i < nums.length; i++){

//            if (mp.containsKey(nums[i])) {
                mp.put(nums[i], mp.getOrDefault(nums[i], 0)+1);
//            }

//            mp.put(nums[i], 1);
        }
        //iterate map
        for (Map.Entry<Integer, Integer> x : mp.entrySet()) {
            if (x.getValue() == 1) {
                System.out.println(x.getKey());
            }
        }
        System.out.println(mp.get(2));
//        for (Map.Entry<Integer, Integer> x : mp.entrySet()) {
//            if (x.getValue() == 1)
//        }
    }
}

/**
 * /**
 * Print sum of prime numbers from a given list that contains n numbers.
 */
class PrintSumOfPrimeNumbers {
    public void main() {
        List<Integer> numbers = List.of(2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sumOfPrimes = numbers.stream()
                .filter(this::isPrime)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Sum of prime numbers: " + sumOfPrimes);

        System.out.println(numbers.stream().filter(this::isPrime).toList());
    }

    private boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        PrintSumOfPrimeNumbers ob = new PrintSumOfPrimeNumbers();
        ob.main();
    }
}

class Practice23Feb {
    private static void findCharFreqOfString(String str) {

        String[] strings=str.split("");
        Map<String,Long> map=Stream.of(strings).collect(Collectors.groupingBy(k->k,LinkedHashMap::new,Collectors.counting()));
        for(Map.Entry<String,Long> ch: map.entrySet()){
            System.out.println(ch.getKey()+" "+ ch.getValue());
        }

    }

    public static void main(String[] args) {

        findCharFreqOfString("mississipi");
    }
}




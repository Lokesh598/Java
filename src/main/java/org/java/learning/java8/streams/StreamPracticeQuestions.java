package org.java.learning.java8.streams;

import org.java.learning.java8.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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
                (new Student("Amit", 200.0)));

        double maxMarks = students.stream().mapToDouble(Student::getMarks).max().orElseThrow(RuntimeException::new);

        List<Student> studentList = students.stream().filter(student -> student.getMarks() == maxMarks).toList();

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

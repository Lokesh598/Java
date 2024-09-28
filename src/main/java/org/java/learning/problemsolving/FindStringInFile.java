package org.java.learning.problemsolving;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FindStringInFile {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\lsingh\\Desktop\\test.txt");
        String str = "hello11";
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains(str)) {
                System.out.println(true);
            }
        }
        System.out.println(false);
        scanner.close();
    }


}

class RemoveAllOccarenceOfChar {
    public static void main(String[] args) {
        String str = "hello11";
        String str1 = str.replace("l", "");
        System.out.println(str1);
    }
}
/**
 * 26. How do you get distinct characters and their count in a string in Java?
 */

class DistinctCharactersAndCount {
    public static void main(String[] args) {
        String str = "abcdABCDabcdABCD";
        char[] charArr = str.toCharArray();
        Map<Character, Integer> countChar = new HashMap<>();
        for (char c: charArr) {
            if (countChar.containsKey(c)) {
                countChar.put(c, countChar.get(c)+1);
            } else {
                countChar.put(c, 1);
            }
        }
        System.out.printf(countChar.toString());
    }
}

/**
 * 27. Can you prove that a String object in Java is immutable programmatically?
 */

class ImmutableString {
    public static void main(String[] args) {
        String str = "Java";
        String strCopy = str;

        System.out.printf(String.valueOf(str == strCopy));

        str = "python";

        System.out.printf(String.valueOf(str == strCopy));
        System.out.printf(strCopy);
    }
}

/**
 * 28. Can you write some code to showcase inheritance in Java?
 */

class InheritanceVehicle {
    String color = "red";
    public void stop() {
        System.out.print("apply break to stop vehicle");
    }
}

class Car extends InheritanceVehicle {
    public void stopCar() {
        InheritanceVehicle parentObject = new InheritanceVehicle();
        parentObject.stop();
    }

    public static void main(String[] args) {
        Car car = new Car();

        car.stopCar();
    }
}

/**
 * 29. How do you show a diamond problem with multiple inheritance in Java?
 *
 */


interface Vehicle {
    void start();
}
class Bus implements Vehicle {

        @Override
        public void start() {
            System.out.println("Bus started");
        }
}

class Truck implements Vehicle{
    @Override
    public void start() {
        System.out.println("Truck started");
    }
}

//class PrintOutput extends Bus, Truck {
//    public void main(String[] args) {
//        super.start();
//    }
//}

/**
 * 30. How do you illustrate a try catch example in Java?
 */

class TryCatchExample {
    public static void main(String[] args) {
        try {
            int a = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic exception occurred");
        }
    }
}
//multiple exceptions
class MultipleExceptions {
    public static void fun(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("x should be positive");
        } else if (x == 0) {
            throw new NullPointerException("x should not be 0");
        }
    }

    public static void main(String[] args) {
        try {
            fun(10);
        } catch (IllegalArgumentException|NullPointerException e) {
            System.out.print("e.getMessage()");
        }
    }
}

/**
 *  31. Write a Java program to show a NullPointerException.
 */

class NullPointerExceptionExample {
    public static void main(String[] args) {
        printString(null, 3);

    }

    static void printString(String s, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(s.toUpperCase()); // Exception in thread "main" java.lang.NullPointerException
        }
    }
    //should have null check in place for early validations

//static void printString(String s, int count) {
//    if (s == null) {
//        return;
//    }
//    for (int i = 0; i < count; i++) {
//        System.out.println(s.toUpperCase()); // Exception in thread "main" java.lang.NullPointerException
//    }
//}
}

class Employee {
    public record EmpRecord(String id, String name, double salary, Map<String, String> address) {

    }
}

/**
 * 33. How do you create text blocks in Java?
 */

class TextBlocks {
    public static void main(String[] args) {
        String textBlock = """
                This is a text block
                in Java
                I am programmer
                """;
        System.out.println(textBlock);
    }
}

/**
 * 34. Show an example of switch expressions and multi-label case statements in Java.
 * java 14 feature
 */
class TestSwitch {
    public static void main(String[] args) {
        int choice = 2;

        int x = switch (choice) {
            case 1, 2, 3:
                yield choice;
            default:
                yield -1;
        };

        System.out.println("x = " + x); // x = 2
    }
}

//use of lambda expression in switch case

class LambdaInSwitch {
    public static void main(String[] args) {
//        String day = "TH";
        Scanner sc = new Scanner(System.in);
        String day = sc.nextLine();
        String result = switch (day) {
            case "M", "W", "F" -> "MWF";
            case "T", "TH", "S" -> "TTS";

            default -> {
                if (day.isEmpty())
                    yield "Please insert a valid day.";
                else
                    yield "Looks like a Sunday.";
            }
        };

        System.out.println(result); // TTH

    }
}

/**
 * 36. How do you create an enum in Java?
 */

enum ThreadState {
    START,
    RUNNING,
    WAITING,
    DEAD
}

/**
 * 41. Show examples of overloading and overriding in Java.
 */
class Overloading {
    public void print(int a) {
        System.out.println("int: " + a);
    }

    public void print(double a) {
        System.out.println("double: " + a);
    }

    public void print(String a) {
        System.out.println("String: " + a);
    }

    public static void main(String[] args) {
        Overloading overloading = new Overloading();
        overloading.print(10);
        overloading.print(10.0);
        overloading.print("10");
    }
}

class Overriding {
    public void print() {
        System.out.println("Parent class");
    }
}
class Child extends Overriding {
    @Override
    public void print() {
        System.out.println("Child class");
    }

    public static void main(String[] args) {
        Child child = new Child();
        child.print();
    }
}


class Test {
    public static void main(String[] args) {
        String str = null;
        String str1="abc";

        System.out.println(str1.equals("abc") | str.equals(null));
    }
}



















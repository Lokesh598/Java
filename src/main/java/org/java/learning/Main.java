package org.java.learning;


class First {
    String y = Main.throughmethod("***first***");
    public void display() {
        System.out.println("First");
    }
}

class Second extends First {
    String x = Main.throughmethod("***second***");
    public void display() {
        System.out.println("Second");
    }
}

class Thrid extends Second {
    String x = Main.throughmethod("***Thrid***");
    public void display() {
        System.out.println("Second");
    }
}

public class Main {

    int i,   $a = 5;
    public Main() {
        System.out.println("Constructor " + i);
        i = 6;
        System.out.println($a);
    }
    {//instance initializer block
        System.out.println("Instance block " + i);
        i = 10;
    }
    public static String throughmethod(String s) {
        System.out.println(s);
        return s;
    }
    public static void main(String[] args) {
        byte var = ~9;
        System.out.println(var);
        System.out.println("Hello world!");
        int m = 3;
        System.out.println(m++ + ++m );

        double l = -1.0/0;
        System.out.println(l);

        String s = "12\u3456\u78910212";
        System.out.println(s.length());
        new Thrid().display();

        Main myObj = new Main();
        System.out.println(myObj.i);

        int a = 1, b = 2, c = 3;
        a = b = c ;
        System.out.println(a);

        boolean ab = false;
        if (!(ab&&ab)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        System.out.println("...................");
        byte d = (byte) 231;
        System.out.println(d);

        byte e = ~34;
        System.out.println(e);

        int f = 0123;
        System.out.println(f);
//        System.arraycopy(args, 0, args, 1, args.length);
        System.out.println("....................");
        int x = 12, y = 7, z = 3;
        System.out.println(x % y % z);
    }
}

class Test {
    public boolean b;
    public static void main(String[] args) {

        Test c = new Test();
        System.out.println(c.b);
    }

}

enum x {
    RUN;
}

class solution {

}

//enum Enums extends x{
//


//}

class ConversationEncryption {

    public static String processMessage(Integer operation, String message, String key) {
        try {
            // Check for null inputs
            if (operation == null || message == null || key == null) {
                throw new IllegalArgumentException("Operation, message, or key cannot be null.");
            }

            if (operation != 1 && operation != 2) {
                throw new IllegalArgumentException("Invalid operation. Use 1 for Encoding or 2 for Decoding.");
            }

            if (message.isEmpty() || key.isEmpty()) {
                throw new IllegalArgumentException("Message or key cannot be empty.");
            }

            // Validate that the key contains only digits
            if (!key.matches("\\d+")) {
                throw new IllegalArgumentException("Key must contain only positive digits.");
            }

            StringBuilder result = new StringBuilder();
            int keyIndex = 0;

            if (operation == 1) {
                // Encoding: Duplicate each character based on the key
                for (int i = 0; i < message.length(); i++) {
                    char currentChar = message.charAt(i);
                    int keyDigit = Character.getNumericValue(key.charAt(keyIndex % key.length()));

                    if (keyDigit <= 0) {
                        throw new IllegalArgumentException("Key must contain only positive digits.");
                    }

                    // Append the character keyDigit times
                    for (int j = 0; j < keyDigit; j++) {
                        result.append(currentChar);
                    }

                    keyIndex++;
                }
            } else if (operation == 2) {
                // Decoding: Retain only the original characters based on the key
                int messageIndex = 0;
                while (messageIndex < message.length()) {
                    char currentChar = message.charAt(messageIndex);
                    int keyDigit = Character.getNumericValue(key.charAt(keyIndex % key.length()));

                    if (keyDigit <= 0) {
                        throw new IllegalArgumentException("Key must contain only positive digits.");
                    }

                    // Append the character once
                    result.append(currentChar);

                    // Skip (keyDigit - 1) characters
                    messageIndex += keyDigit;

                    keyIndex++;
                }
            }


            return result.toString();
        } catch (Exception e) {
            // Return the exception message in case of any exception
            return "Error: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        // Example 1: Encoding
        String encodedMessage = processMessage(2, "Open", "123");
        System.out.println("lokes"+encodedMessage); // Output: Oppeeen

        // Example 2: Decoding
        String decodedMessage = processMessage(2, "Open", "123");
        System.out.println(decodedMessage); // Output: Open

        // Edge Case: Null operation
        String nullOperation = processMessage(null, "Open", "123");
        System.out.println(nullOperation); // Output: Error: Operation, message, or key cannot be null.

        // Edge Case: Null message
        String nullMessage = processMessage(1, null, "123");
        System.out.println(nullMessage); // Output: Error: Operation, message, or key cannot be null.

        // Edge Case: Null key
        String nullKey = processMessage(1, "Open", null);
        System.out.println(nullKey); // Output: Error: Operation, message, or key cannot be null.

        // Edge Case: Null operation, message, and key
        String allNull = processMessage(null, null, null);
        System.out.println(allNull); // Output: Error: Operation, message, or key cannot be null.

        // Edge Case: Invalid key (non-positive digit)
        String invalidKey = processMessage(1, "Open", "023");
        System.out.println(invalidKey); // Output: Error: Key must contain only positive digits.

        // Edge Case: Key shorter than message
        String shortKey = processMessage(1, "Open", "12");
        System.out.println(shortKey); // Output: Oppeen

        // Edge Case: Key longer than message
        String longKey = processMessage(1, "Open", "12345");
        System.out.println(longKey); // Output: Oppeeen

        // Edge Case: Decoding with key shorter than message
        String decodedShortKey = processMessage(2, "Oppeen", "12");
        System.out.println(decodedShortKey); // Output: Open

        // Edge Case: Decoding with key longer than message
        String decodedLongKey = processMessage(2, "Oppeeen", "12345");
        System.out.println(decodedLongKey); // Output: Open
    }
}
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
//enum Enums extends x{
//
//}
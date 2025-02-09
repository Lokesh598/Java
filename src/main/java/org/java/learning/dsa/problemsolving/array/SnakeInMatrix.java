package org.java.learning.dsa.problemsolving.array;

public class SnakeInMatrix {
    private static int snakePosition(int n, String[] commands) {

        int initalPos = 0;
        int col = 0, row = 0;
//        for (int i = 0; i < commands.length; i++) {
//            if (initalPos == 0 && commands.contains("LEFT")) {
//                continue;
//            } else if (initalPos == 0 && commands.contains("RIGHT")) {
//                while (col < n) {
//                    col++;
//                }
//                initalPos = n-1;
//                continue;
//            } else if (initalPos == n-1 && commands.contains("DOWN")) {
//                while (row < n) {
//                    row++;
//                }
//                initalPos = row-1;
//                continue;
//            } else if (initalPos == n-1 && commands.contains("LEFT")) {
//                while (col >= 0) {
//                    col--;
//                }
//                initalPos = row-1;
//                continue;
//            } else if (initalPos == n-1 && commands.contains("UP")) {
//                while (row >= 0) {
//                    row--;
//                }
//                initalPos = col-1;
//                continue;
//            }
//        }
//        return (row * n) + col;


        for (int i = 0; i < commands.length; i++) {

            switch (commands[i]) {
                case "RIGHT":
                    col = n-1;
//                    while (col < n) {
//                        col++;
//                    }
//                    col = col-1;
                    break;
                case "DOWN":
                    row = n-1;
//                    while (row < n) {
//                        row++;
//                    }
                    break;
                case "LEFT":
                    col = 0;
//                    while (col >= 0) {
//                        col--;
//                    }
                    break;
                case "UP":
                    row = 0;
//                    while (row > 0) {
//                        row--;
//                    }
                    break;
            }
        }
        return (row*n)+col;
    }

    public static void main(String[] args) {
        System.out.println(snakePosition(3, new String[]{"DOWN","RIGHT","UP"}));
    }
}

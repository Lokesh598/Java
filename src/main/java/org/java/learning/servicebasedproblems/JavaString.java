package org.java.learning.servicebasedproblems;

import java.util.ArrayList;
import java.util.List;

public class JavaString {

    /**
     * 9.check given word is present or not in a given Sentence.
     *   Ex: INPUT:
     *              String="Tell me about your self"
     *              word="about"
     *   output:TRUE
     *
     */
    private boolean searchString(String str, String search) {

        String[] string = str.split(" ");
        int first = 0;
        for (int i = 0; i< str.length()-1; i++) {
            if (str.charAt(i) == ' ') {
                if (str.substring(first, i).equals(search)) {
                    return true;
                }
                first = i+1;
            }
        }

        return false;
    }
    public static void main(String[] args) {

        JavaString js = new JavaString();
        System.out.println(js.searchString("Tell me about your self", "Tell"));
    }
}

package org.java.learning.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    private void recursion(int ind, int n, List<String> res, String str) {
        if (ind == 0 && n == 0) {
            res.add(str);
            return;
        }
        if (n > 0)
            recursion(ind+1, n - 1, res, str+"(");
        if (ind > 0)
            recursion(ind-1, n, res, str+")");
    }
    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();
        String str = "";
        recursion(0, n, res, str);
        return res;
    }
}

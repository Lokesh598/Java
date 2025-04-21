package org.java.learning.dsa.recursion;

public class PowerofXN {

    public double solve(double x, int n) {
        if(n==0) return 1;
        if(n==1) return x;

        else {
            int mid = n/2;

            double y = solve(x, mid);

            if(n%2 == 0)
                return y*y;
            else
                return x*y*y;

        }
    }
    public double myPow(double x, int n) {
        if(n<0)
            return 1/solve(x,n);
        else
            return solve(x,n);
    }
}




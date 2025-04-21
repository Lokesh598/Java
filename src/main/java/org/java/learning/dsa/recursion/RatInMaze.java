package org.java.learning.dsa.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
 *
 * Consider a rat placed at position (0, 0) in an n x n square matrix mat.
 * The rat's goal is to reach the destination at position (n-1, n-1).
 * The rat can move in four possible directions: 'U'(up), 'D'(down), 'L' (left), 'R' (right).
 *
 * The matrix contains only two possible values:
 *
 *     0: A blocked cell through which the rat cannot travel.
 *     1: A free cell that the rat can pass through.
 *
 * Note: In a path, no cell can be visited more than one time.
 * If the source cell is 0, the rat cannot move to any other cell. In case of no path, return an empty list.+
 */

public class RatInMaze {

    public void findAllPath(int r, int c, int n, int[][] m, String ans, List<String> ds) {

        if(r<0 || r >=n || c<0 || c>=n || m[r][c] == 0) {
            return;
        }

        if(r == n-1 && c == n-1) {
            ds.add(ans);
            return;
        }

        m[r][c] = 0;
        findAllPath(r+1, c, n, m, ans +"D", ds);
        findAllPath(r, c-1, n, m, ans +"L", ds);
        findAllPath(r, c+1, n, m, ans +"R", ds);
        findAllPath(r-1, c, n, m, ans +"U", ds);
        m[r][c] = 1;

    }
    public List<String> findPath(int[][] m) {
        // Your code goes here
        String ans = "";
        List<String> ds = new ArrayList<>();
        int n = m.length;
        findAllPath(0, 0, n, m, ans, ds);
        Collections.sort(ds);
        return ds;
    }

    public static void main(String[] args) {
        RatInMaze ratInMaze = new RatInMaze();

        System.out.println(ratInMaze.findPath(new int[][]{{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}}));
    }


}

package interviewbit.Math.Combinatorics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * A robot is located at the top-left corner of an A x B grid (marked ‘Start’ in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked ‘Finish’ in the diagram below).
 * <p>
 * How many possible unique paths are there?
 * <p>
 * Note: A and B will be such that the resulting answer fits in a 32 bit signed integer.
 * <p>
 * Example :
 * <p>
 * Input : A = 2, B = 2
 * Output : 2
 * <p>
 * 2 possible routes : (0, 0) -> (0, 1) -> (1, 1)
 * OR  : (0, 0) -> (1, 0) -> (1, 1)
 */
public class UniqueGrid {

    int count = 0;

    /***
     * Using BackTracking
     * @param A
     * @param B
     * @return
     */
    public int uniquePaths(int A, int B) {
        int currX = 0, currY = 0;
        List<String> set = new ArrayList<>();
        dfs(currX, currY, set, A, B);
        return count;
    }

    public void dfs(int currX, int currY, List<String> set, int A, int B) {
        if (currX == A - 1 && currY == B - 1) {
            count++;
            //System.out.println(set);
            return;
        }
        set.add(currX + "," + currY);
        if (currX >= 0 && currX < A && currY + 1 < B) {
            dfs(currX, currY + 1, set, A, B);
        }
        if (currX + 1 < A && currY >= 0 && currY < B) {
            dfs(currX + 1, currY, set, A, B);
        }
        set.remove(set.size() - 1);
    }


    /**
     * Using Recursion
     *
     * @param A
     * @param B
     * @return
     */
    public int uniquePaths_rec(int A, int B) {
        if (A == 1 || B == 1) {
            return 1;
        } else return uniquePaths_rec(A - 1, B) + uniquePaths_rec(A, B - 1);
    }


    public static void main(String[] args) {
        int A = 3, B = 3;
        UniqueGrid ug = new UniqueGrid();
        System.out.println(ug.uniquePaths(A, B));
    }
}

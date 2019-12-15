package interviewbit.Arrays.SpaceRecycle;

import java.util.ArrayList;

/**
 * Given a matrix, A of size M x N of 0s and 1s. If an element is 0, set its entire row and column to 0.
 *
 * Note: This will be evaluated on the extra memory used. Try to minimize the space and time complexity.
 *
 *
 *
 * Input Format:
 *
 * The first and the only argument of input contains a 2-d integer matrix, A, of size M x N.
 * Output Format:
 *
 * Return a 2-d matrix that satisfies the given conditions.
 *
 * Input 1:
 *     [   [1, 0, 1],
 *         [1, 1, 1],
 *         [1, 1, 1]   ]
 *
 * Output 1:
 *     [   [0, 0, 0],
 *         [1, 0, 1],
 *         [1, 0, 1]   ]
 */
public class SetMatrixZeroes {

    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        int size = a.size();
        int length = a.get(0).size();
        boolean[] rows = new boolean[size];
        boolean[] cols = new boolean[length];

        /**
         * populate rows and cols array
         */
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < length; j++) {
                if (a.get(i).get(j) == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        /**
         * process rows and cols array
         */
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < length; j++) {
                if (rows[i] || cols[j]) {
                    a.get(i).set(j, 0);
                }
            }
        }
    }
}

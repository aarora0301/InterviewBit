package interviewbit.BinarySearch.SimpleBinarySearch;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Given a matrix of integers A of size N x M and an integer B.
 * <p>
 * Write an efficient algorithm that searches for integar B in matrix A.
 * <p>
 * This matrix A has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than or equal to the last integer of the previous row.
 * Return 1 if B is present in A, else return 0.
 * <p>
 * <p>
 * Input 1:
 * A =
 * [ [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]  ]
 * B = 3
 * Output 1:
 * 1
 * <p>
 * Input 2:
 * A = [   [5, 17, 100, 111]
 * [119, 120,  127,   131]    ]
 * B = 3
 * Output 2:
 * 0
 */
public class MatrixSearch {

    public int searchMatrix(int[][] A, int B) {

        if (A == null || A.length == 0) {
            return 0;
        }
        int low = 0;
        int row = A.length;
        int col = A[0].length;
        int high = row * col - 1;
        int mid;
        int midValue;
        while (low <= high) {
            mid = (high + low) / 2;
            midValue = A[mid / col][mid % col];
            if (midValue == B) {
                return 1;
            } else if (midValue < B) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return 0;
    }
}

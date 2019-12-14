package interviewbit.Arrays.Arrangement;

import java.util.List;

/**
 * Find the contiguous subarray within an array, A of length N which has the largest sum.
 *
 * Input Format:
 *
 * The first and the only argument contains an integer array, A.
 * Output Format:
 *
 * Return an integer representing the maximum possible sum of the contiguous subarray.
 */
public class MaxSum {

    public int maxSubArray(final List<Integer> A) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int num : A) {
            currSum = Math.max(currSum + num, num);
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }
}

package interviewbit.Arrays.Simulation;

import java.util.Arrays;

/**
 * Given an array of integers, A of length N, find out the maximum sum sub-array of non negative numbers from A.
 * <p>
 * The sub-array should be contiguous i.e., a sub-array created by choosing the second and fourth element and skipping the third element is invalid.
 * <p>
 * Maximum sub-array is defined in terms of the sum of the elements in the sub-array.
 * <p>
 * Find and return the required subarray.
 * <p>
 * <p>
 * NOTE:
 * <p>
 * 1. If there is a tie, then compare with segment's length and return segment which has maximum length.
 * 2. If there is still a tie, then return the segment with minimum starting index.
 * <p>
 * Input 1:
 * A = [1, 2, 5, -7, 2, 3]
 * <p>
 * Output 1:
 * [1, 2, 5]
 * <p>
 * Explanation 1:
 * The two sub-arrays are [1, 2, 5] [2, 3].
 * The answer is [1, 2, 5] as its sum is larger than [2, 3].
 * <p>
 * Input 2:
 * A = [10, -1, 2, 3, -4, 100]
 * <p>
 * Output 2:
 * [100]
 */
public class MaxNonNegative {

    public int[] maxset(int[] A) {

        int start = 0, end = 0;
        int s = 0, e = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0) {
                s = i + 1;
                sum = 0;
                continue;

            }
            sum += A[i];
            e = i;
            if (max < sum) {
                max = sum;
                start = s;
                end = e;
            } else if (max == sum && end - start < e - s) {
                start = s;
                end = e;
            }


        }

        if (max != Integer.MIN_VALUE) {
            int j = 0;
            int[] result = new int[end - start + 1];
            for (int i = start; i <= end; i++) {
                result[j++] = A[i];
            }
            return result;
        }
        return new int[0];

    }

    public static void main(String[] args) {
        int[] A = {1, 2, 5, -7, 2, 3};
        Arrays.stream(new MaxNonNegative().maxset(A)).forEach(System.out::print);
    }
}


package interviewbit.Arrays.Bucketing;

/**
 * You are given an array (zero indexed) of N non-negative integers, A0, A1 ,…, AN-1.
 * Find the minimum sub array Al, Al+1 ,…, Ar so if we sort(in ascending order) that sub array, then the whole array should get sorted.
 * If A is already sorted, output -1.
 * <p>
 * Input 1:
 * <p>
 * A = [1, 3, 2, 4, 5]
 * <p>
 * Return: [1, 2]
 * <p>
 * Input 2:
 * <p>
 * A = [1, 2, 3, 4, 5]
 * <p>
 * Return: [-1]
 */
public class MaxUnsortedArray {

    public int[] subUnsort(int[] A) {
        int len = A.length;
        int left = 0;
        int right = len - 1;
        while (left < len - 1 && A[left] <= A[left + 1]) left++;

        if (left == len - 1) {
            return new int[]{-1};
        }

        while (right > 0 && A[right] >= A[right - 1]) right--;


        int min = A[left + 1];
        int max = A[right - 1];
        for (int i = left; i <= right; i++) {
            min = Math.min(min, A[i]);
            max = Math.max(max, A[i]);
        }

        /**
         * Expand left window
         */
        while (left >= 0 && min < A[left]) left--;
        /**
         * Expand right window
         */
        while (right < len && max > A[right]) right++;
        return new int[]{left + 1, right - 1};


    }
}

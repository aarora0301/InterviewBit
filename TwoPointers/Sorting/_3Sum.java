package interviewbit.TwoPointers.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/***
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers.
 *
 * Assume that there will only be one solution
 *
 * Example:
 * given array S = {-1 2 1 -4},
 * and target = 1.
 *
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)
 */
public class _3Sum {

    public int threeSumClosest(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        int min = Integer.MAX_VALUE;
        int result = 0;
        int currentDiff = Integer.MAX_VALUE;
        for (int i = 0; i < A.size(); i++) {
            int a = A.get(i);
            int left = i + 1;
            int right = A.size() - 1;
            while (left < right) {
                int sum = a + A.get(left) + A.get(right);
                min = Math.abs(sum - B);

                if (min == 0) {
                    return sum;
                }
                if (min < currentDiff) {
                    currentDiff = min;
                    result = sum;
                }
                if (sum > B) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[] a = {2, 1, -9, -7, -8, 2, -8, 2, 3, -8};
        ArrayList<Integer> list = new ArrayList(Arrays.asList(a));
        int b = -1;
        _3Sum sum = new _3Sum();
        System.out.println(sum.threeSumClosest(list, b));
    }
}

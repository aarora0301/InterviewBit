package interviewbit.TwoPointers.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/***
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 *  Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets. For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 */
public class _3SumZero {

    /**
     * Using sorting
     *
     * @param A
     * @return
     */
    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (A == null || A.size() == 0) {
            return result;
        }
        Collections.sort(A);
        for (int i = 0; i < A.size(); i++) {
            /**
             *  case: {-1, -1, 0 , 1, 2}
             */
            if (i > 0 && A.get(i - 1).equals(A.get(i))) continue;
            int left = i + 1;
            int right = A.size() - 1;

            while (left < right) {
                int a = A.get(i);
                int sum = a + A.get(left) + A.get(right);
                if (sum == 0) {
                    result.add(new ArrayList(Arrays.asList(a, A.get(left), A.get(right))));

                    /**
                     * Case: 5,-4,-4,-1
                     */
                    while (left < right && A.get(left) == A.get(left + 1)) {
                        left++;
                    }
                    while (left < right && A.get(right) == A.get(right - 1)) {
                        right--;
                    }
                    left++;
                    right--;

                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }

            }
        }
        return result;
    }

    /**
     * Using hashing
     *
     * @param A
     * @return
     */
    public ArrayList<ArrayList<Integer>> _threeSum(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (A == null || A.size() == 0) {
            return result;
        }

        for (int i = 0; i < A.size() - 1; i++) {
            HashSet<Integer> set = new HashSet<>();
            int curr_sum = -A.get(i);
            for (int j = i + 1; j < A.size(); j++) {
                if (set.contains(curr_sum - A.get(j))) {
                    result.add(new ArrayList(Arrays.asList(A.get(i), curr_sum - A.get(j), A.get(j))));
                } else {
                    set.add(A.get(j));
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        Integer[] a = {-31013930, -31013930, 9784175, 21229755};
        ArrayList<Integer> list = new ArrayList(Arrays.asList(a));
        _3SumZero sum = new _3SumZero();
        // System.out.println(sum.threeSum(list));
        System.out.println(sum._threeSum(list));
    }
}

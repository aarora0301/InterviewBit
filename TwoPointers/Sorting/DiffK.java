package interviewbit.TwoPointers.Sorting;

import java.util.ArrayList;
import java.util.Arrays;

/***
 * Given an array ‘A’ of sorted integers and another non negative integer k, find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.
 *
 *  Example: Input :
 *     A : [1 3 5]
 *     k : 4
 *
 * Output : YES as 5 - 1 = 4
 */
public class DiffK {

    public int diffPossible(ArrayList<Integer> A, int B) {
        int len = A.size();
        int left = 0;
        int diff;
        int right = 1;
        while (left < len && right < len) {
            diff = A.get(right) - A.get(left);
            if (diff == B && left != right) {
                return 1;
            }
            if (diff < B) {
                right++;
            } else {
                left++;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList(Arrays.asList(1, 2, 2, 3, 4));
        DiffK diff = new DiffK();
        System.out.println(diff.diffPossible(list, 0));
    }
}

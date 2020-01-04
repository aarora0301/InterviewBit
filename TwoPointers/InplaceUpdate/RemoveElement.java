package interviewbit.TwoPointers.InplaceUpdate;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an array and a value, remove all the instances of that value in the array.
 * Also return the number of elements left in the array after the operation.
 * It does not matter what is left beyond the expected length.
 * <p>
 * Example:
 * If array A is [4, 1, 1, 2, 1, 3]
 * and value elem is 1,
 * then new length is 3, and A is now [4, 2, 3]
 * Try to do it in less than linear additional space complexity.
 */
public class RemoveElement {

    /**
     * TApproach 1: ime Limit Exceeded
     *
     * @param a
     * @param b
     * @return
     */
    public int removeElement(ArrayList<Integer> a, int b) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).equals(b)) {
                a.remove(i);
                i--;
            }
        }
        return a.size();
    }

    /**
     * Approach 2: Time Limit Exceeded
     *
     * @param a
     * @param b
     * @return
     */
    public int removeElement_(ArrayList<Integer> a, int b) {
        int i;
        for (i = 0; i < a.size(); i++) {
            int left = i;
            if (a.get(left).equals(b)) {
                while (left < a.size() && a.get(left).equals(b)) {
                    left++;
                }
                if (left >= a.size()) {
                    return i;
                }
                int temp = a.get(i);
                a.set(i, a.get(left));
                a.set(left, temp);
            }

        }
        return i;

    }

    /***
     * Optimised using two pointers
     * @param a
     * @param b
     */
    private int removeElements_optimised(ArrayList<Integer> a, int b) {
        int n = a.size();
        int i, j;
        for (i = 0, j = 0; j < n; j++) {
            if (a.get(j) != b) {
                a.set(i, a.get(j));
                i++;
            }
        }
        return i;

    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(4, 1, 1, 1, 1, 1, 1, 2, 3));
        int b = 1;
        RemoveElement re = new RemoveElement();
        System.out.println(re.removeElement_(list, b));
        System.out.println(re.removeElements_optimised(list, b));
    }

}



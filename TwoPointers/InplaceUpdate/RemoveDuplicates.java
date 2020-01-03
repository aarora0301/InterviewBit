package interviewbit.TwoPointers.InplaceUpdate;

import java.util.ArrayList;
import java.util.Arrays;

/***
 * Remove duplicates from Sorted Array
 * Given a sorted array, remove the duplicates in place such that each element appears only once and return the new length.
 *
 * Note that even though we want you to return the new length, make sure to change the original array as well in place
 *
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 */
public class RemoveDuplicates {

    /**
     * Time Limit Exceeded :
     *
     * @param a
     * @return
     */
    public int removeDuplicates(ArrayList<Integer> a) {
        for (int i = 1; i < a.size(); i++) {
            if (a.get(i).equals(a.get(i - 1))) {
                a.remove(i);
                i--;
            }
        }
        return a.size();
    }

    /**
     * Optimised version : using two pointers
     *
     * @param a
     * @return
     */
    public int removeDuplicates_(ArrayList<Integer> a) {
        int i = 0;
        int x = a.get(i);
        for (int j = 1; j < a.size(); j++) {
            if (x != a.get(j)) {
                i++;
                a.set(i, a.get(j));
                x = a.get(j);
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3));
        RemoveDuplicates rd = new RemoveDuplicates();
        System.out.println(rd.removeDuplicates(list));
        System.out.println(rd.removeDuplicates_(list));
    }
}

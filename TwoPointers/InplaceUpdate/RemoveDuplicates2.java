package interviewbit.TwoPointers.InplaceUpdate;

import java.util.ArrayList;
import java.util.Arrays;

/***
 * Remove Duplicates from Sorted Array
 *
 * Given a sorted array, remove the duplicates in place such that each element can appear atmost twice and return the new length.
 *
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 *
 * Note that even though we want you to return the new length, make sure to change the original array as well in place
 *
 * For example,
 * Given input array A = [1,1,1,2],
 *
 * Your function should return length = 3, and A is now [1,1,2].
 */
public class RemoveDuplicates2 {

    public int removeDuplicates(ArrayList<Integer> a) {
        int count = 1;
        for (int i = a.size() - 1; i >= 0; i--) {

            if (i != 0 && a.get(i).equals(a.get(i - 1))) {
                count++;
            } else {
                if (count > 2) {
                    while (count > 2) {
                        a.remove(i);
                        count--;
                    }

                }
                count = 1;
            }
        }
        System.out.println(a);
        return a.size();
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList(Arrays.asList(1000, 1000, 1000, 1000, 1001, 1002, 1003, 1003, 1004, 1010));
        RemoveDuplicates2 rd = new RemoveDuplicates2();
        System.out.println(rd.removeDuplicates(list));
    }
}

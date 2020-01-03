package interviewbit.TwoPointers.MultipleArrays;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * <p>
 * Note: You have to modify the array A to contain the merge of A and B. Do not output anything in your code.
 * TIP: C users, please malloc the result into a new array and return the result.
 * If the number of elements initialized in A and B are m and n respectively, the resulting size of array A after your code is executed should be m + n
 * <p>
 * Example :
 * <p>
 * Input :
 * A : [1 5 8]
 * B : [6 9]
 * <p>
 * Modified A : [1 5 6 8 9]
 */
public class MergeTwoLists {

    /**
     * merge to lists
     * @param a
     * @param b
     */
    public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > b.get(0)) {
                int temp = b.get(0);
                b.set(0, a.get(i));
                a.set(i, temp);
            }

            int first = b.get(0);
            int k;
            for (k = 1; k < b.size() && b.get(k) < first; k++) {
                b.set(k - 1, b.get(k));
            }
            b.set(k - 1, first);
        }
        a.addAll(b);

    }

    /**
     *
     * @param a
     * @param b
     */
    public void merge_fast(ArrayList<Integer> a, ArrayList<Integer> b){

    }

    public static void main(String[] args) {
        Integer[] a = {1, 5, 8};
        Integer[] b = {6, 9};
        ArrayList<Integer> list1 = new ArrayList(Arrays.asList(a));
        ArrayList<Integer> list2 = new ArrayList(Arrays.asList(b));
        MergeTwoLists ml = new MergeTwoLists();
        ml.merge(list1, list2);
        System.out.println(list1);

    }
}

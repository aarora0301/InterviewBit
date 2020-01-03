package interviewbit.TwoPointers.MultipleArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * Find the intersection of two sorted arrays.
 * OR in other words,
 * Given 2 sorted arrays, find all the elements which occur in both the arrays.
 *
 * Example :
 *
 * Input :
 *     A : [1 2 3 3 4 5 6]
 *     B : [3 3 5]
 *
 * Output : [3 3 5]
 *
 * Input :
 *     A : [1 2 3 3 4 5 6]
 *     B : [3 5]
 *
 * Output : [3 5]
 */
public class Intersection {

    public ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < A.size() && j < B.size()) {
            if (A.get(i).equals(B.get(j))) {
                list.add(A.get(i));
                i++;
                j++;
            } else if (A.get(i) < B.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 3, 4, 5, 6};
        Integer[] b = {3, 3, 5};
        Intersection in = new Intersection();
        System.out.println(in.intersect(Arrays.asList(a), Arrays.asList(b)));
    }
}

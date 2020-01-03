package interviewbit.TwoPointers;

import interviewbit.TwoPointers.MultipleArrays.Intersection;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given three sorted arrays A, B and Cof not necessarily same sizes.
 * <p>
 * Calculate the minimum absolute difference between the maximum and minimum number from the triplet a, b, c such that a, b, c belongs arrays A, B, C respectively.
 * i.e. minimize | max(a,b,c) - min(a,b,c) |.
 * <p>
 * Example :
 * <p>
 * Input:
 * <p>
 * A : [ 1, 4, 5, 8, 10 ]
 * B : [ 6, 9, 15 ]
 * C : [ 2, 3, 6, 6 ]
 */
public class MinimizeAbsoluteDifference {

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int i = 0, j = 0, k = 0;
        int len1 = A.size();
        int len2 = B.size();
        int len3 = C.size();
        int diff = Integer.MAX_VALUE;
        while (i < len1 && j < len2 && k < len3) {
            int a = A.get(i);
            int b = B.get(j);
            int c = C.get(k);
            int min = Math.min(a, Math.min(b, c));
            int max = Math.max(a, Math.max(b, c));
            diff = Math.min(diff, max - min);
            if (diff == 0) {
                break;
            }
            if (min == a) {
                i++;
            } else if (min == b) {
                j++;
            } else {
                k++;
            }
        }
        return diff;
    }

    public static void main(String[] args) {
        Integer[] a = {1, 4, 5, 8, 10};
        ArrayList<Integer> al = new ArrayList(Arrays.asList(a));
        Integer[] b = {6, 9, 15};
        ArrayList<Integer> bl = new ArrayList(Arrays.asList(b));
        Integer[] c = {2, 3, 6, 6};
        ArrayList<Integer> cl = new ArrayList(Arrays.asList(c));
        MinimizeAbsoluteDifference ab = new MinimizeAbsoluteDifference();
        System.out.println(ab.solve(al, bl, cl));

    }
}

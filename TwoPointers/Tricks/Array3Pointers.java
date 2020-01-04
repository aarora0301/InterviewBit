package interviewbit.TwoPointers.Tricks;

import java.util.List;

/***
 * You are given 3 arrays A, B and C. All 3 of the arrays are sorted.
 *
 * Find i, j, k such that :
 * max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is minimized.
 * Return the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i]))
 *
 * **abs(x) is absolute value of x and is implemented in the following manner : **
 *
 *       if (x < 0) return -x;
 *       else return x;
 * Example :
 *
 * Input :
 *         A : [1, 4, 10]
 *         B : [2, 15, 20]
 *         C : [10, 12]
 *
 * Output : 5
 *          With 10 from A, 15 from B and 10 from C.
 */
public class Array3Pointers {
    public int minimize(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
        int a = 0, b = 0, c = 0;
        int diff = Integer.MAX_VALUE;
        while (a < A.size() && b < B.size() && c < C.size()) {
            int min = Math.min(A.get(a), Math.min(B.get(b), C.get(c)));
            int max = Math.max(A.get(a), Math.max(B.get(b), C.get(c)));
            diff = Math.min(diff, max - min);
            if (diff == 0) {
                break;
            }
            if (min == A.get(a)) {
                a++;
            } else if (min == B.get(b)) {
                b++;
            } else {
                c++;
            }
        }
        return diff;
    }
}

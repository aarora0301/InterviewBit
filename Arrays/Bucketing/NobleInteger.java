package interviewbit.Arrays.Bucketing;


import java.util.Arrays;

/***
 * Given an integer array, find if an integer p exists in the array such that the number of integers greater than p in the array equals to p
 * If such an integer is found return 1 else return -1.
 */
public class NobleInteger {

    public int solve(int[] A) {
        int len = A.length;
        Arrays.sort(A);
        for (int i = 0; i < len; i++) {

            while (i <= len - 2 && A[i] == A[i + 1]) {
                i++;
            }
            if (A[i] == len - 1 - i) {
                return 1;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        int[] arr = {-2, 8, 8, 6, -2, 3, -2, -7, 3, 3, -2, 0, 4, -3, -4, -2, -1, -10, -4, -2, 7, -1, 0, -7, 3, -7, 7, 3, 2, -4, -5, 2, 6, 5, -2, 7, -1, 6, -10, 4, -9, -10, -6, -2, -3, 0, -2, 6, -8, 4, 7, 9, -7, 9, -8, -2, -7, -10, -9, -3, 8, 9, 1, 5, 4, 9, 2, 5, -3, -6, -1, -1, -6};
        System.out.println(new NobleInteger().solve(arr));
    }
}

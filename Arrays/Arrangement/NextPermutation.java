package interviewbit.Arrays.Arrangement;

/**
 * Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers for a given array A of size N.
 * <p>
 * If such arrangement is not possible, it must be rearranged as the lowest possible order i.e., sorted in an ascending order.
 * <p>
 * Input 1:
 * A = [1, 2, 3]
 * <p>
 * Output 1:
 * [1, 3, 2]
 * <p>
 * Input 2:
 * A = [3, 2, 1]
 * <p>
 * Output 2:
 * [1, 2, 3]
 */
public class NextPermutation {


    public int[] nextPermutation(int[] A) {

        int i = A.length - 2;
        /***
         * Walk backwards. Keep walking until we reach the point right
         * before the decreasing sequence begins. When this while loop
         * ends that is where i will stand
         */
        while (i >= 0 && A[i] >= A[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = A.length - 1;
            /**
             * find the element greater than number where non decreasing sequence starts
             */
            while (j >= 0 && A[i] >= A[j]) {
                j--;
            }
            /**
             * swap these numbers
             */
            swap(A, i, j);
        }
        /**
         * 1. if i< 0 that means array is in reverse order i.e 3 2 1 OR
         * 2. or sort the numbers from i+1 till end
         */
        reverse(A, i + 1);
        return A;
    }


    private void reverse(int[] a, int i) {
        int left = i;
        int right = a.length - 1;
        while (left < right) {
            swap(a, left, right);
            left++;
            right--;
        }

    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}


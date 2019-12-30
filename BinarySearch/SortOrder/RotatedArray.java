package interviewbit.BinarySearch.SortOrder;


/**
 * Given an array of integers A of size N and an integer B.
 * <p>
 * array A is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).
 * <p>
 * You are given a target value B to search. If found in the array, return its index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * NOTE:- Array A was sorted in non-decreasing order before rotation.
 */
public class RotatedArray {

    public int search(final int[] A, int B) {
        int start = 0;
        int end = A.length;
        int mid;
        while (start <= end) {
            mid = start + end / 2;
            if (A[mid] == B) {
                return mid;
            } else if (A[mid] >= A[start]) {

                if (B >= A[start] && B <= A[mid]) {
                    end = mid - 1;
                } else start = mid + 1;

            } else {
                if (B >= A[mid] && B <= A[end]) {
                    start = mid + 1;
                } else end = mid - 1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {

    }
}

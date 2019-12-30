package interviewbit.BinarySearch.SimpleBinarySearch;

import java.util.Arrays;

/***
 * Given a sorted array of integers A(0 based index) of size N, find the starting and ending position of a given integer B in array A.
 *
 * Your algorithm’s runtime complexity must be in the order of O(log n).
 *
 * Return an array of size 2, such that first element = starting position of B in A and second element = ending position of B in A, if B is not found in A return [-1, -1].
 */
public class SearchForRange {

    public int[] searchRange(final int[] A, int B) {
        if (A == null || A.length == 0) {
            return new int[]{-1, -1};
        }
        int low = 0;
        int high = A.length-1;
        int mid;
        int start, end;
        while (low <= high) {
            mid = (low + high) / 2;
            if (A[mid] == B) {
                start = mid;
                end = mid;
                while (start > 0 && A[start] == A[start - 1]) {
                    start--;
                }
                while (end + 1 <= high && A[end] == A[end + 1]) {
                    end++;
                }
                return new int[]{start, end};
            } else if (A[mid] > B) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] arr = {1};
        int b = 1;
        SearchForRange sr = new SearchForRange();
        Arrays.stream(sr.searchRange(arr, b)).forEach(System.out::print);
    }
}

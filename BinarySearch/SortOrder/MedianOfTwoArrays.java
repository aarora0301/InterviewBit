package interviewbit.BinarySearch.SortOrder;

import interviewbit.BinarySearch.SearchAnswer.MatrixMedian;

import java.util.List;

/***
 * There are two sorted arrays A and B of size m and n respectively.
 *
 * Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).
 *
 * The overall run time complexity should be O(log (m+n)).
 *
 * Sample Input
 *
 * A : [1 4 5]
 * B : [2 3]
 *
 * Sample Output
 *
 * 3
 */
public class MedianOfTwoArrays {


    public double findMedianSortedArrays(final List<Integer> A, final List<Integer> B) {
        if (A.size() > B.size()) {
            return findMedianSortedArrays(B, A);
        }
        int x = A.size();
        int y = B.size();
        double ans = 0;
        int low = 0;
        int high = x;
        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : A.get(partitionX - 1);
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : A.get(partitionX);

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : B.get(partitionY - 1);
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : B.get(partitionY);

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((x + y) % 2 == 0) {
                    ans = ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                    break;
                } else {
                    ans = (double) Math.max(maxLeftX, maxLeftY);
                    break;
                }
            } else if (maxLeftX > minRightY) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }
        return ans;
    }
}

package interviewbit.BinarySearch.SimpleBinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class SortedInsertPosition {

    public int searchInsert(ArrayList<Integer> A, int b) {
        int low = 0;
        int high = A.size() - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (A.get(mid) == b) {
                return mid;
            } else if (A.get(mid) > b) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (low > high) {
            return low;
        } else return low + 1;

    }

    public static void main(String[] args) {
        SortedInsertPosition sip = new SortedInsertPosition();
        Integer[] a = {1, 3, 5, 6};
        ArrayList<Integer> list = new ArrayList(Arrays.asList(a));
        int b = 0;
        System.out.println(sip.searchInsert(list, b));
    }
}

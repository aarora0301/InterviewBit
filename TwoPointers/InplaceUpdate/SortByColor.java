package interviewbit.TwoPointers.InplaceUpdate;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an array with n objects colored red, white or blue,
 * sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * <p>
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * <p>
 * Note: Using library sort function is not allowed.
 * <p>
 * Example :
 * <p>
 * Input : [0 1 2 0 1 2]
 * Modify array so that it becomes : [0 0 1 1 2 2]
 * <p>
 * Hint: Dutch National Flag algorithm
 */
public class SortByColor {

    public void sortColors(ArrayList<Integer> a) {
        /**
         * Take '1' as pivot element such that all elements smaller than 1 will be on left and elements greater than 1
         * will be on its right
         */
        int pivot = 1;

        /**
         * Do a forward pass such that all elements smaller than pivot are placed at its left
         */
        for (int i = 0, index = 0; i < a.size(); i++) {
            if (a.get(i) < pivot) {
                int temp = a.get(i);
                a.set(i, a.get(index));
                a.set(index, temp);
                index++;
            }
        }

        /**
         * Do a backward pass such that all elements greater than pivot are placed at its right
         */
        for (int i = a.size() - 1, index = a.size() - 1; i >= 0; i--) {
            if (a.get(i) > pivot) {
                int temp = a.get(i);
                a.set(i, a.get(index));
                a.set(index, temp);
                index--;
                /**
                 *  in forward pass all elements to its left are smaller so we will
                 * stop our backward iteration whenever we encounter element smaller than pivot
                 */
            } else if (a.get(i) < pivot) {
                break;
            }
        }
        System.out.println(a);
    }

    public static void main(String[] args) {
        SortByColor sc = new SortByColor();
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(0, 1, 0, 0, 2, 2));
        sc.sortColors(list);
    }
}

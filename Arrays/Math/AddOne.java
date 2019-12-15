package interviewbit.Arrays.Math;

import java.util.ArrayList;
import java.util.Arrays;

/***
 * Given a non-negative number represented as an array of digits,
 *
 * add 1 to the number ( increment the number represented by the digits ).
 *
 * The digits are stored such that the most significant digit is at the head of the list.
 *
 * Example:
 *
 * If the vector has [1, 2, 3]
 *
 * the returned vector should be [1, 2, 4]
 *
 * as 123 + 1 = 124.
 */
public class AddOne {
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int carry = 1;
        for (int i = A.size() - 1; i >= 0; i--) {
            int num = A.get(i);
            if (carry + num <= 9) {
                if (carry == 1) {
                    A.remove(i);
                    A.add(i, carry + num);
                    carry = 0;
                }
            } else {
                A.remove(i);
                A.add(i, 0);
                carry = 1;
            }
        }
        if (carry == 1) {
            A.add(0, 1);
        }

        int i = 0;
        while (i < A.size()) {
            if (A.get(i) == 0) {
                A.remove(i);
            } else {
                break;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        AddOne ao = new AddOne();
        System.out.println(ao.plusOne(new ArrayList<>(Arrays.asList(9, 9, 9))));
    }
}

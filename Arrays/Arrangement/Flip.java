package interviewbit.Arrays.Arrangement;

import java.util.ArrayList;
import java.util.Arrays;

public class Flip {

    public ArrayList<Integer> flip(String A) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int start = 0, s = 0, e = 0;
        int key;
        int count = 0;
        for (int i = 0; i < A.length(); i++) {

            if (A.charAt(i) == '1') {
                count++;
                key = -1;
            } else {
                key = 1;
            }

            currSum += key;
            if (currSum < key) {
                currSum = key;
                start = i;
            }

            if (currSum > maxSum) {
                maxSum = currSum;
                s = start;
                e = i;
            }
        }
        return count == A.length() ? new ArrayList() : new ArrayList<>(Arrays.asList(s + 1, e + 1));

    }

    public static void main(String[] args) {
        Flip flip = new Flip();
        String A = "1101010001";
        System.out.println(flip.flip(A));
    }
}

package interviewbit.Arrays.Bucketing;

import java.util.Arrays;

public class LargestNumber {
    public String largestNumber(final int[] A) {
        int len = A.length;
        String[] arr = new String[len];
        for (int i = 0; i < len; i++) {
            arr[i] = String.valueOf(A[i]);
        }
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        StringBuilder result = new StringBuilder();

        for (String num : arr) {
            result.append(num);
        }

        /**
         * Removing leading zeroes
         */
        while (result.charAt(0) == '0' && result.length() > 1) {
            result.deleteCharAt(0);
        }
        return result.toString();
    }
}


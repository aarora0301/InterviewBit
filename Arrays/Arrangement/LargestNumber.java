package interviewbit.Arrays.Arrangement;

import java.util.Arrays;
import java.util.List;

/***
 * Given a list of non negative integers, arrange them such that they form the largest number.
 *
 * For example:
 *
 * Given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 *
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class LargestNumber {
    public String largestNumber(final List<Integer> a) {
        String[] arr;
        arr = new String[a.size()];
        for (int i = 0; i < a.size(); i++) {
            arr[i] = String.valueOf(a.get(i));
        }
        Arrays.sort(arr, (a1, b) -> (b + a1).compareTo(a1 + b));
        StringBuilder result = new StringBuilder();
        Arrays.stream(arr).forEach(result::append);
        int count = 0;
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) != '0')
                break;
            else count++;
        }

        return count == result.length() ? "0" : result.toString();

    }
}

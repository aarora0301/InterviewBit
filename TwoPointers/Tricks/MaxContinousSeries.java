package interviewbit.TwoPointers.Tricks;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxContinousSeries {

    public ArrayList<Integer> maxone(ArrayList<Integer> A, int B) {
        int start = 0, end = 0, count = 0;
        int len = A.size();
        int s = 0, e = 0;
        boolean bool = true;
        int length = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            /**
             * It should run only first time when 'start' has to be decided
             */
            if (B == 0 && bool) {
                int p = i;
                while (A.get(p) != 1) {
                    p++;
                    i++;
                }
                start = p;
                bool = false;
            }

            /**
             * id 0 is encountered maintain a count
             */
            if (A.get(i).equals(0)) {
                count++;
                /**
                 * if count exceeds B, go to a position where we started ie. 'start' and return position next to zero
                 * kind of sliding window
                 */
                if (count > B) {
                    int left = start;
                    while (left < i && A.get(left) != 0) {
                        left++;
                    }
                    /**
                     * update start pointer and decrement count
                     */
                    start = left + 1;
                    count -= 1;
                    /**
                     * if count of 0 is less than B just update 'end' pointer
                     */
                } else if (count <= B) {
                    end = i;
                }

                /**
                 * if the number is one just update 'end pointer'
                 */
            } else if (A.get(i).equals(1)) {
                end = i;
            }


            if (end > start && length < end - start) {
                length = end - start;
                e = end;
                s = start;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        while (s < e) {
            result.add(s);
            s++;
        }
        result.add(e);
        return result;
    }

    public static void main(String[] args) {
        MaxContinousSeries mcs = new MaxContinousSeries();
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 1, 0));
        System.out.println(mcs.maxone(list, 2));
    }
}

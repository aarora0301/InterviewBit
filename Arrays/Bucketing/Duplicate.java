package interviewbit.Arrays.Bucketing;

/**
 * Given a read only array of n + 1 integers between 1 and n, find one number that repeats in linear time using less than O(n) space and traversing the stream sequentially O(1) times.
 * <p>
 * Input: [3 4 1 4 1]
 * Output: 1
 * <p>
 * If there are multiple possible answers ( like in the sample case above ), output any one.
 * <p>
 * If there is no duplicate, output -1
 */
public class Duplicate {
    /**
     * O(n) space
     *
     * @param A
     * @return
     */
    public int repeatedNumber(final int[] A) {
        int len = A.length;
        int[] arr = new int[len];
        for (int num : A) {
            if (arr[num] == 0) {
                arr[num] = -1;
            } else return num;
        }
        return -1;
    }

}


package interviewbit.Arrays.Bucketing;

import java.util.Arrays;

/**
 * Given an array of real numbers greater than zero in form of strings.
 * Find if there exists a triplet (a,b,c) such that 1 < a+b+c < 2 .
 * Return 1 for true or 0 for false.
 */
public class Triplets {
    public int solve(String[] A) {
        int len = A.length;
        double[] arr = new double[len];
        int index = 0;

        for (String num : A) {
            arr[index++] = Double.parseDouble(num);
        }
        Arrays.sort(arr);
        int left = 0;
        int right = 0;
        for (int i = 0; i < len; i++) {
            left = i + 1;
            right = len - 1;
            while (left < right) {
                double sum = arr[i] + arr[left] + arr[right];
                if (sum > 1 && sum < 2) {
                    return 1;
                } else if (sum < 1) {
                    left++;
                } else if (sum > 2) {
                    right--;
                }
            }
        }
        return 0;

    }

    public static void main(String[] args) {
        String[] A = {"0.9", "0.3", "0.9", "0.4"};
        System.out.println(new Triplets().solve(A));
    }
}

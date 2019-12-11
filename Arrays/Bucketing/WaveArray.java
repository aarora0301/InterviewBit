package interviewbit.Arrays.Bucketing;

import java.util.Arrays;

public class WaveArray {
    public int[] wave(int[] A) {
        if (A == null || A.length <= 1) {
            return A;
        }
        Arrays.sort(A);
        swap(A, 0, 1);
        for (int i = 2; i < A.length - 1; i += 2) {
            swap(A, i, i + 1);
        }
        return A;
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

}

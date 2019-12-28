package interviewbit.Arrays.Simulation;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order
 * Input : 3
 * Output:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 */
public class SpiralMatrix2 {
    public int[][] generateMatrix(int A) {
        int num = 1;
        int top = 0, left = 0;
        int bottom = A - 1, right = A - 1;
        int[][] result = new int[A][A];
        while (true) {
            if (left > right) {
                break;
            }
            for (int i = left; i <= right; i++) {
                result[top][i] = num;
                num++;
            }
            top++;

            if (top > bottom) {
                break;
            }
            for (int i = top; i <= bottom; i++) {
                result[i][right] = num;
                num++;
            }
            right--;

            if (left > right) {
                break;
            }
            for (int i = right; i >= left; i--) {
                result[bottom][i] = num;
                num++;
            }
            bottom--;
            if (top > bottom) {
                break;
            }
            for (int i = bottom; i >= top; i--) {
                result[i][left] = num;
                num++;
            }
            left++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] result = new SpiralMatrix2().generateMatrix(3);
        Stream.of(result).map(Arrays::toString).forEach(System.out::println);
    }

}

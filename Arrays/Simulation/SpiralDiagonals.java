package interviewbit.Arrays.Simulation;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Given N*N matrix, return array of its anti diagonal in spiral fashion
 * 1 2 3
 * 4 5 6
 * 7 8 9
 * <p>
 * [
 * [1],
 * [4,2],
 * [3,5,7],
 * [8,6],
 * [9]
 * ]
 */
public class SpiralDiagonals {

    public int[][] printAntiDiagonal(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] result = new int[(rows - 1) * 2 + 1][cols];
        int index = 0;
        boolean flag = false;
        for (int c = 0; c < cols; c++) {
            if (c % 2 == 0) {
                flag = !flag;
            }
            result[index++] = getAntiDiagonal(mat, 0, c, c + 1, flag);

        }

        flag = true;
        for (int r = 1; r < rows; r++) {
            if (r % 2 == 0) {
                flag = !flag;
            }
            result[index++] = getAntiDiagonal(mat, r, cols - 1, rows - r, flag);
        }

        return result;
    }

    private int[] getAntiDiagonal(int[][] mat, int i, int j, int size, boolean flag) {
        int[] result = new int[size];
        int index = 0;
        while (j >= 0 && i < mat.length) {
            result[index++] = mat[i][j];
            i++;
            j--;
        }
        if (flag) {
            swap(result, size);
        }
        return result;
    }

    private void swap(int[] result, int size) {
        int first = result[0];
        result[0] = result[size - 1];
        result[size - 1] = first;
    }


    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] result = (new SpiralDiagonals().printAntiDiagonal(mat));
        Stream.of(result).map(Arrays::toString).forEach(System.out::println);
    }
}

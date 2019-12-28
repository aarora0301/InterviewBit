package interviewbit.Arrays.Simulation;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Given N*N square matrix, return array of its anti diagonals
 * <p>
 * 1 2 3
 * 4 5 6
 * 7 8 9
 * [
 * [1],
 * [2,4],
 * [3,5,7],
 * [6,8],
 * [9]
 * ]
 */
public class Antidiagonals {

    public int[][] printAntiDiagonal(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] result = new int[(rows - 1) * 2 + 1][];
        int index = 0;
        for (int c = 0; c < cols; c++) {
            result[index++] = getAntiDiagonal(mat, 0, c, c + 1);
        }

        for (int r = 1; r < rows; r++) {
            result[index++] = getAntiDiagonal(mat, r, cols - 1, rows - r);
        }

        return result;
    }

    private int[] getAntiDiagonal(int[][] mat, int i, int j, int size) {
        int[] result = new int[size];
        int index = 0;
        while (j >= 0 && i < mat.length) {
            result[index++] = mat[i][j];
            i++;
            j--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 2}, {3,4}};
        int[][] result = (new Antidiagonals().printAntiDiagonal(mat));
        Stream.of(result).map(Arrays::toString).forEach(System.out::println);

    }
}

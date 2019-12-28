package interviewbit.Arrays.Simulation;


import java.util.Arrays;

/**
 * Print matrix in a spiral fashion
 */
public class SpiralOrderMatrix1 {

    public int[] spiralOrder(int[][] mat) {
        int top = 0, left = 0;
        int right = mat[0].length - 1;
        int bottom = mat.length - 1;
        int index = 0;
        int size = (right + 1) * (bottom + 1);
        int[] result = new int[size];

        while (true) {

            if (left > right) {
                break;
            }
            for (int i = left; i <= right; i++) {
                result[index++] = mat[top][i];
            }

            top++;

            if (top > bottom) {
                break;
            }
            for (int i = top; i <= bottom; i++) {
                result[index++] = mat[i][right];
            }
            right--;

            if (left > right) {
                break;
            }
            for (int i = right; i >= left; i--) {
                result[index++] = mat[bottom][i];
            }
            bottom--;

            if (top > bottom) {
                break;
            }
            for (int i = bottom; i >= top; i--) {
                result[index++] = mat[i][left];
            }
            left++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] result = new SpiralOrderMatrix1().spiralOrder(mat);
        Arrays.stream(result).forEach(System.out::print);

    }
}

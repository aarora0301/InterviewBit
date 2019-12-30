package interviewbit.BinarySearch.SearchAnswer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MatrixMedian {

    /**
     * No Extra memory : Using Binary Search
     *
     * @param A
     * @return
     */
    public int findMedian(int[][] A) {
        int length = A.length;
        int col = A[0].length;
        int min = A[0][0], max = A[length - 1][col - 1];
        for (int i = 0; i < length; i++) {
            min = Math.min(A[i][0], min);
        }

        for (int i = 0; i < length; i++) {
            max = Math.max(A[i][col - 1], max);
        }

        int desired = 1 + (length * col) / 2;
        while (min < max) {
            int mid = (min + max) / 2;
            int count = find(A, mid);
            if (count < desired) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return max;
    }

    private int find(int[][] arr, int mid) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (mid >= arr[i][j]) {
                    count++;
                }
            }
        }
        return count;

    }

    /**
     * Using min heap
     *
     * @param A
     * @return
     */
    public int findMedian(ArrayList<ArrayList<Integer>> A) {
        if (A == null || A.size() == 0) {
            return 0;
        }
        int row = A.size();
        int col = A.get(0).size();
        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>(row, Comparator.comparingInt(o -> o.get(0)));

        for (int i = 0; i < row; i++) {
            pq.add(A.get(i));
        }

        int middle = row * col / 2;
        int index = 0;
        int ans = 0;
        while (index <= middle) {
            ArrayList<Integer> list = pq.poll();
            ans = list.remove(0);
            if (list.size() > 0) {
                pq.add(list);
            }
            index++;
        }
        return ans;
    }

    public static void main(String[] args) {
        MatrixMedian mm = new MatrixMedian();
        int[][] a = {{1, 3, 5}, {2, 6, 9}, {3, 6, 9}};

    }

}

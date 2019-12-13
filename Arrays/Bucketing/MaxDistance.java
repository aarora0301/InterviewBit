package interviewbit.Arrays.Bucketing;

import java.util.Arrays;

/**
 * Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].
 * <p>
 * If there is no solution possible, return -1.
 * <p>
 * Example :
 * <p>
 * A : [3 5 4 2]
 * <p>
 * Output : 2
 * for the pair (3, 4)
 */
public class MaxDistance {
    /**
     * Brute-Force Approach : O(n^2)
     *
     * @param A
     * @return
     */
    public int maximumGap(final int[] A) {
        int maxDistance = 0;
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] >= A[j]) {
                    maxDistance = Math.max(maxDistance, i - j);
                }
            }

        }
        return maxDistance;
    }

    /**
     * Using Sorting : O(NLogN)
     *
     * @param A
     * @return
     */
    public int maxGap(final int[] A) {
        int length = A.length;
        Node[] node = new Node[length];
        for (int i = 0; i < length; i++) {
            node[i] = new Node(A[i], i);
        }
        Arrays.sort(node);
        int max = node[length - 1].index;
        for (int i = length - 1; i >= 0; i--) {
            if (max < node[i].index) {
                max = node[i].index;
            }
            node[i].num = max - node[i].index;

        }
        max = node[0].num;
        for (Node n : node) {
            max = Math.max(max, n.num);
        }
        return max;
    }

    class Node implements Comparable<Node> {
        int num;
        int index;

        public Node(int num, int index) {
            this.index = index;
            this.num = num;
        }

        @Override
        public int compareTo(Node o) {
            return ((Integer) this.num).compareTo(o.num);
        }
    }

    /**
     * Using two arrays : O(n)
     */
    public int maxGap_(final int[] A) {
        int length = A.length;
        int[] LMin = new int[length];
        int[] RMax = new int[length];
        int maxDiff;
        int i, j;
        LMin[0] = A[0];
        for (i = 1; i < A.length; i++) {
            LMin[i] = Math.min(A[i], LMin[i - 1]);
        }
        RMax[length - 1] = A[length - 1];
        for (j = length - 2; j >= 0; j--) {
            RMax[j] = Math.max(A[j], RMax[j + 1]);
        }
        i = 0;
        j = 0;
        maxDiff = -1;
        while (i < length && j < length) {
            if (LMin[i] <= RMax[j]) {
                maxDiff = Math.max(maxDiff, j - i);
                j = j + 1;
            } else {
                i = i + 1;
            }
        }
        return maxDiff;
    }
}

package interviewbit.Arrays.Bucketing;

import java.util.Arrays;

/**
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 * <p>
 * Try to solve it in linear time/space.
 * <p>
 * Example :
 * <p>
 * Input : [1, 10, 5]
 * Output : 5
 * Return 0 if the array contains less than 2 elements.
 * <p>
 * You may assume that all the elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 * You may also assume that the difference will not overflow.
 */
public class MaxConsecutiveGap {
    public int maximumGap(final int[] num) {
        if (num == null || num.length < 2) {
            return 0;
        }
        int max = Arrays.stream(num).max().getAsInt();
        int min = Arrays.stream(num).min().getAsInt();

        Bucket[] bucket = new Bucket[num.length + 1];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new Bucket();
        }
        double interval = (double) num.length / (max - min);

        for (int i = 0; i < num.length; i++) {
            int index = (int) ((num[i] - min) * interval);
            if (bucket[index].low == -1) {
                bucket[index].low = num[i];
                bucket[index].high = num[i];
            } else {
                bucket[index].low = Math.min(bucket[index].low, num[i]);
                bucket[index].high = Math.max(bucket[index].high, num[i]);
            }
        }

        int result = 0;
        int prev = bucket[0].high;
        for (int i = 1; i < bucket.length; i++) {
            result = Math.max(result, bucket[i].low - prev);
            if (bucket[i].high == -1) {
                continue;
            }
            prev = bucket[i].high;
        }
        return result;

    }


    class Bucket {
        int low;
        int high;

        public Bucket() {
            low = high = -1;
        }
    }

    public static void main(String[] args) {
        MaxConsecutiveGap mg = new MaxConsecutiveGap();
        int[] arr = {1, 10, 5};
        System.out.println(mg.maximumGap(arr));
    }
}


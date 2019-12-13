package interviewbit.Arrays.ValueRanges;

import java.util.ArrayList;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * <p>
 * You may assume that the intervals were initially sorted according to their start times.
 * <p>
 * Example 1:
 * <p>
 * Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].
 * <p>
 * Example 2:
 * <p>
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result in [1,2],[3,10],[12,16].
 * <p>
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * <p>
 * Make sure the returned intervals are also sorted.
 */

public class MergeIntervals {

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        Interval current = newInterval;
        int i = 0;
        while (i < intervals.size()) {
            Interval in = intervals.get(i);
            /**
             *   (1,2), (3,6), insert and merge (8,10)
             * there is no overlap with current interval
             * move to next interval in the list
             */
            if (current.getStart() > in.getEnd()) {
                i++;
                /**
                 * (3,6),(8,10), insert and merge (1,2)
                 * (1,2), (8,10) insert and merge (3,6)
                 */
            } else if (in.getStart() > current.getEnd()) {
                /**
                 * insert current at this position and move element already at this place to next index
                 * (given output should be in sorted order)
                 */
                intervals.add(i, current);
                break;
                /**
                 * case of overlap  (3, 5), (7, 9) insert and merge (1, 10)
                 */
            } else {
                current.setStart(Math.min(in.getStart(), current.getStart()));
                current.setEnd(Math.max(in.getEnd(), current.getEnd()));
                /**
                 * remove this element at which overlap occurred
                 * update its start and end and make it at a current
                 */
                intervals.remove(i);
            }
        }

        /**
         * after comparing all the elements (8,10) gets inserted
         */
        if (i == intervals.size()) {
            intervals.add(current);
        }
        return intervals;
    }
}

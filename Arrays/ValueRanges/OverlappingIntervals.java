package interviewbit.Arrays.ValueRanges;

import HackerEarth.Arrays.Matrix.MatrixSpiral;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/***
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * For example:
 *
 * Given [1,3],[2,6],[8,10],[15,18],
 *
 * return [1,6],[8,10],[15,18].
 *
 * Make sure the returned intervals are sorted.
 */
public class OverlappingIntervals {

    class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals, Comparator.comparingInt(o -> o.start));
        ArrayList<Interval> result = new ArrayList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (Interval interval : intervals) {
            if (interval.start <= end) {
                end = Math.max(end, interval.end);
            } else {
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        result.add(new Interval(start, end));
        return result;
    }
}

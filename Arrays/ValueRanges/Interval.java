package interviewbit.Arrays.ValueRanges;

public class Interval {
    private int start;
    private int end;

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

}

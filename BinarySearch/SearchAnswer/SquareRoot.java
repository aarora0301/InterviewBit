package interviewbit.BinarySearch.SearchAnswer;

/**
 * Given an integar A.
 * <p>
 * Compute and return the square root of A.
 * <p>
 * If A is not a perfect square, return floor(sqrt(A)).
 */
public class SquareRoot {

    public int sqrt(int A) {
        int start = 0;
        int end = A;
        int mid = 0;
        int sq = 0;
        long ans = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            sq = mid * mid;
            if (sq <= A) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }
        return (int) ans;
    }

    public static void main(String[] args) {
        SquareRoot sq = new SquareRoot();
        System.out.println(sq.sqrt(5));
    }
}

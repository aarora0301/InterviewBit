package interviewbit.BinarySearch.SearchAnswer;

/***
 *
 * Given 2 integers A and B and an array of integars C of size N.
 *
 * Element C[i] represents length of ith board.
 *
 * You have to paint all N boards [C0, C1, C2, C3 … CN-1]. There are A painters available and each of them takes B units of time to paint 1 unit of board.
 *
 * Calculate and return minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of board.
 *
 * Input 1:
 *     A = 2
 *     B = 5
 *     C = [1, 10]
 * Output 1:
 *     50
 * Explanation 1:
 *     Possibility 1:- same painter paints both blocks, time taken = 55units
 *     Possibility 2:- Painter 1 paints block 1, painter 2 paints block 2, time take = max(5, 50) = 50
 *     There are no other distinct ways to paint boards.
 *     ans = 50%10000003
 *
 * Input 2:
 *     A = 10
 *     B = 1
 *     C = [1, 8, 11, 3]
 * Output 2:
 *     11
 */
public class PainterProblem {

    public boolean check(int a[], int l, int k, long mi) {
        int sc = 1, i, su = 0;
        for (i = 0; i < l; i++) {
            if (a[i] > mi) {
                return false;
            }
            if (su + a[i] > mi) {
                sc += 1;
                su = a[i];
                if (sc > k) {
                    return false;
                }
            } else {
                su += a[i];
            }
        }
        return true;
    }

    public int paint(int k, int co, int[] a) {
        int m = 10000003;
        long ans = Integer.MAX_VALUE, e = 0, s = 0, mid;
        int l = a.length;
        if (l <= k) {
            for (int i : a)
                e = Math.max(e, i);
            e = (e * co) % m;
            return (int) e;
        }
        for (int i : a) {
            e += i;
        }
        while (s <= e) {
            mid = (s + e) / 2;
            if (check(a, l, k, mid)) {
                ans = Math.min(ans, mid);
                e = mid - 1;
            } else {
                s = mid + 1;
            }

        }
        ans = (ans * co) % m;
        return (int) ans;
    }

    public static void main(String[] args) {
        PainterProblem pp = new PainterProblem();
        int[] a = {1, 5, 10};
        System.out.println(pp.paint(2, 5, a));
    }
}

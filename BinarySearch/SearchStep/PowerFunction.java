package interviewbit.BinarySearch.SearchStep;

/***
 * Implement pow(x, n) % d.
 *
 * In other words, given x, n and d,
 *
 * find (xn % d)
 *
 * Note that remainders on division cannot be negative.
 * In other words, make sure the answer you return is non negative.
 *
 * Input : x = 2, n = 3, d = 3
 * Output : 2
 *
 * 2^3 % 3 = 8 % 3 = 2.
 */
public class PowerFunction {

    public int pow(int x, int n, int d) {
        long rem = 1;
        int check = 0;
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (x < 0) {
            x = Math.abs(x);
            if (n % 2 != 0) {
                check = 1;
            }

        }

        long temp = x % d;
        while (n != 0) {
            if (n % 2 != 0) {
                rem = (rem * temp) % d;
            }
            temp = temp * temp;
            temp = temp % d;
            n = n / 2;
            if (rem > d) {
                rem = rem % d;
            }

        }

        if (check == 1) {
            rem = d - (int) rem;
        }

        return (int) rem;

    }

    public static void main(String[] args) {
        PowerFunction pf = new PowerFunction();
        System.out.println(pf.pow(2, 3, 3));
    }
}

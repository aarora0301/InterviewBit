package interviewbit.BinarySearch.SearchAnswer;

/**
 * Given an array of integers A of size N and an integer B.
 * <p>
 * College library has N bags,the ith book has A[i] number of pages.
 * <p>
 * You have to allocate books to B number of students so that maximum number of pages alloted to a student is minimum.
 * <p>
 * A book will be allocated to exactly one student.
 * Each student has to be allocated at least one book.
 * Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.
 * Calculate and return that minimum possible number.
 * <p>
 * NOTE: Return -1 if a valid assignment is not possible
 * <p>
 * Input 1:
 * A = [12, 34, 67, 90]
 * B = 2
 * Output 1:
 * 113
 * Explanation 1:
 * There are 2 number of students. Books can be distributed in following fashion :
 * 1) [12] and [34, 67, 90]
 * Max number of pages is allocated to student 2 with 34 + 67 + 90 = 191 pages
 * 2) [12, 34] and [67, 90]
 * Max number of pages is allocated to student 2 with 67 + 90 = 157 pages
 * 3) [12, 34, 67] and [90]
 * Max number of pages is allocated to student 1 with 12 + 34 + 67 = 113 pages
 * <p>
 * Of the 3 cases, Option 3 has the minimum pages = 113.
 */
public class AllocateBooks {

    private boolean check(int[] a, int length, int B, int mid) {
        int sum = 0;
        int students = 1;
        for (int i = 0; i < length; i++) {
            if (a[i] > mid) {
                return false;
            }
            if (sum + a[i] > mid) {
                sum = a[i];
                students += 1;
                if (students > B) {
                    return false;
                }
            } else {
                sum += a[i];
            }
        }
        return true;
    }

    public int books(int[] A, int B) {
        int length = A.length;
        int end = 0, mid;
        int start = 0;
        int ans = Integer.MAX_VALUE;

        /**
         * if number of students is equal to number of books
         */
        if (length == B) {
            for (int i : A) {
                end = Math.max(end, i);
            }
            return end;
        }

        /**
         * if number of students is more than number of books
         */
        if (length < B) {
            return -1;
        }

        for (int i : A) {
            end += i;
        }

        while (start <= end) {
            mid = (start + end) / 2;
            if (check(A, length, B, mid)) {
                ans = Math.min(ans, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        AllocateBooks ab = new AllocateBooks();
        int[] A = {98, 42, 99, 68, 12, 60, 57, 94, 8, 95, 68, 13, 30, 6, 62, 42};
        System.out.println(ab.books(A, 16));
    }
}

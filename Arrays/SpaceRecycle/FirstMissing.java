package interviewbit.Arrays.SpaceRecycle;

import java.util.Arrays;

/***
 * Given an unsorted integer array, find the first missing positive integer.
 *
 * Example:
 *
 * Given [1,2,0] return 3,
 *
 * [3,4,-1,1] return 2,
 *
 * [-8, -7, -6] returns 1
 *
 * Your algorithm should run in O(n) time and use constant space.
 */
public class FirstMissing {

    /**
     * run : O(n)
     * space: O(n)
     *
     * @param A
     * @return
     */
    public int firstMissingPositive(int[] A) {
        int[] temp = Arrays.stream(A).filter(num -> num > 0).toArray();
        int length = temp.length;
        for (int i = 0; i < length; i++) {
            int x = Math.abs(temp[i]);
            if (x - 1 < length) {
                temp[x - 1] = -temp[x - 1];
            }
        }

        for (int i = 0; i < length; i++) {
            if (temp[i] > 0) {
                return i + 1;
            }
        }
        return length + 1;
    }

    /**
     * run: O(n)
     * space : O(1)
     *
     * @param a
     * @return
     */
    public int findMissing(int[] a) {
        int n = a.length;

        /**
         * j holds the count of negative numbers
         */
        int j = 0;
        for (int i = 0; i < n; i++) {
            /**
             * shift all the negative elements to the left
             * eg-> {1,3,-2,-4} to {-2,-4,1,2} now j=2
             */
            if (a[i] <= 0) {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                j++;
            }
        }


        /**
         * Traverse the positive elements
         */
        for (int i = j; i < n; i++) {
            int x = 0;
            /**
             * for input of type {-2,-3, 2 ,2}
             */
            if (a[i] < 0) {
                x -= a[i];
            } else {
                x = a[i];
            }
            /**
             * the actual number + j will give its position in the array
             */
            x += (j - 1);
            /**
             * negate the element
             */
            if (x >= 0 && x < n) a[x] = -a[x];

        }
        int ans = 1;
        for (int i = j; i < n; i++) {
            if (a[i] > 0) break;

            ans++;

        }
        return ans;
    }

    public static void main(String[] args) {
        FirstMissing fm = new FirstMissing();
        int[] arr = {417, 929, 845, 462, 675, 175, 73, 867, 14, 201, 777, 407, 80, 882, 785, 563, 209, 261, 776, 362, 730, 74, 649, 465, 353, 801, 503, 154, 998, 286, 520, 692, 68, 805, 835, 210, 819, 341, 564, 215, 984, 643, 381, 793, 726, 213, 866, 706, 97, 538, 308, 797, 883, 59, 328, 743, 694, 607, 729, 821, 32, 672, 130, 13, 76, 724, 384, 444, 884, 192, 917, 75, 551, 96, 418, 840, 235, 433, 290, 954, 549, 950, 21, 711, 781, 132, 296, 44, 439, 164, 401, 505, 923, 136, 317, 548, 787, 224, 23, 185, 6, 350, 822, 457, 489, 133, 31, 830, 386, 671, 999, 255, 222, 944, 952, 637, 523, 494, 916, 95, 734, 908, 90, 541, 470, 941, 876, 264, 880, 761, 535, 738, 128, 772, 39, 553, 656, 603, 868, 292, 117, 966, 259, 619, 836, 818, 493, 592, 380, 500, 599, 839, 268, 67, 591, 126, 773, 635, 800, 842, 536, 668, 896, 260, 664, 506, 280, 435, 618, 398, 533, 647, 373, 713, 745, 478, 129, 844, 640, 886, 972, 62, 636, 79, 600, 263, 52, 719, 665, 376, 351, 623, 276, 66, 316, 813, 663, 831, 160, 237, 567, 928, 543, 508, 638, 487, 234, 997, 307, 480, 620, 890, 216, 147, 271, 989, 872, 994, 488, 291, 331, 8, 769, 481, 924, 166, 89, 824, -4, 590, 416, 17, 814, 728, 18, 673, 662, 410, 727, 667, 631, 660, 625, 683, 33, 436, 930, 91, 141, 948, 138, 113, 253, 56, 432, 744, 302, 211, 262, 968, 945, 396, 240, 594, 684, 958, 343, 879, 155, 395, 288, 550, 482, 557, 826, 598, 795, 914, 892, 690, 964, 981, 150, 179, 515, 205, 265, 823, 799, 190, 236, 24, 498, 229, 420, 753, 936, 191, 366, 935, 434, 311, 920, 167, 817, 220, 219, 741, -2, 674, 330, 909, 162, 443, 412, 974, 294, 864, 971, 760, 225, 681, 689, 608, 931, 427, 687, 466, 894, 303, 390, 242, 339, 252, 20, 218, 499, 232, 184, 490, 4, 957, 597, 477, 354, 677, 691, 25, 580, 897, 542, 186, 359, 346, 409, 655, 979, 853, 411, 344, 358, 559, 765, 383, 484, 181, 82, 514, 582, 593, 77, 228, 921, 348, 453, 274, 449, 106, 657, 783, 782, 811, 333, 305, 784, 581, 746, 858, 249, 479, 652, 270, 429, 614, 903, 102, 378, 575, 119, 196, 12, 990, 356, 277, 169, 70, 518, 282, 676, 137, 622, 616, 357, 913, 161, 3, 589, 327};
        int[] res = {-2, -3, 2, 2};
        //System.out.println(fm.firstMissingPositive(arr));
        System.out.println(fm.findMissing(arr));
    }

}

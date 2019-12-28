package interviewbit.Math.BaseConversion;

/***
 * Given a column title as appears in an Excel sheet, return its corresponding column number.
 *
 * Example:
 *
 *     A -> 1
 *
 *     B -> 2
 *
 *     C -> 3
 *
 *     ...
 *
 *     Z -> 26
 *
 *     AA -> 27
 *
 *     AB -> 28
 */
public class ExcelColumn {

    public int titleToNumber(String A) {
        A = A.toUpperCase();
        int sum = 0;
        int index = 0;
        while (index < A.length()) {
            sum = 26 * sum + (A.charAt(index) - 'A' + 1);
            index++;
        }return sum;
    }

    public static void main(String[] args) {
        ExcelColumn ec = new ExcelColumn();
        System.out.println(ec.titleToNumber("AZA"));
    }
}

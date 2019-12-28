package interviewbit.Math.BaseConversion;


/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * <p>
 * For example:
 * <p>
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 */
public class ColumnTitle {

    public String convertToTitle(int A) {
        String s = "";
        int digit;
        char ch;
        while (A != 0) {
            digit = A % 26 + 64;
            if (A % 26 == 0) {
                /**
                 * if A is divisible by 26 add 'Z' as character, ascii of Z is 90
                 */
                digit = 90;
                A = A - 26;
            }
            ch = (char) digit;
            s = ch + s;
            A /= 26;

        }
        return s;
    }

    public static void main(String[] args) {
        ColumnTitle ct = new ColumnTitle();
        System.out.println(ct.convertToTitle(1353));
    }

}
package interviewbit.Arrays.Arrangement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given an n x n 2D matrix representing an image.
 * <p>
 * Rotate the image by 90 degrees (clockwise).
 * <p>
 * You need to do this in place.
 * <p>
 * Note that if you end up using an additional array, you will only receive partial score.
 */
public class RotateMatrix {

    public static void rotate(ArrayList<ArrayList<Integer>> a) {
        int S = a.size() - 1;

        for(int i = 0 ; i < a.size() / 2 ; i++){

            for(int j = i; j < S - i; ++j){

                int temp1 = a.get(S-j).get(i);
                int temp2 = a.get(S-i).get(S-j);
                int temp3 = a.get(j).get(S-i);
                int temp4 = a.get(i).get(j);

                // swap
                a.get(i).set(j,temp1);
                a.get(S-j).set(i,temp2);
                a.get(S-i).set(S-j,temp3);
                a.get(j).set(S-i,temp4);
            }
        }

    }

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(1, 2)));
        list.add(new ArrayList<>(Arrays.asList(3, 4)));
        rotate(list);
        list.stream().map(List::toString).forEach(System.out::print);
    }

}

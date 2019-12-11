package interviewbit.Arrays.Bucketing;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A hotel manager has to process N advance bookings of rooms for the next season. His hotel has K rooms. Bookings contain an arrival date and a departure date. He wants to find out whether there are enough rooms in the hotel to satisfy the demand. Write a program that solves this problem in time O(N log N) .
 */
public class HotelBooking {

    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        Collections.sort(arrive);
        Collections.sort(depart);
        int i = 0, j = 0, rooms = 0;
        while (i < arrive.size() && j < depart.size()) {
            if (arrive.get(i) < depart.get(j)) {
                i++;
                rooms++;
            } else {
                j++;
                rooms--;
            }

            if (rooms > K) {
                return false;
            }
        }
        return true;
    }
}

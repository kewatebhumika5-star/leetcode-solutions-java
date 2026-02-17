import java.util.*;

class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();

        // Check all possible hours and minutes
        for (int hour = 0; hour < 12; hour++) {
            for (int minute = 0; minute < 60; minute++) {

                // Count total LEDs ON
                int ledsOn = Integer.bitCount(hour) + Integer.bitCount(minute);

                if (ledsOn == turnedOn) {
                    // Format minute with leading zero
                    String time = hour + ":" + (minute < 10 ? "0" + minute : minute);
                    result.add(time);
                }
            }
        }

        return result;
    }
}

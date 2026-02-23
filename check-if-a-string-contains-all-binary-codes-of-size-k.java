import java.util.*;

class Solution {
    public boolean hasAllCodes(String s, int k) {
        int need = 1 << k;  // total binary codes = 2^k
        boolean[] seen = new boolean[need];
        
        int mask = need - 1;
        int hash = 0;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            // shift left and add current bit
            hash = ((hash << 1) & mask) | (s.charAt(i) - '0');

            // start counting only when window size reaches k
            if (i >= k - 1) {
                if (!seen[hash]) {
                    seen[hash] = true;
                    count++;
                    if (count == need) return true;
                }
            }
        }

        return false;
    }
}

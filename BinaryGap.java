class Solution {
    public int binaryGap(int n) {
        int lastPos = -1;   // stores last index of 1
        int maxDist = 0;
        int pos = 0;

        while (n > 0) {
            if ((n & 1) == 1) {   // check last bit
                if (lastPos != -1) {
                    maxDist = Math.max(maxDist, pos - lastPos);
                }
                lastPos = pos;
            }
            pos++;
            n >>= 1;   // shift right
        }

        return maxDist;
    }
}

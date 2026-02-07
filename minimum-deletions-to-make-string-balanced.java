class Solution {
    public int minimumDeletions(String s) {
        int bCount = 0;      // number of 'b's seen so far
        int deletions = 0;   // minimum deletions needed

        for (char c : s.toCharArray()) {
            if (c == 'b') {
                bCount++;
            } else { // c == 'a'
                // Either delete this 'a' (deletions + 1)
                // OR delete all previous 'b's (bCount)
                deletions = Math.min(deletions + 1, bCount);
            }
        }
        return deletions;
    }
}

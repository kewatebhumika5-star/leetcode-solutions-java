class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {

        int n = s.length();

        // If last index is '1', we can never reach it
        if (s.charAt(n - 1) == '1') {
            return false;
        }

        boolean[] visited = new boolean[n];
        visited[0] = true;

        int farthest = 0;

        for (int i = 0; i < n; i++) {

            // Skip if current index is not reachable
            if (!visited[i]) {
                continue;
            }

            // Start checking from max(i + minJump, farthest + 1)
            int start = Math.max(i + minJump, farthest + 1);

            // End position
            int end = Math.min(i + maxJump, n - 1);

            // Mark all reachable '0' positions
            for (int j = start; j <= end; j++) {
                if (s.charAt(j) == '0') {
                    visited[j] = true;
                }
            }

            // Update farthest checked index
            farthest = end;

            // If last index becomes reachable
            if (visited[n - 1]) {
                return true;
            }
        }

        return false;
    }
}

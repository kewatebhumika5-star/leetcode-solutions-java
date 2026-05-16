class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        int n = events.length;
        int[] suffixMax = new int[n];
        suffixMax[n - 1] = events[n - 1][2];

        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i + 1], events[i][2]);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int currEnd = events[i][1];
            int currValue = events[i][2];
            int left = i + 1, right = n - 1;
            int nextIndex = n;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (events[mid][0] > currEnd) {
                    nextIndex = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            int total = currValue;

            if (nextIndex < n) {
                total += suffixMax[nextIndex];
            }

            ans = Math.max(ans, total);
        }

        return ans;
    }
}

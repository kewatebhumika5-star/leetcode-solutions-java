import java.util.*;

class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        List<Integer> result = new ArrayList<>();

        for (int q : queries) {
            int val = nums[q];
            List<Integer> list = map.get(val);

            if (list.size() == 1) {
                result.add(-1);
                continue;
            }

            int pos = Collections.binarySearch(list, q);
            
            int minDist = Integer.MAX_VALUE;

            int prevIndex = list.get((pos - 1 + list.size()) % list.size());
            minDist = Math.min(minDist, getDist(q, prevIndex, n));

      
            int nextIndex = list.get((pos + 1) % list.size());
            minDist = Math.min(minDist, getDist(q, nextIndex, n));

            result.add(minDist);
        }

        return result;
    }

    private int getDist(int i, int j, int n) {
        int diff = Math.abs(i - j);
        return Math.min(diff, n - diff);
    }
}

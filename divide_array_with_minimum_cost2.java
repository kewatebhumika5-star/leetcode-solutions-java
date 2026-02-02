import java.util.*;

class Solution {
    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;
        long ans = Long.MAX_VALUE;

        TreeMap<Integer, Integer> small = new TreeMap<>(); 
        TreeMap<Integer, Integer> large = new TreeMap<>();
        int smallSize = 0;
        long smallSum = 0;

        
        for (int i = 1; i <= Math.min(n - 1, 1 + dist); i++) {
            int x = nums[i];
            if (!small.isEmpty() && x <= small.lastKey()) {
                add(small, x);
                smallSize++;
                smallSum += x;
            } else {
                add(large, x);
            }
        }

       
        while (smallSize > k - 1) {
            int x = small.lastKey();
            remove(small, x);
            smallSize--;
            smallSum -= x;
            add(large, x);
        }
        while (smallSize < k - 1 && !large.isEmpty()) {
            int x = large.firstKey();
            remove(large, x);
            add(small, x);
            smallSize++;
            smallSum += x;
        }

        if (smallSize == k - 1) ans = nums[0] + smallSum;

       
        for (int i1 = 2; i1 <= n - (k - 1); i1++) {
            int out = nums[i1 - 1];
            int inIdx = i1 + dist;
            Integer in = inIdx < n ? nums[inIdx] : null;

       
            if (small.containsKey(out)) {
                remove(small, out);
                smallSize--;
                smallSum -= out;
            } else {
                remove(large, out);
            }

          
            if (in != null) {
                if (!small.isEmpty() && in <= small.lastKey()) {
                    add(small, in);
                    smallSize++;
                    smallSum += in;
                } else {
                    add(large, in);
                }
            }

           
            while (smallSize > k - 1) {
                int x = small.lastKey();
                remove(small, x);
                smallSize--;
                smallSum -= x;
                add(large, x);
            }
            while (smallSize < k - 1 && !large.isEmpty()) {
                int x = large.firstKey();
                remove(large, x);
                add(small, x);
                smallSize++;
                smallSum += x;
            }

            if (smallSize == k - 1) {
                ans = Math.min(ans, nums[0] + smallSum);
            }
        }

        return ans;
    }

    private void add(TreeMap<Integer, Integer> map, int x) {
        map.put(x, map.getOrDefault(x, 0) + 1);
    }

    private void remove(TreeMap<Integer, Integer> map, int x) {
        int c = map.get(x);
        if (c == 1) map.remove(x);
        else map.put(x, c - 1);
    }
}

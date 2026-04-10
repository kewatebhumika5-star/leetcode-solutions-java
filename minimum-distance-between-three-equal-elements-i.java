import java.util.*;

class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
     
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        
        int minDist = Integer.MAX_VALUE;
        
        for (List<Integer> indices : map.values()) {
            if (indices.size() >= 3) {
               
                for (int i = 0; i <= indices.size() - 3; i++) {
                    int first = indices.get(i);
                    int third = indices.get(i + 2);
                    
                    int dist = 2 * (third - first);
                    minDist = Math.min(minDist, dist);
                }
            }
        }
        
        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
}

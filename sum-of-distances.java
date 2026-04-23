import java.util.*;

class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] result = new long[n];
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
      
        for (List<Integer> list : map.values()) {
            int size = list.size();
            
            // Prefix sum array
            long[] prefix = new long[size];
            prefix[0] = list.get(0);
            
            for (int i = 1; i < size; i++) {
                prefix[i] = prefix[i - 1] + list.get(i);
            }
            
            for (int i = 0; i < size; i++) {
                int index = list.get(i);
                
               
                long leftSum = (i > 0) ? prefix[i - 1] : 0;
                long leftCount = i;
                long left = index * leftCount - leftSum;
                
          
                long rightSum = prefix[size - 1] - prefix[i];
                long rightCount = size - i - 1;
                long right = rightSum - index * rightCount;
                
                result[index] = left + right;
            }
        }
        
        return result;
    }
}

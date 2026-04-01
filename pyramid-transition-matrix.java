import java.util.*;

class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        // Step 1: Build map
        Map<String, List<Character>> map = new HashMap<>();
        
        for (String s : allowed) {
            String key = s.substring(0, 2);
            char val = s.charAt(2);
            
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(val);
        }
        
        // Step 2: Start DFS
        return dfs(bottom, "", 0, map);
    }
    
    private boolean dfs(String curr, String next, int index, Map<String, List<Character>> map) {
        // If current level reduced to 1 → success
        if (curr.length() == 1) return true;
        
        // Finished building next row → go up
        if (index == curr.length() - 1) {
            return dfs(next, "", 0, map);
        }
        
        // Get pair
        String key = curr.substring(index, index + 2);
        
        // If no pattern → fail
        if (!map.containsKey(key)) return false;
        
        // Try all possibilities
        for (char c : map.get(key)) {
            if (dfs(curr, next + c, index + 1, map)) {
                return true;
            }
        }
        
        return false;
    }
}

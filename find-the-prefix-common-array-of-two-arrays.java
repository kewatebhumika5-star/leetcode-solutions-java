class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] result = new int[n];
        
        boolean[] seenA = new boolean[n + 1];
        boolean[] seenB = new boolean[n + 1];
        
        int count = 0;
        
        for (int i = 0; i < n; i++) {
          
            seenA[A[i]] = true;
            seenB[B[i]] = true;
            
            if (seenB[A[i]]) {
                count++;
            }
            
            if (A[i] != B[i] && seenA[B[i]]) {
                count++;
            }
            
            result[i] = count;
        }
        
        return result;
    }
}

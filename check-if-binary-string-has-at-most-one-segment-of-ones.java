class Solution {
    public boolean checkOnesSegment(String s) {
        boolean zeroFound = false;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0'){
                zeroFound = true;
            }
            if(zeroFound && s.charAt(i) == '1'){
                return false;
            }
        }

        return true;
    }
}

class Solution {
    public boolean isPalindrome(String s) {
        String in = s.toLowerCase();
        
        int l = 0;
        int r = in.length() - 1;
        
        while(l < r) {
            if(!Character.isLetterOrDigit(in.charAt(l))) {
                l++;
                continue;
            }
            if(!Character.isLetterOrDigit(in.charAt(r))) {
                r--;
                continue;
            }
            if(in.charAt(l) != in.charAt(r)) return false; 
            l++; r--;
        }
        
        return true;
    }
}
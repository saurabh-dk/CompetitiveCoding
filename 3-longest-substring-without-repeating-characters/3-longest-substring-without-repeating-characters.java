class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        
        int slow = 0;
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                slow = Math.max(slow, map.get(s.charAt(i)));
            }
            
            map.put(s.charAt(i), i+1);
            
            max = Math.max(max, i-slow+1);
        }
        
        return max;
    }
}
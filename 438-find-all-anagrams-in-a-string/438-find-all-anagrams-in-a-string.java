class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        
        if(p.length() > s.length()) return res;
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int match = 0;
        
        int slow = 0;
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, map.get(c)-1);
                if(map.get(c) == 0) match++;
            }
            
            if(i >= p.length()) {
                char out = s.charAt(slow);
                if(map.containsKey(out)) {
                    map.put(out, map.get(out) + 1);
                    if(map.get(out) == 1) {
                        match--;
                    }
                }
                slow++;
            }
            
            if(match == map.size()) {
                res.add(slow);
            }
        }
        
        return res;
    }
}
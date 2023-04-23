class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        if(strs.length == 0) return new ArrayList<>();
        
        HashMap<String, List<String>> map = new HashMap<>();
        
        for(String s : strs) {
            int[] store = new int[26];
            for(int i = 0; i < s.length(); i++) {
                store[s.charAt(i) - 'a']++;
            }
            String key = Arrays.toString(store);
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
                
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
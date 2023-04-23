class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, List<String>> map = new HashMap<>();
        
        for(String s : strs) {
            int[] store = new int[26];
            for(int i = 0; i < s.length(); i++) {
                store[s.charAt(i) - 'a']++;
            }
            String key = Arrays.toString(store);
            // System.out.println(key);
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
                
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
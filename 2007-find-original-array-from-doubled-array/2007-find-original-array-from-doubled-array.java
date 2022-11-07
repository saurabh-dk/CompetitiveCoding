class Solution {
    public int[] findOriginalArray(int[] changed) {
        if(changed.length % 2 != 0) return new int[]{};
        
        Arrays.sort(changed);
        
        int n = changed.length;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Set<Integer> set = new HashSet<>();
        
        for(int i : changed) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        //[1,1,1,2,2,3]
        //{1:3, 2:2, 3:1}
        
        int[] res = new int[n/2];
        
        int idx = 0;
        for(int i = 0 ; i < changed.length; i++) {
            if(map.containsKey(changed[i])) {
                // set.add(map.get(changed[i]));
                map.put(changed[i], map.get(changed[i])-1);
                if(map.get(changed[i]) <= 0) map.remove(changed[i]);
                
                res[idx++] = changed[i];
                
                if (!map.containsKey(changed[i] * 2)) return new int[]{};
                
                map.put(changed[i] * 2, map.get(changed[i]*2)-1);
                if(map.get(changed[i]*2) <= 0) map.remove(changed[i]*2);
            }
        }
        
        return res;
    }
}
class Solution {
    int res;
    public int countArrangement(int n) {
        res = 0;
        HashSet<Integer> map = new HashSet<>();
        helper(n, 1, map);
        
        return res;
    }
    
    private void helper(int n, int index, HashSet<Integer> map) {
        // base
        if(index == n+1) {
            res++;
            return;
        }
        
        // Logic
        
        for(int i = 1;  i <= n; i++) {
            if((i % index == 0 || index % i == 0) && !map.contains(i)) {
                map.add(i);
                helper(n, index+1, map);
                map.remove(i);
            }
        }
        
    }
}
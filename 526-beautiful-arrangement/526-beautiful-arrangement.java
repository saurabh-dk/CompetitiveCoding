class Solution {
    int res;
    public int countArrangement(int n) {
        res = 0;
        HashSet<Integer> map = new HashSet<>();
        List<Integer> arr = new ArrayList<>();
        helper(n, 1, map, arr);
        
        return res;
    }
    
    private void helper(int n, int index, HashSet<Integer> map, List<Integer> arr) {
        // base
        if(index == n+1) {
            res++;
            // for(int i : arr) {
            //     System.out.println(i);
            // }
            return;
        }
        
        // Logic
        
        for(int i = 1;  i <= n; i++) {
            if((i % index == 0 || index % i == 0) && !map.contains(i)) {
                map.add(i);
                arr.add(i);
                // System.out.println(i);
                helper(n, index+1, map, arr);
                map.remove(i);
                arr.remove(arr.size()-1);
            }
        }
        
    }
}
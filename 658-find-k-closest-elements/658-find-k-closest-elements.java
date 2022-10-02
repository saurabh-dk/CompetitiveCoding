class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0;
        int r = arr.length - 1;
        
        List<Integer> res = new ArrayList<>();
        
        while(r-l+1 > k) {
            int distL = Math.abs(x-arr[l]);
            int distR = Math.abs(arr[r]-x);
            
            if(distL > distR) {
                l++;
            } else {
                r--;
            }
        }
        
        while(l-1 != r) {
            res.add(arr[l]);
            l++;
        }
        
        return res;
    }
}
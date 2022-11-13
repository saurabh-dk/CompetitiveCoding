class Solution {
    public int arraySign(int[] nums) {
        int product = 1;
        for(int a : nums) {
            if(a == 0) {
                return 0;
            }
            if(a < 0) {
                product *= -1;
            }
        }
        
        return product;
    }
}
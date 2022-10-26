class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for(String e : wordDict) {
            set.add(e);
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j <= i; j++){
                if(dp[j] == true) {
                    if(set.contains(s.substring(j,i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[dp.length - 1];
    }
}
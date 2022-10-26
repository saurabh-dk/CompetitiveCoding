class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        
        int[][] dp = new int[2][n+1];

        for(int i = 1; i <= m ; i++){
            for(int j = 1; j <= n; j++){
                
                if(matrix[i-1][j-1] == '0') {
                    dp[i%2][j] = 0;
                }else{
                    dp[i%2][j] = Math.min( Math.min(dp[(i+1)%2][j-1], dp[(i+1)%2][j]) , dp[i%2][j-1]) + 1;
                }

                max = dp[i%2][j] > max ? dp[i%2][j] : max;
            }
        }

        return max*max;
    }
}
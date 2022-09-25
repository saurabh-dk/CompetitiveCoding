class Solution {
    int[][] dirs;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        
        dirs = new int[][]{{-1,0}, {1,0}, {0, -1}, {0,1}};
        
        int count = 0;
        
        Queue<Integer> rq = new LinkedList<>();
        Queue<Integer> cq = new LinkedList<>();
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1'){
                    count++;
                    // dfs(grid, i, j, m, n);
                    rq.add(i);
                    cq.add(j);
                    grid[i][j] = '0';
                    while(!rq.isEmpty()) {
                        int cr = rq.poll();
                        int cc = cq.poll();
                        for(int[] dir : dirs) {
                            int nr = dir[0] + cr;
                            int nc = dir[1] + cc;
                            
                            // bound check
                            if(nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == '1') {
                                rq.add(nr);
                                cq.add(nc);
                                grid[nr][nc] = '0';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
    
    private void dfs(char[][] grid, int i, int j, int m, int n) {
        // base
        if(i < 0 || j < 0 || i == m || j == n || grid[i][j] == '0') return;
        
        // logic
        grid[i][j] = '0';
        for(int[] dir : dirs) {
            int nr = i + dir[0];
            int nc = j + dir[1];
            dfs(grid, nr, nc, m, n);
        }
    }
}
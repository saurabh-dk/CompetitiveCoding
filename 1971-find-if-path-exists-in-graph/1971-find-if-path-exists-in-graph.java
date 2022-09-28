class Solution {
    boolean found;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] visited = new boolean[n];
        HashSet<Integer>[] graph = new HashSet[n];
        
        for(int i = 0; i < n; i++) {
            graph[i] = new HashSet<>();
        }
        
        for(int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        found = false;
        dfs(graph, visited, source, destination);
        return found;
    }
    
    private void dfs(HashSet<Integer>[] graph, boolean[] visited, int source, int destination) {
        if(source == destination) {
            found = true;
            return;
        }
        if(visited[source]) return;
        
        for(Integer i : graph[source]) {
            visited[source] = true;
            dfs(graph, visited, i, destination);
        }
    }
}
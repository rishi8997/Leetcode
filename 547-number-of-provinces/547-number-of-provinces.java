//Approach: Convert the given 2D array to adjacency list. For each unvisited node in the graph, increment the counter and call dfs. In the end return the counter.

class Solution {
    
    ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
    public void createAdjacencyList(int [][] grid){
        for(int r=0; r<grid.length; r++){
            adj.add(new ArrayList<Integer>());
            for(int c=0; c<grid[0].length; c++){
                if(r==c) continue;
                if(grid[r][c] == 1) adj.get(r).add(c);
            }
        }
        
    }
    
    public void dfs(int node, int[] vis, ArrayList<ArrayList<Integer>> adj){
        vis[node] = 1;
        for(int it : adj.get(node)){
            if(vis[it] == 0){
                dfs(it, vis, adj);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        createAdjacencyList(isConnected);
        int n = isConnected.length;
        int[] vis = new int[n];
        int count = 0;
        for(int i=0; i<n; i++){
            if(vis[i] == 0){
                count++;
                dfs(i, vis, adj);
            }
        }
        return count;
        
    }
}
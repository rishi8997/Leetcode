class Solution {
    
    public boolean bfs(int i, int[] color, int[][] graph){
         Queue<Integer> q = new LinkedList<>();
        q.add(i);
        color[i]=0;
        while(!q.isEmpty()){
            int num = q.poll();
            for(int it : graph[num]){
                if(color[it] != -1){
                    if(color[it] == color[num]){
                        return false;
                    }
                } else{
                    color[it] = 1 - color[num];
                    q.add(it);
                    
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        //createAdjacencyList(graph);
        int n = graph.length;
        int color[] = new int[n];
        for(int i=0; i<n; i++){
            color[i] = -1;
        }
        for(int i=0; i<n; i++){
            if(color[i] == -1){
                if(!bfs(i, color, graph)){
                    return false;
                }
            }
        }
       
        return true;
        
    }
}
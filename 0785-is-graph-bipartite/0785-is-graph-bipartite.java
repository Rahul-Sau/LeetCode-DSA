class Solution {
    boolean res=true;
    void dfs(int[][]adj,int node,int c,List<Integer> color)
    {
        if (!res) return;
         color.set(node, c);
        for(int j=0;j<adj[node].length;j++){
            int neigh=adj[node][j];
           if (color.get(neigh) != -1) {
                if (color.get(neigh) == c) {
                    res = false;
                    return;
                }
            }
            else
            {
                dfs(adj,neigh,1-c,color);
            }
        }
        return;
    }
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        List<Integer> color = new ArrayList<>(Collections.nCopies(n, -1)); 
        for(int i=0;i<n;i++){
            if (color.get(i) == -1 && res)
            dfs(graph,i,0,color);
        }
        return res;
    }
}
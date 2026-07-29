class Solution {
    int[] x={-1,1,0,0};
    int[] y={0,0,-1,1};
    boolean valid(int i,int j,int n,int m){
        if(i<0 ||i>=n||j<0||j>=m) return false;
        return true;
    }
    void dfs(char[][] arr,int n,int m,int i,int j,boolean[][] vis){
        vis[i][j]=true;
        for(int k=0;k<4;k++)// 4 direc move
        {
            int row=i+x[k];
            int col=j+y[k];
            if(valid(row,col,n,m) && arr[row][col]=='1' && !vis[row][col]){
                dfs(arr,n,m,row,col,vis);
            }
        }
        return;
    }
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int n=grid.length;
        int m=grid[0].length;
        int res=0;
        int i=0,j=0;
        boolean[][] vis=new boolean[n][m];// false automatically
        for(i=0;i<n;i++){
            for(j=0;j<m;j++){
                if(grid[i][j]=='1' && !vis[i][j]) 
                {
                    dfs(grid,n,m,i,j,vis);
                    res++;
                }
            }
        }
        return res;
    }
}
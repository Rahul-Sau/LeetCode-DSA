class Solution {
    boolean valid(int row,int col,int n,int m){
        if(row<0 ||row>=n || col<0 || col>=m)
        return false;
        return true;
    }
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int low=grid[0][0];
        int high=grid[0][0];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
            high=Math.max(high,grid[i][j]);
        }
        int res=0;
        while(low<=high){
            int guess=(low+high)/2;
            if(bfs(grid,n,m,guess)){
                res=guess;
                high=guess-1;
            }
            else
            low=guess+1;
        }
        return res;
    }
    boolean bfs(int[][] a,int n,int m,int guess){
        if (a[0][0] > guess) return false;
        int[] x={-1,1,0,0};
        int[] y={0,0,-1,1};
        Queue<int[] > q=new LinkedList<>();
        int[][]vis=new int[n][m];
        vis[0][0]=1;
        q.offer(new int[]{0,0});
        while(!q.isEmpty()){
            int[] p=q.poll();
            int row=p[0];
            int col=p[1];
            if(row==n-1 && col==m-1) return true;
            for(int k=0;k<4;k++){
                int r = row + x[k];
                int c = col + y[k];
                
                if (valid(r, c, n, m) && vis[r][c]==0 && guess>= a[r][c]){
                    q.offer(new int[]{r,c});
                    vis[r][c]=1;
                }
            }
        }
        return false;
    }
}
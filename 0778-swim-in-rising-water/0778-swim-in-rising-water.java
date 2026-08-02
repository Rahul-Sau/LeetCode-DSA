class Solution {
    boolean valid(int row,int col,int n,int m){
        if(row<0 ||row>=n || col<0 || col>=m)
        return false;
        return true;
    }
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(res[i], Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int[] x={-1,1,0,0};
        int[] y={0,0,-1,1};

        pq.add(new int[]{grid[0][0], 0, 0});
        res[0][0] = grid[0][0];
        while(!pq.isEmpty()){
            int[] p=pq.poll();
            int elev=p[0];
            int row=p[1];
            int col=p[2];
            if(elev>res[row][col])
            continue;
            for(int k=0;k<4;k++){
                int r=row +x[k];
                int c=col +y[k];
                if(valid(r,c,n,m)){
                int newelev=Math.max(elev,grid[r][c]);
                if(newelev<res[r][c]){
                    res[r][c]=newelev;
                    pq.add(new int[]{newelev,r,c});
                }
            }
        }
        }
        return res[n-1][m-1];
    }
}
class Solution {
    class Pair{
        int first,second;
        Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    boolean valid(int row,int col,int n,int m){
        if(row<0 ||row>=n || col<0 || col>=m)
        return false;
        return true;
    }
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(res[i], Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.add(new int[]{0, 0, 0});
        int[] x={-1,1,0,0};
        int[] y={0,0,-1,1};

        res[0][0]=0;
        while(!pq.isEmpty()){
            int[] p=pq.poll();
            int dist=p[0];
            int row=p[1];
            int col=p[2];
            if(dist>res[row][col])
            continue;
            for(int k=0;k<4;k++){
                int r=row +x[k];
                int c=col +y[k];
                if(valid(r,c,n,m)){
                int absdiff=Math.abs(heights[row][col]-heights[r][c]);
                int newwt=Math.max(absdiff,dist);
                if(newwt<res[r][c]){
                    res[r][c]=newwt;
                    pq.add(new int[]{newwt,r,c});
                }
            }
        }
        }
        return res[n-1][m-1];
    }
}
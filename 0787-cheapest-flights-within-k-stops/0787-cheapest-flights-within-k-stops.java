class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] res=new int[n];
        int INF = 100000000;
        Arrays.fill(res,INF);
        res[src]=0;
        for(int i=0;i<=k;i++){
            int[] t=res.clone();
            for(int j=0;j<flights.length;j++){
                int s=flights[j][0];
                int d=flights[j][1];
                int w=flights[j][2];
                if(res[s]!=INF && t[d]>res[s]+w)
                t[d]=res[s]+w;
            }
        res=t;
        }
        if(res[dst]==INF)
        return -1;
        else
            return res[dst];
    }
}
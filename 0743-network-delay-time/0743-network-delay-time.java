class Solution {
    class Pair{
        int node,weight;
        Pair(int node,int weight){
            this.node=node;
            this.weight=weight;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj= new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < times.length; i++) {
            int s = times[i][0];
            int d = times[i][1];
            int w = times[i][2];
            
            adj.get(s-1).add(new Pair(d-1,w));
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((p1,p2)->Integer.compare(p1.weight,p2.weight));
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k-1] = 0;
        pq.add(new Pair(k-1,0));
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int d=p.weight;
            int node=p.node;
            if (d > dist[node]) continue;
                for(int j=0;j < adj.get(node).size(); j++) { 
                Pair neighborPair = adj.get(node).get(j);
                int neigh = neighborPair.node;
                int wt = neighborPair.weight;
                if(d+wt<dist[neigh]){
                    dist[neigh]=d+wt;
                    pq.add(new Pair(neigh,dist[neigh]));
                }
            }
    }
     int maxDelay = 0;
        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            maxDelay = Math.max(maxDelay, dist[i]);
        }
        
        return maxDelay;
    }
}
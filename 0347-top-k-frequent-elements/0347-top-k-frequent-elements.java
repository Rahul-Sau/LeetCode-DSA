class Solution {
    class Pair{
        int first;int second;
        Pair(int f, int s){
            first=f;second=s;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            if(a.first!=b.first) return a.first-b.first;//min condition
            return a.second-b.second;//min condition
        });
        HashMap<Integer,Integer> f=new HashMap<>();
        for(int i=0;i<n;i++)
        f.put(nums[i],f.getOrDefault(nums[i],0)+1);
        for(Map.Entry<Integer,Integer> i:f.entrySet()){
            int elem=i.getKey();
            int freq=i.getValue();
            Pair curr=new Pair(freq,elem);
            if(pq.size()<k){
                pq.add(curr);
            }
            else{
                if(curr.first<pq.peek().first) continue;
                else{
                    pq.poll();
                    pq.add(curr);
                }
            }
        }
        int[] res = new int[k];
        while(!pq.isEmpty()){
            for (int i = 0; i < k; i++) {
            res[i] = pq.poll().second;
        }
        }
        return res;
    }
}
class Solution {
    class Pair {
        int key;
        int value;
        Pair(int key,int value) {
            this.key=key;
            this.value=value;
        }
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n=profits.length;
        Pair [] proj=new Pair[n];
        for(int i=0;i<n;i++){
            proj[i] = new Pair(capital[i], profits[i]);}
            Arrays.sort(proj, (a, b) -> Integer.compare(a.key, b.key));
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            int idx=0;
            while(k>0){
                    while (idx < n && proj[idx].key <= w) {
                pq.add(proj[idx].value);
                idx++;
                }
                if(pq.isEmpty()) break;
                 w += pq.poll();
                 k--;
            }
        return w;
    }
}
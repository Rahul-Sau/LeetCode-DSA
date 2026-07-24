class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue <Integer> pq=new PriorityQueue<>((a,b)->{
            int diff_a=Math.abs(a-x);
            int diff_b=Math.abs(b-x);
            if(diff_a != diff_b) return diff_a - diff_b;
            return a-b;//if diff becomes same compare by value
        });
        for( int num:arr){
            pq.add(num);
        }
        List <Integer> res=new ArrayList<>();
        for(int i=0;i<k;i++){
            res.add(pq.poll());
        }
        Collections.sort(res);
        return res;
    }
}
class Solution {
    void fun(int[] a,int n,int idx,List<Integer> diary,int sum,List<List<Integer>> res,int target){
        if(idx==n){
            if(sum==target)
                res.add(new ArrayList<>(diary));
            return;
        }
        fun(a,n,idx+1,diary,sum,res,target);//fnc call to not take any candidate, no update in diary

        // Include the current element (unlimited times if condition met)
        if(a[idx]+sum <=target){
            diary.add(a[idx]);
            sum += a[idx];
            fun(a,n,idx,diary,sum,res,target);
            diary.remove(diary.size()-1);
            sum -= a[idx];
        }
        return;
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n=candidates.length;
        int sum=0,idx=0;
        List<Integer> diary=new ArrayList<>();
        List<List<Integer>> res=new ArrayList<>();

        fun(candidates, n, idx, diary, sum, res, target);
        return res;
    }
}
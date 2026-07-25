class Solution {
    void fun(int open,int close,int n,StringBuilder temp,List<String> res){
        if(open == n && close==n){
            res.add(temp.toString());
            return;
        }
        // open condition
        if(open<n)
        {
            temp.append('(');
            fun(open+1,close,n,temp,res);
            temp.deleteCharAt(temp.length()-1);
        }
        //close condition
        if(close<open){
            temp.append(')');
            fun(open,close+1,n,temp,res);
            temp.deleteCharAt(temp.length()-1);
        }
        return ;
    }
    public List<String> generateParenthesis(int n) {
        int open =0,close=0;
        StringBuilder temp=new StringBuilder();
        List<String> res=new ArrayList<>();
        fun(open,close,n,temp,res);
        return res;
    }
}
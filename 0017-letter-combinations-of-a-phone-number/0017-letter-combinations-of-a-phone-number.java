class Solution {
    HashMap<Character,String> f=new HashMap<>();
    void fun(String s,int n,int idx,StringBuilder diary, List<String> res)
    {
        if(idx==n){
            res.add(diary.toString());
            return;
        }
        String choice=f.get(s.charAt(idx));
        for(int i=0;i<choice.length();i++){
            diary.append(choice.charAt(i));
            fun(s,n,idx+1,diary,res);
            diary.deleteCharAt(diary.length()-1);
        }
        return;
    }
    public List<String> letterCombinations(String digits) {
        f.put('2',"abc");
        f.put('3',"def");
        f.put('4',"ghi");
        f.put('5',"jkl");
        f.put('6',"mno");
        f.put('7',"pqrs");
        f.put('8',"tuv");
        f.put('9',"wxyz");
        int n=digits.length();
        int idx=0;
        StringBuilder diary=new StringBuilder();
        List<String> res=new ArrayList<>();
        fun(digits,n,idx,diary,res);
        return res;
    }
}
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs==null || strs.length==0) return "";

        String str1=strs[0];
        for(int i=0;i<str1.length();i++){
            char ch=str1.charAt(i);
            for(int j=1;j<strs.length;j++){
                if(i>=strs[j].length() || strs[j].charAt(i)!=ch){
                    return str1.substring(0,i);
                }
            }
        }
        return str1;
    }
}
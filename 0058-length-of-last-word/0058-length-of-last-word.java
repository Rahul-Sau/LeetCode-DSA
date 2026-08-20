class Solution {
    public int lengthOfLastWord(String s) {
        s=s.trim();
        int l=s.length();
        for(int i=l-1;i>=0;i--){
            if(s.charAt(i)==' ') return l-1-i;
        }
        return l;
    }
}
class Solution {
    public int lengthOfLastWord(String s) {
        String[] words=s.split("\\s+");
        String last;
        int n=words.length;
        last=words[n-1];
        return last.length();
    }
}
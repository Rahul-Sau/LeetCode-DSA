class Solution {
    class Pair{
        String first;int second;
        Pair(String first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n=wordList.size();
        HashMap<String,Boolean> f=new HashMap<>();
        for(int i=0;i<n;i++)
        f.put(wordList.get(i),true);
        if(!f.containsKey(beginWord)) f.put(beginWord, true);
        if(!f.containsKey(endWord)) return 0;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(beginWord,1));
        f.remove(beginWord);
        while(!q.isEmpty()){
            Pair p=q.poll();
            String s=p.first;
            int val=p.second;
            if(s.equals(endWord)) return val;
            char[] chars = s.toCharArray();
            for(int i=0;i<s.length();i++){
               char originalChar = chars[i]; 
                for(int j=97;j<=122;j++){
                   char nextChar = (char) j;
                    if (originalChar == nextChar) continue; 
                    chars[i] = nextChar; 
                    String nextWord = String.valueOf(chars);
                    if (f.containsKey(nextWord)) { 
                        q.add(new Pair(nextWord, val + 1)); 
                        f.remove(nextWord);
                    }
                }
                chars[i] = originalChar; 
            }
        }
        return 0;
    }
}
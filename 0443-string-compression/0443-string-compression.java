class Solution {
    public int compress(char[] chars) {
        int index=0,i=0,n=chars.length;
        while (i<n){
            char curr_char=chars[i];
            int count=0;
            while (i<n&&chars[i]==curr_char) {
                i++;
                count++;
            }
            chars[index]=curr_char;
            index++;
            if (count>1) {
                String count_str=Integer.toString(count);
                for (char c:count_str.toCharArray()) {
                    chars[index]=c;
                    index++;
                }
            }
        }
        return index;
    }
}
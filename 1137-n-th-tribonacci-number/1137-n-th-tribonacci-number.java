class Solution {
    public int tribonacci(int n) {
        int s=0;
        if(n==1 || n==2) return 1;
        int x=0,y=0,z=1;
        while(n>1){
            s=x+y+z;
            x=y;
            y=z;
            z=s;
            n--;
        }
        return s;
    }
}
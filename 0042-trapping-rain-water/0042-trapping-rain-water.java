class Solution {
    public int trap(int[] height) {
        int n =height.length;
        int ans=0,l_max=0,r_max=0;//to track boundaries
        int l=0,r=n-1;
        while(l<r){
            l_max=Math.max(l_max,height[l]);
            r_max=Math.max(r_max,height[r]);
            if(l_max<r_max){
                ans+=(l_max-height[l]);l++;
            }
            else{
                ans+=(r_max-height[r]);r--;
            }
        }
        return ans;
    }
}
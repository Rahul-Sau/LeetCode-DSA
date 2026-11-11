import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int x : nums1)
            set.add(x);
        
        List<Integer> ansList = new ArrayList<>();
        for(int x : nums2) {
            if(set.contains(x)) {
                ansList.add(x);
                set.remove(x);
            }
        }
        
        int[] ans = new int[ansList.size()];
        for(int i = 0; i < ansList.size(); i++)
            ans[i] = ansList.get(i);
        return ans;
    }
}
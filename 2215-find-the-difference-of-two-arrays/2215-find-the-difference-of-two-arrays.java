class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set <Integer> set1=new HashSet<>();
        Set <Integer> set2=new HashSet<>();
        for (int num : nums1) set1.add(num);
        for (int num : nums2) set2.add(num);
        Set<Integer> uniqueToNums1 = new HashSet<>(set1);
        Set<Integer> uniqueToNums2 = new HashSet<>(set2);
        uniqueToNums1.removeAll(set2);
        uniqueToNums2.removeAll(set1);
        List<List<Integer>> res=new ArrayList<>();
        res.add(new ArrayList<>(uniqueToNums1));
        res.add(new ArrayList<>(uniqueToNums2));
        return res;
    }
}
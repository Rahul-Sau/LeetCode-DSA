class Solution {
    public int maxProfit(int[] prices) {
        int min_price=Integer.MAX_VALUE,max_prof=0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<min_price) min_price=prices[i];
            else if (prices[i] - min_price > max_prof) {
                max_prof = prices[i] - min_price;
                }
        }
        return max_prof;
    }
}
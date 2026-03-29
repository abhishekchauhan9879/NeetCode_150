class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length ;
        if (n == 0) return 0;

        int minVal=prices[0];
        int profit = 0;

        for(int i=1;i<n;i++){
            profit=Math.max(profit,prices[i]-minVal);
            minVal=Math.min(minVal,prices[i]);
        }
        return profit;
    }
}

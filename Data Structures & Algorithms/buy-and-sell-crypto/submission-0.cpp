class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int minVal=INT_MAX;
        int profit=0;
        int maxProfit=0;
        int n=prices.size();

        for(int i=0;i<n-1;i++){
            minVal=min(minVal,prices[i]);//buyed the stocks
            profit=prices[i+1]-minVal;//condition not to sell on same day;
            maxProfit=max(maxProfit,profit);//calc max Profit earned
        }
        return maxProfit;
    }
};

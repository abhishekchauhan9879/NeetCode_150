class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int dp[][]=new int[n+1][amount+1];
        //Basic Initialisation 
        // for 0 coins, there are no way possible , so we need infinite supply of coins
        //for amount 0, zero coins are needed
        for(int i=0;i<=n;i++){
            for(int j=0;j<=amount;j++){
                if(i==0){
                    dp[i][j]=Integer.MAX_VALUE-1;
                }
                if(j==0){
                    dp[i][j]=0;
                }
            }
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=amount;j++){
                if(coins[i-1]<=j){
                    dp[i][j]=Math.min(dp[i-1][j],dp[i][j-coins[i-1]]+1);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][amount]==(Integer.MAX_VALUE-1)?-1:dp[n][amount];
    }
}

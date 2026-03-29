class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        int totalSum=0;

        for(int num:nums){
            totalSum+=num;
        }

        if(Math.abs(target) > totalSum) return 0;

        return (totalSum+target)%2==0?countWays(nums,n,(totalSum+target)/2 ):0;
    }

    private int countWays(int nums[], int n, int target){
        int dp[][] = new int[n+1][target+1];

        dp[0][0] = 1;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=target;j++){
                if(nums[i-1]<=j){
                    dp[i][j]=dp[i-1][j]+dp[i-1][j-nums[i-1]];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        return dp[n][target];
    }
}

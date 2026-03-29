class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum=0;

        for(int x:nums){
            totalSum+=x;
        }
        if(totalSum%2==0){
            return canPartitionHelper(nums,totalSum/2);
        }
        return false;
    }

    private boolean canPartitionHelper(int[] nums, int sum){
        int n=nums.length;
        boolean dp[][] = new boolean[n+1][sum+1];
        for(int i=0;i<n;i++){
            dp[i][0]=true;//for sum zero, there is empty subset always
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){

                if(nums[i-1]<=j){
                    dp[i][j]=dp[i-1][j]||dp[i-1][j-nums[i-1]];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        return dp[n][sum];
    }
}

class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;

        int arr[] = new int[n+2];
        arr[0]=arr[n+1]=1;
        for(int i=1;i<=n;i++){
            arr[i]=nums[i-1];
        }

        int dp[][] = new int[n+2][n+2];
        
        for(int len =2;len<n+2;len++){
            for(int i=0;i+len<n+2;i++){
                int j = len + i;

                for(int k=i+1;k<j;k++){
                    dp[i][j]=Math.max(dp[i][j], dp[i][k]+dp[k][j]+arr[i]*arr[k]*arr[j]);
                }
            }
        }
        return dp[0][n+1];
    }
}

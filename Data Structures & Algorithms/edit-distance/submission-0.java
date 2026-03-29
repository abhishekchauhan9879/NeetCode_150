class Solution {
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();

        int dp[][]=new int[m+1][n+1];

        for(int i=0;i<=m;i++){
            dp[i][0]=i;//if j is empty , insert equivalent words of j to i
        }

        for(int j=0;j<=n;j++){
            dp[0][j]=j;//if i is empty , insert equivalent words of i to j
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];//do nothing
                }else{
                    dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                                      //Replace    Delete from word1, delete from word2
                }
            }
        }
        return dp[m][n];
    }
}

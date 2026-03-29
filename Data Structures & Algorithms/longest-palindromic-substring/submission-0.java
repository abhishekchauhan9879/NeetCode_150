class Solution {
    public String longestPalindrome(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        int n=s.length();
        int dp[][]=new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                if(i==0||j==0)  dp[i][j]=0;
            }
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==reversed.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=0;
                }
            }
        }
        int maxLen = 0;
int endIndex = 0;

for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {

        if (dp[i][j] > maxLen) {

            int len = dp[i][j];

            int originalStart = i - len;
            int reversedStart = n - j;

            // ensure it is actual palindrome
            if (originalStart == reversedStart) {
                maxLen = len;
                endIndex = i - 1;
            }
        }
    }
}

return s.substring(endIndex - maxLen + 1, endIndex + 1);
    }
}

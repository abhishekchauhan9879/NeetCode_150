class Solution {
    public int numDecodings(String s) {
        int n=s.length();
        if(n==0)    return 0;
        int dp[]=new int[n+1];

        dp[0]=1;

        if(s.charAt(0)!='0'){
            dp[1]=1;
        }

        for(int i=2;i<=n;i++){
            char secondIdx = s.charAt(i-1);
            char firstIdx = s.charAt(i-2);

            if(secondIdx!='0'){
                dp[i]+=dp[i-1];
            }
            int num=(firstIdx-'0')*10+(secondIdx-'0');
            if(num>=10 && num<=26){
                dp[i]+=dp[i-2];
            }

        }
        return dp[n];
    }
}

class Solution {

    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    int m,n;

    public int longestIncreasingPath(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;

        int dp[][]=new int[m+1][n+1];
        int max=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                max=Math.max(max,dfs(matrix,i,j,dp));
            }
        }
        return max;
    }

    private int dfs(int[][] mat, int i, int j, int[][] dp){
        if(dp[i][j]!=0) return dp[i][j];

        dp[i][j]=1;//considering path starting from this path
        for(int []d:dir){
            int ni = i+d[0];
            int nj = j+d[1];

            if(ni>=0 && nj>=0 && ni<mat.length && nj<mat[0].length && mat[ni][nj]>mat[i][j]){
                dp[i][j] = Math.max(dp[i][j],1+dfs(mat,ni,nj,dp));
            }
        }
        return dp[i][j];
    }
}

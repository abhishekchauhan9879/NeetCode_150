class Solution {
    private int maxArea=0;
    public int maxAreaOfIsland(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    int area=dfs(grid,i,j);
                    maxArea=Math.max(maxArea,area);
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int i, int j){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]!=1){
            return 0;
        }
        int temp=grid[i][j];
        grid[i][j]=-1;
        int area=1;
        area+=dfs(grid,i+1,j);
        area+=dfs(grid,i-1,j);
        area+=dfs(grid,i,j+1);
        area+=dfs(grid,i,j-1);
        return area;
    }
}

class Solution {

    private int dirr[][] = {{-1,0},{1,0},{0,1},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();

        if(heights == null || heights.length==0)    return result;

        int m=heights.length;
        int n=heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // top for Pacific, bottom for atlantic
        for(int i=0;i<n;i++){
            dfs(heights,pacific,0,i);
            dfs(heights,atlantic,m-1,i);
        }
        //left for Pacific, bottom for atlantic
        for(int i=0;i<m;i++){
            dfs(heights,pacific,i,0);
            dfs(heights,atlantic,i,n-1);
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;
    }

    private void dfs(int[][] heights, boolean[][] visited, int row, int col){

        if(visited[row][col])   return;

        visited[row][col]=true;//mark visited;

        for(int d[]:dirr){
            int nr=row+d[0];
            int nc=col+d[1];

            if(nr>=0 && nr<heights.length && nc>=0 && nc<heights[0].length && heights[nr][nc]>=heights[row][col]){
                dfs(heights,visited,nr,nc);
            }
        }

    }
}

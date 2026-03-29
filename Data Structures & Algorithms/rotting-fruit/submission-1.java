class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        Queue<int[]> queue=new LinkedList<>();

        int fresh=0;
        int minutes=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0)    return 0;
        int dirr[][]={{-1,0},{1,0},{0,-1},{0,1}};

        while(!queue.isEmpty()){
            int size=queue.size();
            boolean isRottenNow=false;

            for(int i=0;i<size;i++){
                int[] curr=queue.poll();
                int row=curr[0];
                int col=curr[1];
                for(int d[]:dirr){
                    int newRow=row+d[0];
                    int newCol=col+d[1];

                    if(newCol<0||newRow<0||newRow>=grid.length||newCol>=grid[0].length
                        || grid[newRow][newCol]!=1){
                        continue;
                    }
                    grid[newRow][newCol]=2;
                    queue.offer(new int[]{newRow,newCol});
                    isRottenNow=true;
                    fresh--;
                }
            }
            if(isRottenNow) minutes++;
        }
        return (fresh==0)?minutes:-1;
    }
}

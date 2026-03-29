class Solution {

    private int[][] dirs ={{0,1},{0,-1},{1,0},{-1,0}};

    public int swimInWater(int[][] grid) {
        int n = grid.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[0]-b[0]));

        boolean visited[][] = new boolean[n][n];

        pq.offer(new int[]{grid[0][0],0,0});
        visited[0][0]=true;//mark current as true

        while(!pq.isEmpty()){
            int curr[]=pq.poll();
            int maxSoFar = curr[0];
            int r=curr[1];
            int c=curr[2];

            if(r==n-1 && c==n-1){
                return maxSoFar;
            }

            for(int[] d:dirs){
                int nr= r+d[0];
                int nc=c+d[1];

                if(nr>=0 && nc>=0 && nr<n && nc<n && !visited[nr][nc]){
                    visited[nr][nc]=true;
                    int newMax = Math.max(maxSoFar, grid[nr][nc]);
                    pq.offer(new int[]{newMax, nr, nc});
                }
            }
        }
        return -1;// not reachable
    }
}

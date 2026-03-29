class Solution {

    private int[][] dirr={
        {-1,0},{0,1},{1,0},{0,-1}
    };

    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;

        //Start with the border points and mark the region of 0 related to the boarding zero
        for(int col = 0; col < n; col++){
            dfs(board, 0, col);
            dfs(board, m-1, col);
        }

        for(int row = 0; row < m; row++){
            dfs(board, row, 0);
            dfs(board, row, n-1);
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O'){//still zero that means not connected to board 0
                    board[i][j]='X';
                }
            }
        }
        // Lets undo the T to 0 for the boundary connected 0
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='T'){
                    board[i][j]='O';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col){
        if(board[row][col]!='O') return;

        board[row][col]='T';
        for(int d[]:dirr){
            int nr=d[0]+row;
            int nc=d[1]+col;

            if(nr>=0 && nr<=board.length-1 && nc>=0 && nc<=board[0].length-1){
                dfs(board,nr,nc);
            }
        }
    }
}

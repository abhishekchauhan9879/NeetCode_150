class Solution {
    public List<List<String>> solveNQueens(int n) {
        if(n==0)    return new ArrayList<>();

        List<List<String>> res = new ArrayList<>();

        char[][] board = new char[n][n];
        for(char[] ch:board){
            Arrays.fill(ch,'.');
        }

        boolean col[] = new boolean[n];
        boolean leftDiag[] = new boolean[2*n];
        boolean rightDiag[] = new boolean[2*n];
        backtrack(0, board, res, col, leftDiag, rightDiag, n);
        return res;
    }

    private void backtrack(int row, char[][] board, List<List<String>> res, boolean col[], 
                            boolean leftDiag[], boolean rightDiag[], int n){
        if(row == n){
            //add the current board;
            res.add(construct(board));
            return;
        }

        for(int c=0;c<n;c++){
            if(col[c] || leftDiag[row-c+n] || rightDiag[row+c]){
                continue;
            }
            //Place
            board[row][c]='Q';
            col[c]=true;
            leftDiag[row-c+n]=true;
            rightDiag[row+c]=true;

            //Explore
            backtrack(row+1, board, res, col, leftDiag, rightDiag, n);

            //remove
            board[row][c]='.';
            col[c]=false;
            leftDiag[row-c+n]=false;
            rightDiag[row+c]=false;
        }
    }

    private List<String> construct(char[][] board){
        List<String> curr = new ArrayList<>();
        for(char[] ch: board){
            curr.add(new String(ch));
        }
        return curr;
    }
}

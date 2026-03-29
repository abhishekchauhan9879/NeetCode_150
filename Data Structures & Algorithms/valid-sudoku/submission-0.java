class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] columns = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char c = board[i][j];
                if(c=='.') continue;
                int num = c - '1';

                int boxNum = (i/3)*3 + (j/3);
                if(rows[i][num]||columns[j][num] || boxes[boxNum][num]){
                    return false;
                }

                rows[i][num]=true;
                columns[j][num]=true;
                 boxes[boxNum][num]=true;
            }
        }
        return true;
    }
}

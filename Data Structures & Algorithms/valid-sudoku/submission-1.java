class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        int m=board.length;
        int n=board[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                char num= board[i][j];
                if(num=='.')    continue;

                String row = "row-"+i+"-"+num;
                String col = "col-"+j+"-"+num;
                String box = "row-"+(i/3)+"-"+"col-"+(j/3)+num;

                if(!seen.add(row) ||!seen.add(col) ||!seen.add(box)){
                    return false;
                }
            }
        }
        return true;
    }
}

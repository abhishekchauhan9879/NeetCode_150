class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int ROWS=matrix.size();
        int COLS=matrix[0].size();

        int initialRow=0,lastRow=ROWS-1;

        while(initialRow<=lastRow){
            int mid=initialRow+(lastRow-initialRow)/2;

            if(target>matrix[mid][COLS-1]){
                initialRow=mid+1;
            }else if(target<matrix[mid][0]){
                lastRow=mid-1;
            }else{
                initialRow = mid;
                break;
            }
        }
        if(initialRow>lastRow) return false;

        int l=0,r=COLS-1;
        while(l<=r){
            int mid=l+(r-l)/2;

            if(target>matrix[initialRow][mid]){
                l=mid+1;
            }else if(target<matrix[initialRow][mid]){
                r=mid-1;
            }else{
                return true;
            }
        }
        return false;
    }
};

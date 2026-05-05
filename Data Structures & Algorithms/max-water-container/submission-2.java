class Solution {
    public int maxArea(int[] heights) {
        int n=heights.length;

        int l=0;
        int r=n-1;
        int maxArr = Integer.MIN_VALUE;
        while(l<r){
            int height = Math.min(heights[l], heights[r]);
            int width = r - l;

            maxArr = Math.max(maxArr, height * width);

            if(heights[l]<heights[r]){
                l++;
            }else{
                r--;
            }
        }
        return maxArr;
    }
}

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int maxArea=0;

        for(int i=0;i<=n;i++){
            
            int currHeight = (i==n)?0:heights[i];

            while(!st.isEmpty() && currHeight < heights[st.peek()] ){

                int height = heights[st.pop()];
                int width;

                if(st.isEmpty()){
                    width=i;
                }else{
                    width=i-st.peek()-1;
                }

                maxArea= Math.max(maxArea, width*height);

            }
            st.push(i);
        }
        return maxArea;
    }
}

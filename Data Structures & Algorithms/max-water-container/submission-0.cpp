class Solution {
public:
    int maxArea(vector<int>& heights) {
        int n=heights.size();
        int ans=0;

        int i=0;
        int j=n-1;

        while(i<j){
            int vert=min(heights[i],heights[j]);
            int horizontal=j-i;
            int maxArea=vert*horizontal;
            cout<<i<<" "<<j<<" "<<maxArea<<endl;
            ans=max(ans,maxArea);
            if(heights[i]<=heights[j]){
                i++;
            }else{
                j--;
            }
        }

        return ans; 
    }
};

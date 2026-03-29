class Solution {
public:
    int trap(vector<int>& height) {
        int res=0;
        int n=height.size();
        for(int i=1;i<n-1;i++){

            int maxLHeight=height[i];
            int maxRHeight=height[i];

            for(int j=0;j<i;j++){
                maxLHeight=max(maxLHeight,height[j]);
            }

            for(int j=i+1;j<n;j++){
                maxRHeight=max(maxRHeight,height[j]);
            }
            res+=min(maxLHeight,maxRHeight)-height[i];
        }

        return res;
    }
};

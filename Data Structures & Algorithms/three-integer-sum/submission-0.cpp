class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        vector<vector<int>> res;
        sort(nums.begin(),nums.end());
        set<vector<int>> s;
        int n= nums.size();

        for(int i=0;i<n-2;i++){
            int j=i+1;
            int k=n-1;

            while(j<k){
                int currSum = nums[i]+nums[j]+nums[k];
                if(currSum==0){
                    s.insert({nums[i],nums[j],nums[k]});
                    j++;
                    k--;
                }
                else if(currSum>0){
                    k--;
                }else{
                    j++;
                }
            }

        }
        for(auto x:s){
            res.push_back(x);
        }
        return res;
    }
};

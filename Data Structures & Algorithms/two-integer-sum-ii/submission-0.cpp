class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        vector<int> result;

        int l=0;
        int r=numbers.size()-1;

        while(l<r){
            int currSum=numbers[l]+numbers[r];

            if(currSum<target){
                l++;
            }else if(currSum>target){
                r--;
            }else{
                return {l+1,r+1};
            }
        }
        
        return {};
    }
};

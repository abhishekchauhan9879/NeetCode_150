class Solution {
public:
    bool hasDuplicate(vector<int>& nums) {
        unordered_map<int,int> mymap;

        for(auto x:nums){
            if(mymap[x]>0){
                return true;
            }
            mymap[x]++;
        }

        return false;
    }
};

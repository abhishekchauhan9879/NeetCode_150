class Solution {
public:
    bool hasDuplicate(vector<int>& nums) {
        unordered_map<int,int> mymap;

        for(auto x:nums){
            if(mymap.find(x)!=mymap.end()){
                return true;
            }
            mymap[x]++;
        }

        return false;
    }
};

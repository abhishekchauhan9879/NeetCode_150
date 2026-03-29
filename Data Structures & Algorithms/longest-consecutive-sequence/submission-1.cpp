class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        unordered_set<int> numSet(nums.begin(),nums.end());
        int longestStreak=0;

        for(auto x:numSet){

            if(numSet.find(x-1)==numSet.end()){
                int currentStreak=1;
                int currNum=x;
                while(numSet.find(currNum+1)!=numSet.end()){
                    currentStreak++;
                    currNum++;
                    
                }
                longestStreak=max(longestStreak,currentStreak);
            }
        }
        return longestStreak;
    }
};

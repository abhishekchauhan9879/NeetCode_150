class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int,int> freqMap;

        for(auto x:nums){
            freqMap[x]++;
        }

        priority_queue<pair<int,int>> pq;

        for (auto x:freqMap){
            pq.push({x.second,x.first});
        }

        vector<int> result;
        while(!pq.empty() && k--){
            result.push_back(pq.top().second);
            pq.pop();
        }
        return result;
    }
};

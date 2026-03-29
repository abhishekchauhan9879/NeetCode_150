class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> ans;

        for (auto s:strs){
            vector<int> count(26,0);
            for(auto c:s){
                count[c-'a']++;
            }

            string key;
            for(auto i:count){
                key+="#"+to_string(i);
            }

            ans[key].push_back(s);
        }
        vector<vector<string>> result;
        for(auto x:ans){
            result.push_back(x.second);
        }

        return result;
    }
};

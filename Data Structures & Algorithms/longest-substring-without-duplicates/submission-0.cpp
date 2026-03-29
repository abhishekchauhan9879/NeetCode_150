class Solution {
public:
    int lengthOfLongestSubstring(string str) {
        unordered_set<char> s;
        int l=0,r=0;
        int res=0;

        while(r<str.length()){
            while(s.find(str[r])!=s.end()){
                s.erase(str[l]);
                l++;
                
            }
            s.insert(str[r]);
            res=max(res,r-l+1);
            r++;
        }

        return res;
    }
};

class Solution {
public:

    void helper(int open ,int close,string op, vector<string>& ans){
        if(open==0 && close==0){
            ans.push_back(op);
            return;
        }

        if(open!=0){
            helper(open-1,close,op+"(",ans);
        }
        if(close>open){
            helper(open,close-1,op+")",ans);
        }
    }
    vector<string> generateParenthesis(int n) {
        vector<string> ans;
        helper(n,n,"",ans);
        return ans;
    }
};

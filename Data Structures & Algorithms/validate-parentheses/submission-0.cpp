class Solution {
public:
    bool isValid(string s) {
        stack<char> st;
        unordered_map<char,char> parenthesis ={
            {')','('},
            {'}','{'},
            {']','['},
        };
        for(auto ch:s){
            if(parenthesis.find(ch)==parenthesis.end()){
                st.push(ch);
            }else{
                if(!st.empty() && st.top()==parenthesis[ch]){
                    st.pop();
                }
                else{
                    return false;
                }    
            }        
        }
        return (st.empty())?true:false;
    }
};

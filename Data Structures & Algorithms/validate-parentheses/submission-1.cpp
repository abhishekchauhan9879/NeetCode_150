class Solution {
public:
    bool isValid(string s) {
        stack<char> st;
        for(int i=0;i<s.length();i++){
            char ch=s[i];
            if(ch=='{'||ch=='['||ch=='('){
                st.push(ch);
            }else{
                if(!st.empty() && abs(ch-st.top())<=2){
                    st.pop();
                }
                else{
                    return false;
                }    
            }        
        }
        return st.empty();
        
    }
};

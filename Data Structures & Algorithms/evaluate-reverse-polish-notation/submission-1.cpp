class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        stack<int> st;

        for(auto x:tokens){
            if(x=="+" || x=="-"||x=="/"||x=="*"){
                long long int b = st.top();st.pop();
                long long int a = st.top();st.pop();
                if(x=="+"){
                    st.push(a+b);
                }
                else if(x=="-"){
                    st.push(a-b);
                }
                else if(x=="*"){
                    st.push(a*b);
                }else if(x=="/"){
                    st.push(a/b);
                }
            }
            else{
                st.push(stoll(x));
            }
        }
        return st.top();
    }
};

class Solution {
public:

    string encode(vector<string>& strs) {
        string res;
        for(auto x:strs){
            res+=to_string(x.length())+"#"+x;
        }
        cout<<res;
        return res;
    }
    
    vector<string> decode(string s) {
        vector<string> res;

        int i=0;
        while(i<s.size()){
            int j=i;
            while(s[j]!='#'){
                j++;
            }
            int length=stoi(s.substr(i,j-i));
            string str=s.substr(j+1,length);
            res.push_back(str);
            i=j+length+1;
        }

        return res;
    }
};

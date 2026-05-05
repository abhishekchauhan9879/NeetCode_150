class Solution {
    public boolean isAnagram(String s, String t) {
        int res[]=new int[26];

        for(int i=0;i<s.length();i++){
            res[s.charAt(i)-'a']++;
        }

        for(int j=0;j<t.length();j++){
            res[t.charAt(j)-'a']--;
        }
        for(int x:res){
            if(x!=0)    return false;
        }
        return true;
    }
}

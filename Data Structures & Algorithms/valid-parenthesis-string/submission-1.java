class Solution {
    public boolean checkValidString(String s) {
        Stack<Character> st = new Stack<>();
        int low=0;//lowest range for (
        int high=0;//highest range for (
        for(char ch:s.toCharArray()){
            if(ch=='('){
                low++;//increase ( by one
                high++;//increase ( by one
            }else if(ch==')'){
                low--;//reduce ( by one
                high--;//reduce ( by one
            }else if(ch=='*'){//for handling *
                low--;//can be )
                high++;//can be (
            }
            if(high < 0) return false; // if the highest range of open is negative
            low=Math.max(low,0);
        }
        return low==0;
    }
}
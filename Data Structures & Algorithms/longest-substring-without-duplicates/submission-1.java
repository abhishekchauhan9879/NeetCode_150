class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left=0,right=0,maxLen=0;
        Set<Character> set = new HashSet<>();
        while(right<s.length()){
            char ch=s.charAt(right);
            if(!set.contains(ch)){
                set.add(ch);
                right++;
                maxLen=Math.max(maxLen,right-left);
            }else{
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxLen;
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left=0, right=0, maxLen=0;
        int n=s.length();

        Set<Character> set = new HashSet<>();

        while(right<n){
            char ch=s.charAt(right);
            while(set.contains(ch)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(ch);
            maxLen=Math.max(maxLen, right-left+1);
            right++;
        }

        return maxLen;
    }
}

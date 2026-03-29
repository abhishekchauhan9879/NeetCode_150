class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int left=0,right=0,maxLen=0,maxFreq=0;
        int[] freq = new int[26];
        while(right<n){
            char ch = s.charAt(right);
            freq[ch-'A']++;

            maxFreq = Math.max(maxFreq,freq[ch-'A']);

            int windowSize = right - left +1;
            if(windowSize - maxFreq > k){
                freq[s.charAt(left)-'A']--;//shrink the window
                left++;
            }
            maxLen = Math.max(maxLen,right-left+1);
            right++;
        }
        return maxLen;
    }
}

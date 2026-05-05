class Solution {
    public int characterReplacement(String s, int k) {
        int freq[]=new int[26];
        int l=0, maxLen=0, maxFreq=0;
        int n=s.length();

        for(int r=0;r<n;r++){
            char ch=s.charAt(r);
            freq[ch-'A']++;
            maxFreq=Math.max(maxFreq, freq[ch-'A']);

            if(r-l+1-maxFreq>k){
                char lch=s.charAt(l);
                freq[lch-'A']--;
                l++;

                maxFreq=reCalc(freq);
            }
            maxLen=Math.max(maxLen, r-l+1);
        }
        return maxLen;
    }

    private int reCalc(int freq[]){
        int maxFreq=0;
        for(int x:freq){
            maxFreq=Math.max(maxFreq,x);
        }
        return maxFreq;
    }
}

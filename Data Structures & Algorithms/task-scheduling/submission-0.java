class Solution {
    public int leastInterval(char[] tasks, int n) {
        int maxFreq=0, countMax=0;
        int freq[]=new int[26];
        for(char ch:tasks){
            freq[ch-'A']++;
            maxFreq=Math.max(maxFreq,freq[ch-'A']);
        }
        
        for(int x:freq){
            if(x==maxFreq)  countMax++;
        }
        return Math.max(tasks.length,(maxFreq-1)*(n+1)+countMax);

    }
}

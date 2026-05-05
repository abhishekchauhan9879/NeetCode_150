class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;

        int freq1[] = new int[26];
        int freq2[] = new int[26];

        for(char ch:s1.toCharArray()){
            freq1[ch-'a']++;
        }

        int window=s1.length();

        for(int i=0;i<s2.length();i++){
            char ch=s2.charAt(i);
            freq2[ch-'a']++;
            //if we pass the window size, then reduce the leftmost ch frequency
            if(i>=window){  
                freq2[s2.charAt(i-window)-'a']--;
            }

            if(Arrays.equals(freq1,freq2)){
                return true;
            }
        }
        return false;
    }
}

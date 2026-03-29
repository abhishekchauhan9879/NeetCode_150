class Solution {
    public String minWindow(String s, String t) {
        //edge cases
        if(s.length()==0 || t.length()==0)	return "";

        //Map to store the character with the frequency of t
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: t.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);	// X->1,Y->1, Z->1
        }
        // left maintain a window to get the substring
        int left=0;
        int right=0; // expand as we will go right 

        int required = map.size();//required elements in the string t
        int formed=0;
        Map<Character, Integer> window = new HashMap<>();
        int minLen=Integer.MAX_VALUE;
        int start = 0; // when we will find the minLen , we store the start index to get the substring

        while(right<s.length()){
            // to track the current window element and their freq and //check with the string t map frequency
            char curr = s.charAt(right);// O
            window.put(curr, window.getOrDefault(curr,0)+1);
            // we have to prepare the substring we have all characters required for t in s present
            
            if(map.containsKey(curr)&& map.get(curr).intValue()==window.get(curr).intValue()){
                formed++;// for one of the char, we have fulfilling frequency in s 
            }

            while(left<=right && formed==required){
                //operation to calculate the min Len
                //if we entered this loop, that surely means we have all char of t in s with their freq required
                if(right - left +1<minLen){
                    minLen=right-left+1;
                    start=left;
                }
                char leftChar=s.charAt(left);
                window.put(leftChar, window.get(leftChar).intValue()-1);

                if(map.containsKey(leftChar) && (window.get(leftChar).intValue()<map.get(leftChar).intValue())){
                    formed--;
                }
                left++;
            }
            right++;// keep inc the window size until we have matching character all present with their freq in s
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start+minLen);
    }
}

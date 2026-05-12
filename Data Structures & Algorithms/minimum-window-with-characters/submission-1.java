class Solution {
    public String minWindow(String s, String t) {
        if(s.length()==0 || t.length()==0)	return "";

        Map<Character, Integer> tMap = new HashMap<>();
        
        for(char ch:t.toCharArray()){
            tMap.put(ch, tMap.getOrDefault(ch,0)+1);
        }

        // Now we have freq mapping of each char of t string
        int required = tMap.size();

        int left=0,start=0 , minLen=Integer.MAX_VALUE;

        int formed=0;
        int n=s.length();
        Map<Character, Integer> windowMap = new HashMap<>();
        for(int right=0;right<n;right++){
            char curr = s.charAt(right);

            windowMap.put(curr, windowMap.getOrDefault(curr,0)+1);

            if(tMap.containsKey(curr) && tMap.get(curr)==windowMap.get(curr)){
                formed++;
            }

            while(left<=right && formed==required){
                if(right-left+1 < minLen){
                    minLen=Math.min(minLen, right-left+1);
                    start=left;
                }

                char lCurr = s.charAt(left);
                windowMap.put(lCurr, windowMap.getOrDefault(lCurr,0)- 1);

                if(tMap.containsKey(lCurr) && windowMap.get(lCurr)<tMap.get(lCurr)){
                    formed--;
                }
                left++;
            }
        }
        return minLen==Integer.MAX_VALUE ? "" : s.substring(start,start+minLen);
    }
}

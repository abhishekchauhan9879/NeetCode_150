class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();

        for(int x:nums){
            set.add(x);
        }
        int maxLength=0;
        for(int x:set){
            if(!set.contains(x-1)){
                int currLength=1;
                int curr=x;
                while(set.contains(curr+1)){
                    currLength++;
                    curr++;
                }
                maxLength=Math.max(maxLength, currLength);
            }
        }
        return maxLength;
    }
}

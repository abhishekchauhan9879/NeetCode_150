class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> num = new HashSet<>();

        for(int x:nums){
            num.add(x);
        }
        int maxLength=0;
        for(int x:num){
            if(!num.contains(x-1)){//check if smaller element exists for seq
                int currLength=1;
                int curr=x;
                while(num.contains(curr+1)){
                    currLength=currLength+1;
                    curr=curr+1;
                }

            maxLength=Math.max(maxLength,currLength);
            }
        }

        return maxLength;
    }
}

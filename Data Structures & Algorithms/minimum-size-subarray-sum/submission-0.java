class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen=Integer.MAX_VALUE;
        int sum=0;
        int l=0;

        for(int r=0;r<nums.length;r++){
            sum+=nums[r];

            while(l<=r && sum>=target){
                sum-=nums[l];
                minLen=Math.min(minLen, r-l+1);
                l++;
                
            }
        }
        return minLen==Integer.MAX_VALUE?0:minLen;

    }
}
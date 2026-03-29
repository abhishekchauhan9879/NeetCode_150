class Solution {
    public int maxSubArray(int[] nums) {
        int currSum=nums[0];
        int res=nums[0];
        for(int i=1;i<nums.length;i++){
            currSum=Math.max(nums[i],nums[i]+currSum);
            res=Math.max(res,currSum);
        }
        return res;
    }
}

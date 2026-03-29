class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];

        int prefix=1;// for left
        for(int i=0;i<len;i++){
            result[i]=prefix;
            prefix=prefix*nums[i];
        }

        int suffix=1;//for right
        for(int i=len-1;i>=0;i--){
            result[i]=result[i]*suffix;
            suffix=suffix*nums[i];
        }

        return result;
    }
}  

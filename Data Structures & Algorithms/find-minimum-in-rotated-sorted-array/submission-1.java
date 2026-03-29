class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int mid=0,i=0,j=n-1;
        if(n==1) return nums[0];
        while(i<=j){
            mid=i+(j-i)/2;

            if((mid==0||nums[mid]<nums[mid-1])
                &&(mid==n-1 || nums[mid]<nums[mid+1])
            ){
                return nums[mid];
            }else if(nums[mid]>nums[j]){
                i=mid+1;
            }else{
                j=mid-1;
            }
        }
        return nums[0];
    }
}

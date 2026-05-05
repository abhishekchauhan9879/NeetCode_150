class Solution {
    public int removeElement(int[] nums, int val) {
        int k=0;

        for(int x:nums){
            if(val!=x){
                nums[k]=x;
                k++;
            }
        }

        return k;
    }
}
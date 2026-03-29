class Solution {
public:
    int search(vector<int>& nums, int target) {
        int n=nums.size();
        if(n==1)    return nums[0]==target?0:-1;

        int i=0,j=n-1;

        while(i<=j){
            int mid=i+(j-i)/2;
            if(nums[mid]==target){
                return mid;
            }
            //left is sorted
            if(nums[i]<=nums[mid]){
                if(nums[i]<=target && target<nums[mid]){
                    j=mid-1;
                }else{
                    i=mid+1;
                }
            }else{
                if(nums[mid]<target && target<=nums[j]){
                    i=mid+1;
                }else{
                    j=mid-1;
                }
            }
        }
        return -1;
    }
};

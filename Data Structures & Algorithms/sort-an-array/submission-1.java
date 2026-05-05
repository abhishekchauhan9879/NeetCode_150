class Solution {
    public int[] sortArray(int[] nums) {
        int n=nums.length;
        quickSort(nums,0,n-1);
        return nums;
    }

    private void quickSort(int nums[], int low, int high){
        if(low>=high)   return;

        int pi = partition(nums, low, high);

        quickSort(nums,low,pi-1);
        quickSort(nums, pi+1,high);
    }

    private int partition(int nums[], int low, int high){
        int pivot = nums[high];

        int i=low-1;

        for(int j=low;j<high;j++){
            if(nums[j]<pivot){
                i++;
                swap(nums,i,j);
            }
        }
        swap(nums,i+1,high);
        return i+1;
    }

    private void swap(int nums[], int i, int j){
        int temp=nums[j];
        nums[j]=nums[i];
        nums[i]=temp;
    }
}
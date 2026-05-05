class Solution {
    public int[] sortArray(int[] nums) {
        int n=nums.length;
        if(n==0)    return nums;
        mergeSort(nums,0,n-1);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right){
        if(left>=right)  return;

        int mid = left+(right-left)/2;

        mergeSort(nums,left,mid);
        mergeSort(nums,mid+1,right);

        merge(nums,left,mid,right);
    }

    private void merge(int arr[], int left, int mid, int right){

        int leftArr[]=new int[mid-left+1];
        int rightArr[]=new int[right-mid];

        for(int i=0;i<leftArr.length;i++){
            leftArr[i]= arr[left+i];
        }
        for(int j=0;j<rightArr.length;j++){
            rightArr[j]= arr[mid+1+j];
        }
        int i=0, j=0, k=left;
        while(i<leftArr.length && j<rightArr.length){
            if(leftArr[i]<=rightArr[j]){
                arr[k++]=leftArr[i++];
            }else{
                arr[k++]=rightArr[j++];
            }
        }

        while(i<leftArr.length){
            arr[k++]=leftArr[i++];
        }
        while(j<rightArr.length){
            arr[k++]=rightArr[j++];
        }
    }
}
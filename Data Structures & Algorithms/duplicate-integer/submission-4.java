class Solution {
    public boolean hasDuplicate(int[] nums) {
        if(nums.length <=1){
            return false;
        }
        // case when array is sorted
        // int prevNum=nums[0];
        // for(int i=1;i<nums.length;i++){
        //     int currNum=nums[i];
        //     if(currNum == prevNum){
        //         return true;
        //     }else{
        //         prevNum=currNum;
        //     }
        // }
        //case when array is unsorted
        // Map<Integer,Integer> freq = new HashMap<>();
        // for(int x:nums){
        //     if(freq.containsKey(x)){
        //         return true;
        //     }
        //     freq.put(x,1);
        // }
        //Approach using HashSet
        HashSet<Integer> freq = new HashSet<>();
        for(int num:nums){
            if(freq.contains(num)){
                return true;
            }
            freq.add(num);
        }
        return false;
    }
}
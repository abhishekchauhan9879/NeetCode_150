class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer,Integer> myMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int toFind= target - nums[i];
            if(myMap.containsKey(toFind)){
                return new int[]{myMap.get(toFind),i};
            }
            myMap.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}

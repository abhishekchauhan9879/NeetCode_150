class Solution {
    public int subarraySum(int[] nums, int k) {
        int count=0;

        Map<Integer, Integer> myMap=new HashMap<>();
        myMap.put(0,1);
        
        int sum=0;
        for(int num:nums){
            sum+=num;

            if(myMap.containsKey(sum-k)){
                count+=myMap.getOrDefault(sum-k,0);
            }
            myMap.put(sum, myMap.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
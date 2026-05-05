class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        Map<Integer, Integer> myMap = new HashMap<>();
        for(int num:nums){
            myMap.put(num, myMap.getOrDefault(num,0)+1);
        }
        int k=n/3;
        List<Integer> res=new ArrayList<>();
        for(int num:myMap.keySet()){
            if(myMap.get(num)>k){
                res.add(num);
            }
        }
        return res;
    }
}
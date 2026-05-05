class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set mySet = new HashSet<>();

        for(int x:nums){
            if(!mySet.contains(x)){
                mySet.add(x);
            }else{

            return true;
            }
        }
        return false;
    }
}
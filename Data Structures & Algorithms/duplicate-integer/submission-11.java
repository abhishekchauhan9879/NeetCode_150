class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set mySet = new HashSet<>();

        for(int x :nums){
            if(mySet.contains(x)){
                return true;
            }
            mySet.add(x);
        }
        return false;
    }
}
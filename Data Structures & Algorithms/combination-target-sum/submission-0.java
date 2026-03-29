class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0,nums, new ArrayList<>(),result, target);
        return result;
    }

    private void backtrack(int start, int[] nums, List<Integer> current, List<List<Integer>> result, int target){
        if(target==0){
            result.add(new ArrayList<>(current));
            return;
        }     
        if (target < 0) return;
        for(int i=start;i<nums.length;i++){
            //choose
            current.add(nums[i]);
            //Explore
            backtrack(i,nums,current, result, target-nums[i]);
            //Unchose
            current.remove(current.size()-1);
        }
    }
}

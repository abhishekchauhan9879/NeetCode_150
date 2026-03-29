class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
       List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0,candidates, new ArrayList<>(),result, target);
        return result;
    }

    private void backtrack(int start, int[] nums, List<Integer> current, List<List<Integer>> result, int target){
        if(target==0){
            result.add(new ArrayList<>(current));
            return;
        }     
        if (target < 0) return;
        for(int i=start;i<nums.length;i++){
            if(i>start && nums[i]==nums[i-1]) continue;
            //choose
            current.add(nums[i]);
            //Explore
            backtrack(i+1,nums,current, result, target-nums[i]);
            //Unchose
            current.remove(current.size()-1);
        }
    }
}

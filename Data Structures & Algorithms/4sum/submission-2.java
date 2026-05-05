class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n =nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();

        for(int l=0;l<n-3;l++){
            if (l > 0 && nums[l] == nums[l - 1]) continue;
            for(int i=l+1;i<n-2;i++){
                int j=i+1;
                int k=n-1;
                if (i > l+1 && nums[i] == nums[i - 1]) continue;
                while(j<k){
                    long sum=(long)nums[i]+nums[j]+nums[k]+nums[l];
                    if(sum<target){
                        j++;
                    }else if(sum>target){
                        k--;
                    }else{
                        res.add(Arrays.asList(nums[l],nums[i],nums[j],nums[k]));
                        j++;k--;
                        //skip the duplicates
                        while(j<k && nums[j]==nums[j-1]){
                            j++;
                        }
                        while(j<k && nums[k]==nums[k+1]){
                            k--;
                        }
                    }
                }
            }
        }
        return res;
    }
}
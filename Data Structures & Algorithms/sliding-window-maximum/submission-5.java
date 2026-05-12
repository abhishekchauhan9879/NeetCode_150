class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int idx=0;
        int res[]=new int[n-k+1];
        Deque<Integer> dq = new ArrayDeque<>();

        for(int i=0;i<n;i++){
            
            if(!dq.isEmpty() && dq.peekFirst() <= i - k){
                dq.pollFirst();
            }    
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);

            if(i+1>=k){
                res[idx++]=nums[dq.peekFirst()];
            }
        }
        return res;
    }
}

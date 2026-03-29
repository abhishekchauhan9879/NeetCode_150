class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n =nums.length;

        int res[]=new int[n-k+1];
        int idx = 0;
        Deque<Integer> dq= new LinkedList<>();

        for(int i=0;i<n;i++){
            //Maintain a window
            if(!dq.isEmpty() && dq.peekFirst() <=i-k){
                dq.pollFirst();
            }

            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]){
                //make always bigger element as first and maintain a decreasing order
                dq.pollLast();
            }
            // Add the element idx in the deque
            dq.offerLast(i);

            if(i>=k-1){
                res[idx++]=nums[dq.peekFirst()];
            }
        }
        return res;
    }
}

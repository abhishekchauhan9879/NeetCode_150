class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {

        int res[]=new int[queries.length];
        int[][] queriesWithIndex = new int[queries.length][2];
        for(int i=0; i<queries.length; i++){
            queriesWithIndex[i][0] = queries[i]; // query value
            queriesWithIndex[i][1] = i;          // original index
        }
        Arrays.sort(queriesWithIndex, (a,b)->a[0]-b[0]);
        for(int q=0; q<queriesWithIndex.length; q++){
            int query = queriesWithIndex[q][0];
            int relIdx = queriesWithIndex[q][1];
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            //for current query. lets iterate through the end index and save the length of interval in minHeap
            for(int i=0;i<intervals.length;i++){
                int startInterval = intervals[i][0];
                int endInterval = intervals[i][1];
                int length = endInterval- startInterval +1;
                if(endInterval>=query && startInterval<=query){//query is there in the interval
                    minHeap.offer(length);
                }
            }

            res[relIdx]=(minHeap.isEmpty())?-1:minHeap.peek();
        }
        return res;
    }
}

class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {

        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        int res[]=new int[queries.length];
        int[][] queriesWithIndex = new int[queries.length][2];
        for(int i=0; i<queries.length; i++){
            queriesWithIndex[i][0] = queries[i]; // query value
            queriesWithIndex[i][1] = i;          // original index
        }
        Arrays.sort(queriesWithIndex, (a,b)->a[0]-b[0]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]); // [length, end]
        int i = 0; // pointer for intervals
        for(int q=0; q<queriesWithIndex.length; q++){
            int query = queriesWithIndex[q][0];
            int relIdx = queriesWithIndex[q][1];
            //for current query. lets iterate through the end index and save the length of interval in minHeap
            while (i < intervals.length && intervals[i][0] <= query) {
                int startInterval = intervals[i][0];
                int endInterval = intervals[i][1];
                int length = endInterval- startInterval +1;
                minHeap.offer(new int[]{length,endInterval});
                i++;
            }

            while (!minHeap.isEmpty() && minHeap.peek()[1] < query) {
                minHeap.poll();
            }

            res[relIdx]=(minHeap.isEmpty())?-1:minHeap.peek()[0];
        }
        return res;
    }
}

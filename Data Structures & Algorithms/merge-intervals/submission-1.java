class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int[] prev=intervals[0];

        for(int i=1;i<intervals.length;i++){

            int curr[]=intervals[i];

            //check overlapping 
            if(curr[0]>prev[1]){//not overlap
                res.add(prev);
            }
            else{ //if overlap
                curr[0]=Math.min(prev[0],curr[0]);
                curr[1]=Math.max(prev[1],curr[1]);
            }
            prev=curr;
        }
        res.add(prev);
        return res.toArray(new int[res.size()][]);
    }
}

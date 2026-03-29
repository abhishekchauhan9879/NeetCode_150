class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> res=new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            int curr[] = intervals[i];
            //let's find where we want insertion
            if(curr[1]<newInterval[0]){//not find the particular Interval keep searching and adding
                res.add(curr);
            }else if(curr[0]>newInterval[1]){//found but not overlapping
                res.add(newInterval);
                newInterval=curr;
            }else{//handle overlapping
                newInterval[0]=Math.min(newInterval[0],curr[0]);
                newInterval[1]=Math.max(newInterval[1],curr[1]);
            }
        }
        res.add(newInterval);
        return res.toArray(new int[res.size()][]);
    }
}

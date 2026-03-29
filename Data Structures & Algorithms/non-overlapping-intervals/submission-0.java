class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        int[] prev=intervals[0];
        int count=0;
        for(int i=1;i<intervals.length;i++){

            int curr[]=intervals[i];

            if(curr[0]<prev[1]){//Overlap
                count++;

                if(curr[1]<prev[1]){
                    prev=curr;//interval that ends earlier leaves more space for future intervals.
                }
            }else{
                prev=curr;
            }
        }
        return count;
    }
}

/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals == null)   return true;
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        int prevEnd=-1;

        for(Interval temp:intervals){
            if(prevEnd > temp.start){
                //conflict
                return false;
            }
            prevEnd=temp.end;
        }
        return true;
    }
}

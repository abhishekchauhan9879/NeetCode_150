class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total=0;
        int tank=0;
        int start=0;

        for(int i=0;i<gas.length;i++){
            int diff=gas[i]-cost[i];
            
            total+=diff;//track total gas - cost, if that <0 that means not feasible
            tank+=diff;

            if(tank<0){
                start=i+1;//because i+1, since if there is a station inbetween that has capacity to reach i+1, would not make the tank zero
                tank=0;
            }
        }

        return total>=0?start:-1;
    }
}

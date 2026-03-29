class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n=hand.length;

        if(n%groupSize!=0)  return false;//not possible

        //store the frequency
        Map<Integer, Integer> map = new HashMap<>();
        for(int num:hand){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        Arrays.sort(hand);//to start from smallest sequence
        for(int num:hand){

            if(map.get(num)==0){ // Continue the num which have freq already exhausted
                continue;
            }

            for(int i=0;i<groupSize;i++){

                int card = i+num;

                if(map.getOrDefault(card,0)==0){//if that sequence is not available
                    return false; // as sequence can't be met
                }
                map.put(card, map.get(card)-1);//reduce the frequency as we have already used this
            }

        }
        return true;
    }
}

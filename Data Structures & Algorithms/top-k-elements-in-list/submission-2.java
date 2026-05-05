class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //Step 1: when we know the key and its freq 
        //Using array (not optimal, as we need to make array of 2000)
        //HashMap(for count of frequency)

        Map<Integer, Integer> myMap = new HashMap<>();
        for(int num:nums){
            myMap.put(num, myMap.getOrDefault(num,0)+1);
        }

        //Step 2 : Most frequent
        // We can use priorityQueue and will sort by map.value which have count of freq
        PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)->(myMap.get(a)-myMap.get(b)));
        
        for(int num:myMap.keySet()){
            pq.offer(num);
            if(pq.size()>k){
                pq.poll();
            }
        }

        int res[]= new int[k];
        for(int i=0;i<k;i++){
            res[i]=pq.poll();
        }
        return res;
    }
}

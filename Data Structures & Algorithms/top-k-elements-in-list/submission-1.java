class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> myMap = new HashMap<>();

        for(int num:nums){
            myMap.put(num, myMap.getOrDefault(num,0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(myMap.get(a)-myMap.get(b)));

        for(int num:myMap.keySet()){
            pq.offer(num);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[] result = new int[k];
        for(int i=k-1;i>=0;i--){
            result[i]=pq.poll();
        }
        return result;
    }
}

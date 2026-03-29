class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int stone:stones){
            maxHeap.offer(stone);
        }

        while(maxHeap.size()>1){
            int firstElem = maxHeap.poll();
            int secElem=maxHeap.poll();
            if(firstElem!=secElem){
                maxHeap.offer(firstElem - secElem);
            }
        }
        return maxHeap.isEmpty()?0:maxHeap.peek();
    }
}

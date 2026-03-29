class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> graph=new ArrayList<>();

        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int f[]:flights){
            graph.get(f[0]).add(new int[]{f[1],f[2]});
        }

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        //cost,src,k
        pq.offer(new int[]{0,src,0});

        while(!pq.isEmpty()){
            int curr[]=pq.poll();
            int cost=curr[0];
            int node=curr[1];
            int stops=curr[2];

            if(node==dst)    return cost;
            if(stops>k)     continue;

            for(int neigh[]:graph.get(node)){
                int nextNode=neigh[0];
                int price=neigh[1];
                pq.offer(new int[]{price+cost,nextNode,stops+1});
            }
        }
        return -1;
    }
}

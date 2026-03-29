class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();

        for(int i=0;i<=n;i++){//Initialise graph
            graph.add(i,new ArrayList<>());
        }

        for(int []edge:times){
            graph.get(edge[0]).add(new int[]{edge[1],edge[2]});
        }

        int[] dist=new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k]=0;//self distance is 0

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{0,k});

        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int currDist = curr[0];
            int node = curr[1];

            if(currDist>dist[node]) continue;

            for(int neigh[]:graph.get(node)){
                int newNode=neigh[0];
                int weight=neigh[1];

                if(dist[newNode]>currDist+weight){
                    dist[newNode]=currDist+weight;
                    pq.offer(new int[]{dist[newNode],newNode});
                }
            }
        }
        int res=-1;
        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE)  return -1;
            res=Math.max(res,dist[i]);
        }
        return res;
    }
}

class Solution {
    public int countComponents(int n, int[][] edges) {
        int parent[]=new int[n];

        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        int count=n;
        for(int []edge:edges){
            int x=find(parent,edge[0]);
            int y=find(parent,edge[1]);

            if(x != y){          // only if they are in different components
                parent[x] = y;   // union
                count--;         // components reduced
            }
        }
        return count;
    }

    private int find(int[] parent, int x){
        if(parent[x]!=x){
            parent[x]=find(parent,parent[x]);
        }
        return parent[x];
    }
}

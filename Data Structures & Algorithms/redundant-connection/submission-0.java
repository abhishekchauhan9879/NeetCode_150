class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        int parent[] = new int[n+1];

        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        int result[]=new int[2];
        for(int []edge:edges){
            int x=find(parent,edge[0]);
            int y=find(parent,edge[1]);

            if(x==y){
                result=edge;
            }else{
                parent[x]=y;
            }
        }
        return result;
    }

    private int find(int parent[],int x){
        if(parent[x]!=x){
            parent[x]=find(parent,parent[x]);
        }
        return parent[x];
    }
}

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //Build graph
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for(int pre[]:prerequisites){
            int course=pre[0];
            int prereq=pre[1];
            graph.get(prereq).add(course);
            indegree[course]++;
        }
        //Start with indegree 0
        Queue<Integer> queue=new LinkedList<>();
        for(int course=0;course<numCourses;course++){
            if(indegree[course]==0){
                queue.offer(course);//1
            }
        }
        int result[]=new int[numCourses];
        int count=0;
        while(!queue.isEmpty()){
            int course=queue.poll();//Start with the course with 1 prereq
            result[count]=course;
            count++;
            for(int neigh:graph.get(course)){//
                indegree[neigh]--;
                if(indegree[neigh]==0){
                    queue.offer(neigh);
                }
            }
        }
        return (count==numCourses)? result:new int[0];
    }
}

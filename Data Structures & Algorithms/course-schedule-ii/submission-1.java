class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjList = new ArrayList[numCourses];
        Queue<Integer> q = new LinkedList<>();
        int indegree[] = new int[numCourses];
        for(int i = 0;i<numCourses;i++){
            adjList[i] = new ArrayList<>();
        }
        for(int arr[] : prerequisites){
            adjList[arr[1]].add(arr[0]);
            indegree[arr[0]]++;
        }
        for(int i = 0;i<indegree.length;i++){
            if(indegree[i]==0) q.offer(i);
        }
        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            int key = q.poll();
            res.add(key);
            for(int i = 0;i<adjList[key].size();i++){
                indegree[adjList[key].get(i)]--;
                if(indegree[adjList[key].get(i)]==0){
                    q.offer(adjList[key].get(i));
                }
            }
        }
        if(res.size()!= numCourses) return new int[0];
        int arr[] = new int[res.size()];
        for(int i = 0;i<res.size();i++){
            arr[i] = res.get(i);
        }
        
        return arr;
    }
}

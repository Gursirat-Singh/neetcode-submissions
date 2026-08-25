class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjList = new List[numCourses];
        int indegree[] = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int arr[] : prerequisites) {
            adjList[arr[1]].add(arr[0]);
            indegree[arr[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }
        int processed = 0;
        while (!q.isEmpty()) {
            int key = q.poll();
            processed++;
            for (int i = 0; i < adjList[key].size(); i++) {
                indegree[adjList[key].get(i)]--;
                if (indegree[adjList[key].get(i)] == 0) {
                    q.offer(adjList[key].get(i));
                }
            }
        }
        return processed == numCourses;
    }
}

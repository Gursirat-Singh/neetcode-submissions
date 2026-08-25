class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1)
            return false;
        if (edges.length == 0 && n == 1)
            return true;
        List<Integer> adjList[] = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int arr[] : edges) {
            adjList[arr[0]].add(arr[1]);
            adjList[arr[1]].add(arr[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(edges[0][0]);
        int node = 0;
        boolean visited[] = new boolean[n];
        visited[edges[0][0]] = true;
        while (!q.isEmpty()) {
            int key = q.poll();
            for (int i = 0; i < adjList[key].size(); i++) {
                int temp = adjList[key].get(i);
                if (!visited[temp]) {
                    q.offer(temp);
                    visited[temp] = true;
                    node++;
                }
            }
        }
        return node == n - 1;
    }
}

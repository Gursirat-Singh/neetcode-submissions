class Solution {
    public int countComponents(int n, int[][] edges) {
        List<Integer> adjList[] = new ArrayList[n];
        boolean visited[] = new boolean[n];
        for(int i = 0;i<n;i++){
            adjList[i] = new ArrayList<>();
        }
        for(int arr[] : edges){
            adjList[arr[0]].add(arr[1]);
            adjList[arr[1]].add(arr[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for(int i = 0;i<n;i++){
            if(!visited[i]){
                q.offer(i);
                visited[i] = true;
                count++;
                while(!q.isEmpty()){
                    int key = q.poll();
                    for(int j = 0;j<adjList[key].size();j++){
                        int temp = adjList[key].get(j);
                        if(!visited[temp]){
                            visited[temp] = true;
                            q.offer(temp);
                        }
                    }
                }
            }
        }
        return count;
    }
}

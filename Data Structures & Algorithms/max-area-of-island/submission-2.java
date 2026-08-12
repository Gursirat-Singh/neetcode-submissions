class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int max = 0;
        int n = grid.length;
        int m = grid[0].length;
        boolean visited[][] = new boolean[n][m];
        int dir[][] = {
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
        };
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(visited[i][j] || grid[i][j]==0)continue;
                int count = 1;
                visited[i][j]=true;
                queue.offer(new int[]{i,j});
                while(!queue.isEmpty()){
                    int temp[] = queue.poll();
                    int r = temp[0];
                    int c = temp[1];
                    for(int d[] : dir){
                        int nr = r - d[0];
                        int nc = c - d[1];
                        if(nr>=0 && nr<n && nc>=0 && nc<m && !visited[nr][nc] && grid[nr][nc]==1){
                            count++;
                            queue.offer(new int[]{nr,nc});
                            visited[nr][nc] = true;
                        }
                    }
                    max = Math.max(max,count);
                }
            }
        }
        return max;
    }
}

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean visited[][] = new boolean[n][m];
        int max = 0;
        int dir[][] = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
        };
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] || grid[i][j] == 0)
                    continue;
                visited[i][j] = true;
                int curr = dfs(visited, i, j, n, m,dir,grid);
                max = Math.max(curr, max);
            }
        }
        return max;
    }
    private int dfs(boolean visited[][],int r,int c,int n,int m,int[][] dir,int grid[][]){
        int curr = 1;
        for(int d[] : dir){
            int nr = r + d[0];
            int nc = c + d[1];
            if(nr>=0 && nr<n && nc>=0 && nc<m && !visited[nr][nc] && grid[nr][nc]==1){
                visited[nr][nc] = true;
                curr += dfs(visited,nr,nc,n,m,dir,grid);
            }
        }
        return curr;
    }
}

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j]==1){
                    max = Math.max(max,dfs(i, j, n, m,grid));
                }
            }
        }
        return max;
    }
    private int dfs(int r,int c,int n,int m,int grid[][]){
        int curr = 1;
        if(r<0 || r>n-1 || c<0 || c>m-1 || grid[r][c]==0)return 0;
        grid[r][c] = 0;
        curr += dfs(r-1,c,n,m,grid);
        curr += dfs(r+1,c,n,m,grid);
        curr += dfs(r,c-1,n,m,grid);
        curr += dfs(r,c+1,n,m,grid);
        return curr;
    }
}

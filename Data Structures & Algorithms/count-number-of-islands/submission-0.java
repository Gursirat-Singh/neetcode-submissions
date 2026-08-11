class Solution {
    public int numIslands(char[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        boolean valid[][] = new boolean[n][m];
        int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (valid[i][j] || grid[i][j] == '0')
                    continue;
                valid[i][j] = true;
                count++;
                queue.offer(new int[] {i, j});
                while (!queue.isEmpty()) {
                    int arr[] = queue.poll();
                    int col = arr[1];
                    int row = arr[0];
                    for (int d[] : dir) {
                        int nrow = row + d[0];
                        int ncol = col + d[1];
                        if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                            && grid[nrow][ncol] == '1' && !valid[nrow][ncol]) {
                            queue.offer(new int[] {nrow, ncol});
                            valid[nrow][ncol] = true;
                        }
                    }
                }
            }
        }
        return count;
    }
}

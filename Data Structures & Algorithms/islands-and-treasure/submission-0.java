class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int max = Integer.MAX_VALUE;
        int n = grid.length;
        int m = grid[0].length;
        boolean visited[][] = new boolean[n][m];
        int dir[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    q.offer(new int[] {i, j});
                    visited[i][j] = true;
                }
            }
        }
        visited = new boolean[n][m];
        while (!q.isEmpty()) {
            int arr[] = q.poll();
            int r = arr[0];
            int c = arr[1];
            visited[r][c] = true;
            for (int d[] : dir) {
                int nr = r - d[0];
                int nc = c - d[1];
                if (nr < 0 || nr > n - 1 || nc < 0 || nc > m - 1 || visited[nr][nc]
                    || grid[nr][nc] == -1) {
                    continue;
                } else if (grid[nr][nc] == max) {
                    grid[nr][nc] = grid[r][c]+1;
                }
                visited[nr][nc] = true;
                q.offer(new int[] {nr, nc});
            }
        }
    }
}

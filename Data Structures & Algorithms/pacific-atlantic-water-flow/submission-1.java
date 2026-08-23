class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Queue<int[]> q1 = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();
        int n = heights.length;
        int m = heights[0].length;
        boolean pacific[][] = new boolean[n][m];
        boolean atlantic[][] = new boolean[n][m];
        int dir[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    q1.offer(new int[] {i, j});
                    pacific[i][j] = true;
                }
                if (i == n - 1 || j == m - 1) {
                    q2.offer(new int[] {i, j});
                    atlantic[i][j] = true;
                }
            }
        }

        while (!q1.isEmpty()) {
            int p[] = q1.poll();
            int r = p[0];
            int c = p[1];
            for (int d[] : dir) {
                int nr = r - d[0];
                int nc = c - d[1];
                if (nr > n - 1 || nr < 0 || nc > m - 1 || nc < 0 || heights[nr][nc] < heights[r][c]
                    || pacific[nr][nc])
                    continue;
                q1.offer(new int[] {nr, nc});
                pacific[nr][nc] = true;
            }
        }
        while (!q2.isEmpty()) {
            int p[] = q2.poll();
            int r = p[0];
            int c = p[1];
            for (int d[] : dir) {
                int nr = r - d[0];
                int nc = c - d[1];
                if (nr > n - 1 || nr < 0 || nc > m - 1 || nc < 0 || heights[nr][nc] < heights[r][c]
                    || atlantic[nr][nc])
                    continue;
                q2.offer(new int[] {nr, nc});
                atlantic[nr][nc] = true;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }
}

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        List<List<Integer>> res = new ArrayList<>();
        int m = heights[0].length;
        int dir[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                boolean pacific = false, atlantic = false;
                Queue<int[]> queue = new LinkedList<>();
                boolean visited[][] = new boolean[n][m];
                visited[i][j] = true;
                queue.offer(new int[] {i, j, heights[i][j]});
                while (!queue.isEmpty()) {
                    int arr[] = queue.poll();
                    int r = arr[0];
                    int c = arr[1];
                    int val = arr[2];
                    if(r==0 || c == 0) pacific = true;
                    if(r==n-1 || c == m-1) atlantic = true;
                    for (int d[] : dir) {
                        int nr = r - d[0];
                        int nc = c - d[1];
                        if (nr < 0 || nr > n - 1 || nc < 0 || nc > m - 1 || val < heights[nr][nc])
                            continue;
                        else if (nr == 0 || nc == 0)
                            pacific = true;
                        else if (nc == m - 1 || nr == n - 1)
                            atlantic = true;
                        if (!visited[nr][nc]) {
                            queue.offer(new int[] {nr, nc, heights[nr][nc]});
                            visited[nr][nc] = true;
                        }
                    }
                }
                if (pacific && atlantic) {
                    res.add(new ArrayList<>(List.of(i, j)));
                }
            }
        }
        return res;
    }
}

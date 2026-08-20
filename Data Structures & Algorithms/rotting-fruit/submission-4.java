class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int dir[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int fr = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                }else if(grid[i][j]==1)fr++;
            }
        }
        int count = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int arr[] = queue.poll();
                int r = arr[0];
                int c = arr[1];
                for (int d[] : dir) {
                    int nr = r + d[0];
                    int nc = c + d[1];
                    if (nr > n - 1 || nr < 0 || nc > m - 1 || nc < 0 || grid[nr][nc] != 1){
                                            continue;
                    }
                    grid[nr][nc] = 2;
                    fr--;
                    queue.offer(new int[] {nr, nc});
                }
            }
            count++;
        }
        if(fr>0)return -1;
        return Math.max(count,0);
    }
}

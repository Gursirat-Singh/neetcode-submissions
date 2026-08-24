class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        Queue<int[]> q = new LinkedList<>();
        int dir[][] = {
            {1,0},
            {0,1},
            {-1,0},
            {0,-1}
        };
        boolean visited[][] = new boolean[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(i == 0 || i== n-1 || j==m-1 || j==0){
                    if(board[i][j] == 'O'){
                        board[i][j] = '#';
                        q.offer(new int[]{i,j});
                    } 
                }
            }
        }
        while(!q.isEmpty()){
            int arr[] = q.poll();
            int r = arr[0];
            int c = arr[1];
            for(int d[] : dir){
                int nr = r + d[0];
                int nc = c + d[1];
                if(nr>n-1 || nr<0 || nc>m-1 || nc<0 || visited[nr][nc] || board[nr][nc]!='O')continue;
                board[nr][nc] = '#';
                visited[nr][nc] = true;
                q.offer(new int[]{nr,nc});
            }
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(board[i][j]!='#'){
                    board[i][j] = 'X';
                }else{
                    board[i][j] = 'O';
                }
            }
        }
    }
}

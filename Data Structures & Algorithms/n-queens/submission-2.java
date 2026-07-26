class Solution {
    boolean[] cols;
    boolean[] diag1;
    boolean[] diag2;
    public List<List<String>> solveNQueens(int n) {
        cols = new boolean[n];
        diag1 = new boolean[2 * n - 1];
        diag2 = new boolean[2 * n - 1];
        Arrays.fill(cols,false);
        Arrays.fill(diag1,false);
        Arrays.fill(diag2,false);
        char board[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        helper(res, board, 0, n);
        return res;
    }
    private void helper(List<List<String>> res, char board[][], int row, int n) {
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(new String(board[i]));
            }
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isSafe(board, row, i, n)) {
                board[row][i] = 'Q';
                cols[i]=true;
                diag1[row-i+n-1]=true;
                diag2[row+i]=true;
                helper(res, board, row + 1, n);
                board[row][i] = '.';
                cols[i]=false;
                diag1[row-i+n-1]=false;
                diag2[row+i]=false;
            }
        }
    }
    private boolean isSafe(char board[][], int row, int col, int n) {
        if(cols[col] || diag1[row-col+n-1] || diag2[row+col])return false;
        return true;
    }
}

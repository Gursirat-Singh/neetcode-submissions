class Solution {
    public List<List<String>> solveNQueens(int n) {
        char board[][] = new char[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                board[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        helper(res,board,0,n);
        return res;
    }
    private void helper(List<List<String>> res,char board[][],int row,int n){
        if(row==n){
            List<String> list = new ArrayList<>();
            for(int i = 0;i<n;i++){
                list.add(new String(board[i]));
            }
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0;i<n;i++){
            if(isSafe(board,row,i,n)){
                board[row][i] = 'Q';
                helper(res,board,row+1,n);
                board[row][i] = '.';
            }
        }
    }
    private boolean isSafe(char board[][],int row,int col,int n){
        //upper row
        int i = row-1;
        while(i>=0){
            if (board[i][col]=='Q') return false;
            i--;
        }
        //upper right diagnol
        i = row-1;
        int j = col-1;
        while(i>=0 && j>=0){
            if(board[i][j]=='Q')return false;
            i--;
            j--;
        }
        // upper left diagnol
        i = row-1;
        j = col+1;
        while(i>=0 && j<n){
            if(board[i][j]=='Q')return false;
            i--;
            j++;
        }
        return true;
    }
}

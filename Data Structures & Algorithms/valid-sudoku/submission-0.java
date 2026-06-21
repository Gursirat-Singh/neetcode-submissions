class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Integer> rows[] = new HashSet[9];
        HashSet<Integer> columns[] = new HashSet[9];
        HashSet<Integer> box[] = new HashSet[9];
        for(int i = 0;i<9;i++){
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            box[i] = new HashSet<>();
        }
        for(int i = 0;i<9;i++){
            for(int j = 0;j<9;j++){
                if(board[i][j]=='.') continue;
                int num = board[i][j];
                int boxidx = (i/3)*3+j/3;
                if(rows[i].contains(num) || columns[j].contains(num)|| box[boxidx].contains(num))return false;
                rows[i].add(num);
                columns[j].add(num);
                box[boxidx].add(num);
            }
        }
        return true;
    }
}

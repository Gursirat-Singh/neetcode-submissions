class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (helper(board, word, i, j, 0, '0')) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean helper(
        char[][] board, String word, int row, int col, int index, char temp) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }

        if (board[row][col]=='#') {
            return false;
        }

        if (board[row][col] != word.charAt(index)) {
            return false;
        }

        if (index == word.length() - 1) {
            return true;
        }
        temp = board[row][col];
        board[row][col] = '#';

        boolean found = helper(board, word, row + 1, col, index + 1, temp)
            || helper(board, word, row - 1, col, index + 1, temp)
            || helper(board, word, row, col + 1, index + 1, temp)
            || helper(board, word, row, col - 1, index + 1, temp);

        board[row][col] = temp;

        return found;
    }
}
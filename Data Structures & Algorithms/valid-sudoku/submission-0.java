class Solution {
    public boolean isValidSudoku(char[][] board) {
      //  Map<Integer, Set<Integer>> rows = new HashMap();
       // Map<Integer, Set<Integer>> cols = new HashMap();


        for(int r=0; r<9; r++) {
            Set<Character> cols = new HashSet();
            for(int c=0; c<9; c++) {
                if(board[r][c]=='.')
                    continue;
                if(cols.contains(board[r][c]))
                    return false;
                cols.add(board[r][c]);
            }
        }

        for(int c=0; c<9; c++) {
            Set<Character> rows = new HashSet();
            for(int r=0; r<9; r++) {
                if(board[r][c]=='.')
                    continue;
                if(rows.contains(board[r][c]))
                    return false;
                rows.add(board[r][c]);
            }
        }


        Set<Character> grid = new HashSet();
        int r_incr = 0;
        int c_incr = 0;
        for(int k=0; k<9; k++) {
            for(int r=r_incr; r<3+r_incr && r<9; r++) {
                for(int c=c_incr; c<3+c_incr && c<9; c++) {
                    if(board[r][c]=='.')
                        continue;
                    if(grid.contains(board[r][c]))
                        return false;
                    grid.add(board[r][c]);
                }
            }
            c_incr += 3;
            grid.clear();
            if(c_incr==9) {
                c_incr = 0;
                r_incr += 3; 
            }
        }
        return true;
    }
}

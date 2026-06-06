class Solution {
    int[][] board;
    int n, m;
    int[] dir = {-1, 1, 0, 0}, dic = {0, 0, -1, 1};
    public int[] DFS(int my_r, int my_c, int you_r, int you_c) {
        if(board[my_r][my_c] == 0) {
            return new int[]{0, 0};
        }
        int rstwin = Integer.MAX_VALUE;
        int rstlose = 0;
        boolean move = false, win = false;
        
        for(int i = 0; i < 4; i++) {
            int n_my_r = my_r + dir[i];
            int n_my_c = my_c + dic[i];
            
            if(n_my_r < 0 || n_my_r >= n || n_my_c < 0 || n_my_c >= m) continue;
            if(board[n_my_r][n_my_c] == 0) continue;
            
            move = true;
            
            board[my_r][my_c] = 0;
            int[] result = DFS(you_r, you_c, n_my_r, n_my_c);
            board[my_r][my_c] = 1;
            
            if(result[0] == 0) { //상대가 졌음
                win = true;
                rstwin = Math.min(rstwin, result[1] + 1);
            }
            else rstlose = Math.max(rstlose, result[1] + 1);
        }
        if(!move) return new int[]{0, 0};
        if(win) return new int[]{1, rstwin};
        return new int[]{0, rstlose};
    }
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        this.board = board;
        n = board.length;
        m = board[0].length;
        
        return DFS(aloc[0], aloc[1], bloc[0], bloc[1])[1];
    }
}
import java.util.*;
class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        boolean[][] win = new boolean[n+1][n+1];
        for(int[] result : results) win[result[0]][result[1]] = true;
        
        for(int m = 1; m <= n; m++) {
            for(int s = 1; s <= n; s++) {
                for(int e = 1; e <= n; e++) {
                    if(win[s][m] && win[m][e]) win[s][e] = true;
                }
            }
        }
        
        int[] cnt = new int[n+1];
        for(int i = 1; i <= n; i++) {
            for(int j = i+1; j <= n; j++) {
                if(win[i][j] || win[j][i]) {
                    cnt[i]++;
                    cnt[j]++;
                }
            }
        }
        for(int i : cnt) if(i == n-1) answer++;
        return answer;
    }
}
import java.util.*;
class Solution {
    int n;
    int answer = 0;
    boolean[] used;
    boolean[][] visited;
    public void Queen(int rst) {
        if(rst == n) {
            answer++;
            return;
        }
        for(int i = 0; i < n; i++) {
            if(used[i]) continue;
            boolean valid = true;
            for(int t = 1; t <= rst; t++) {
                int left = i - t;
                int right = i + t;
                if((left >= 0 && visited[rst-t][left]) || (right < n && visited[rst-t][right]))
                    valid = false;
            }
            if(!valid) continue;
            used[i] = true;
            visited[rst][i] = true;
            Queen(rst + 1);
            visited[rst][i] = false;
            used[i] = false;
        }
    }
    public int solution(int n) {
        this.n = n;
        used = new boolean[n];
        visited = new boolean[n][n];
        
        for(int i = 0; i < n; i++) {
            used[i] = true;
            visited[0][i] = true;
            Queen(1);
            visited[0][i] = false;
            used[i] = false;
        }
        return answer;
    }
}
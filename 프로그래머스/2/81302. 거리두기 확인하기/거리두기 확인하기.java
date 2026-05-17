import java.util.*;

class Solution {
    char[][] place;
    int n, m;
    int[] dir = {-1, 0, 1, 0, -1, 1, 1, -1};
    int[] dic = {0, 1, 0, -1, 1, 1, -1, -1}; 
    public boolean Find(int sr, int sc) {
        boolean[] partition = new boolean[4];
        for(int i = 0; i < 4; i++) {
            int nr = sr + dir[i];
            int nc = sc + dic[i];
            
            if(nr >= n || nr < 0 || nc >= m || nc < 0) continue;
            
            if(place[nr][nc] == 'P') return false;
            else if(place[nr][nc] == 'X') partition[i] = true;
        }
        for(int i = 0; i < 4; i++) {
            int nr = sr + dir[i] * 2;
            int nc = sc + dic[i] * 2;
            
            if(nr >= n || nr < 0 || nc >= m || nc < 0) continue;
            
            if(place[nr][nc] == 'P') {
                if(!partition[i]) return false;
            }
        }
        for(int i = 4; i < 8; i++) {
            int nr = sr + dir[i];
            int nc = sc + dic[i];
            
            if(nr >= n || nr < 0 || nc >= m || nc < 0) continue;
            
            if(place[nr][nc] == 'P') {
                if(!partition[i % 4] || !partition[(i + 1) % 4]) return false; 
            }
        }
        return true;
        
    }
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int p = 0; p < places.length; p++) {
            String[] str = places[p];
            n = str.length;
            m = str[0].length();
            place = new char[n][m];
            
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) place[i][j] = str[i].charAt(j);
            }
            boolean valid = true;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(place[i][j] == 'P') {
                        valid = Find(i, j);
                        if(!valid) {
                            break;
                        }
                    }
                }
                if(!valid) break;
            }
            answer[p] = valid ? 1 : 0;
        }
        return answer;
    }
}
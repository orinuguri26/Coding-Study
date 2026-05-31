import java.util.*;
class Solution {
    //0 -> 앞면, 검은색 / 1 -> 뒷면, 흰색
    int[][] target, beginning;
    boolean[] rflip;
    int n, m;
    int cnt = 0;
    public boolean cflip() {
        boolean go = true;
        for(int i = 0; i < m; i++) {
            boolean valid = true;
            go = true;
            for(int j = 0; j < n; j++) {
                int cur = rflip[j] ? (beginning[j][i] + 1) % 2 : beginning[j][i];
                if(j == 0 && cur != target[0][i]) {
                    valid = false; //열 뒤집을 거임
                    cnt++;
                }
                if(valid != (cur == target[j][i])) go = false;
                //valid가 true(안뒤집) cur과 target이 같아야함
                //valid가 false(뒤집) cur과 target이 달라야함
            }
            if(!go) return go;
        }
        return go;
    }
    public int solution(int[][] beginning, int[][] target) {
        this.beginning = beginning;
        this.target = target;
        n = beginning.length;
        m = beginning[0].length;
        int answer = Integer.MAX_VALUE;
        
        for(int t = 0; t < 2; t++) {
            cnt = 0;
            rflip = new boolean[n];
            for(int i = 0; i < n; i++) { 
                if((beginning[i][0] + t) % 2 != target[i][0]) {
                    rflip[i] = true;
                    cnt++;
                }
            }
            if(cflip()) answer = Math.min(answer, cnt);
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}
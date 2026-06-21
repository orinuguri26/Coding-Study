import java.util.*;
class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        
        int wan_work = scores[0][0], wan_co = scores[0][1];
        int wan_sum = wan_work + wan_co;
        
        Arrays.sort(scores, (a,b) -> {
            if(a[0] == b[0]) return a[1]-b[1];
            return b[0] - a[0];
        });
        
        int co_score = scores[0][1];
        for(int[] score : scores) {
            if(co_score > score[1]) {
                if(wan_work == score[0] && wan_co == score[1]) return -1;
                continue;
            }
            co_score = Math.max(co_score, score[1]);
            if(score[0] + score[1] > wan_sum) answer++;
        }
        return answer;
    }
}
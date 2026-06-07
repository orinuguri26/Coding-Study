import java.util.*;
class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int len = 2 * w + 1;
        
        int start = 1;
        for(int s : stations) {
            int left = s - w;
            if (start < left) answer += ((left - start) + len - 1) / len;
            start = s + w + 1;
        }

        if(start <= n)
        answer += ((n-start+1) + (len - 1)) / len;
        return answer;
    }      
}
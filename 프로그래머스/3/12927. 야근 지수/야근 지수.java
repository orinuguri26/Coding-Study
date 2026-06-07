import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int w : works) pq.offer(w);
        
        for(int i = 0; i < n; i++) {
            int tmp = pq.poll();
            if(tmp == 0) break;
            pq.offer(tmp - 1);
        }
    
        
        while(!pq.isEmpty()) {
            int tmp = pq.poll();
            answer += tmp * tmp;
        }
        return answer;
    }
}
import java.io.*;
import java.util.*;
import java.lang.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        boolean[] have = new boolean[n+1];
        Arrays.fill(have, true);
        
        ArrayList<Integer> reserve2 = new ArrayList<>();
        
        for(int i : lost) have[i] = false;
        for(int i : reserve) {
            if(!have[i]) {
                have[i] = true;
                continue;
            }
            reserve2.add(i);
        }
        Collections.sort(reserve2);
        
        for(int i : reserve2) {
            if(i != 1 && !have[i-1]) have[i-1] = true;
            else if(i != n && !have[i+1]) have[i+1] = true;
        }
        
        int answer = 0;
        for(int i = 1; i <= n; i++) if(have[i]) answer++;

        return answer;
    }
}
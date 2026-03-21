import java.io.*;
import java.util.*;
import java.lang.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (a, b) -> Integer.compare(a[1], b[1]));
        
        int answer = 0;
        int end = -1;
        for(int[] i : targets) {
            if(i[0] >= end) {
                answer++;
                end = i[1];
            }
        }
        return answer;
    }
}
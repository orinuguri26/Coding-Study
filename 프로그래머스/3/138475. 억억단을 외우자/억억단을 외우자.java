class Solution {
    public int[] solution(int e, int[] starts) {
        int[] yaksoo = new int[e+1];
        int[] dp = new int[e+1];
        int[] answer = new int[starts.length];
        
        for(int i = 1; i <= e; i++) {
            for(int j = i; j <= e; j += i) yaksoo[j]++;
        }
        dp[e] = e;
        for(int i = e-1; i > 0; i--) {
            dp[i] = dp[i+1];
            if(yaksoo[i] >= yaksoo[dp[i+1]]) dp[i] = i;
        }
        for(int i = 0; i < starts.length; i++) answer[i] = dp[starts[i]];

        return answer;
    }
}
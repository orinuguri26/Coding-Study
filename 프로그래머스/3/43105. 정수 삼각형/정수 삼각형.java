class Solution {
    int[][] dp;
    int len;
    public int solution(int[][] triangle) {
        int answer = -1;
        len = triangle.length;
        dp = new int[len][len];
        
        dp[0][0] = triangle[0][0];
        for(int i = 1; i < len; i++) {
            dp[i][0] = dp[i-1][0] + triangle[i][0];
            dp[i][i] = dp[i-1][i-1] + triangle[i][i];
            for(int j = 1; j < i; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
            }
        }
        for(int i : dp[len-1]) answer = Math.max(answer, i);
        return answer;
    }
}
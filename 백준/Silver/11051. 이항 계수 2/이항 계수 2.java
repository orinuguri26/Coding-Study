import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    //11051번 이항 계수2
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, K;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N+1][N+1];
        for(int i = 0; i <= N; i++) {
            dp[i][0] = dp[i][i] = 1;
            for(int j = 1; j < i; j++) {
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % 10007;
            }
        }
        System.out.print(dp[N][K]);
    }
}

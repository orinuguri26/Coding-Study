import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    //11048번 이동하기
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[][] maze;
    static int Max = -1;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new int[N+1][M+1];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++) maze[i][j] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[N+1][M+1];
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++)
                dp[i][j] = maze[i][j] + Math.max(Math.max(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]);
        }
        System.out.print(dp[N][M]);
    }
}

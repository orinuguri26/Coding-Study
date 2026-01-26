import java.io.*;
import java.util.*;
import java.lang.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] dp = new int[11][11];

        for(int i = 0; i <= N; i++)
        {
            dp[i][0] = dp[i][i] = 1;
            for(int j = 1; j < i; j++) dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
        }
        System.out.println(dp[N][K]);
    }
}
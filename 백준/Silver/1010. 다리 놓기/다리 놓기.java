import java.io.*;
import java.util.*;
import java.lang.*;

public class Main
{
    //1010번 다리 놓기
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[][] dp = new int[30][30];
        for(int i = 1; i < 30; i++)
        {
            dp[i][i] = 1;
            dp[i][1] = i;
            for(int j = 2; j <= i-1; j++) dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
        }
        
        int T = Integer.parseInt(br.readLine());
        while(T-->0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            sb.append(dp[M][N]).append('\n');
        }
        System.out.print(sb);
    }
}
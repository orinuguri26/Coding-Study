import java.io.*;
import java.util.*;
import java.lang.*;

public class Main
{
    //2775 부녀회장이 될테야
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[][] dp = new int[16][15];
        for(int i = 0; i < 15; i++)
        {
            dp[i][1] = 1;
            for(int j = 2; j <= 14; j++)
            {
                if(i == 0)
                {
                    dp[i][j] = j;
                    continue;
                }
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        while(T-->0)
        {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            sb.append(dp[k][n]).append('\n');
        }
        System.out.print(sb);
    }
}
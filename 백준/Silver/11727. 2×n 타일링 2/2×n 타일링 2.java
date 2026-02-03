import java.io.*;
import java.util.*;
import java.lang.*;

public class Main
{
    //11727번 2xn 타일링 2
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 3;
        for(int i = 3; i <= N; i++) dp[i] = (dp[i-1] + dp[i-2] * 2) % 10007;

        System.out.print(dp[N]);
    }
}
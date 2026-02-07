import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    //1904번 01타일
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        dp[0] = dp[1] = 1;
        for(int i = 2; i <= N; i++) dp[i] = (dp[i-2] + dp[i-1]) % 15746;
        System.out.print(dp[N]);
    }
}

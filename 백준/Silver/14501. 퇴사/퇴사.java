import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    //14501번 퇴사
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[17];
        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int Ti = Integer.parseInt(st.nextToken());
            int Pi = Integer.parseInt(st.nextToken());

            dp[i+1] = Math.max(dp[i], dp[i+1]);
            if(i + Ti > N+1) continue;
            dp[i+Ti] = Math.max(dp[i] + Pi, dp[i+Ti]);

        }
        int rst = 0;
        for(int i : dp) rst = Math.max(rst, i);
        System.out.print(rst);
    }
}

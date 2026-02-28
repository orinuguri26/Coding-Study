import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    //11722번 가장 긴 감소하는 부분 수열
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) num[i] = Integer.parseInt(st.nextToken());
        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < i; j++) {
                if(num[j] > num[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        int rst = 0;
        for(int i : dp) rst = Math.max(rst, i);
        System.out.print(rst);
    }
}

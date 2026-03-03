import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.function.IntUnaryOperator;

public class Main {
    //9184번 신나는 함수 실행
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[][][] dp = new int[21][21][21];
    static public int W(int a, int b, int c) {
        if(a <= 0 || b <= 0 || c <= 0) return 1;
        if(a > 20 || b > 20 || c > 20) return W(20, 20, 20);

        if(dp[a][b][c] != 0) return dp[a][b][c];

        if(a < b && b < c) dp[a][b][c] =  W(a, b, c-1) + W(a, b-1, c-1) - W(a, b-1, c);
        else dp[a][b][c] =  W(a-1, b, c) + W(a-1, b-1, c) + W(a-1, b, c-1) - W(a-1, b-1, c-1);
        return dp[a][b][c];
    }
    public static void main(String[] args) throws IOException {
        while(true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == -1 && b == -1 && c == -1) break;
            sb.append("w(")
                    .append(a).append(", ")
                    .append(b).append(", ")
                    .append(c).append(") = ")
                    .append(W(a, b, c))
                    .append("\n");
        }
        System.out.print(sb);
    }
}

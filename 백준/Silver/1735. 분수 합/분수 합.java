import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    //1735번 분수 합
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int gcd(int A, int B) {
        int a = A, b = B, r;
        while(b > 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int A1 = Integer.parseInt(st.nextToken());
        int B1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int A2 = Integer.parseInt(st.nextToken());
        int B2 = Integer.parseInt(st.nextToken());

        int rstB = B1 * B2;
        int rstA = A1 * B2 + A2 * B1;
        int rstAB = gcd(rstA, rstB);
        sb.append(rstA / rstAB).append(' ').append(rstB / rstAB);
        System.out.print(sb);
    }
}

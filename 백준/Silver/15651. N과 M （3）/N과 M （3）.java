import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    //15651번 N과 M (3)
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] num;
    static void NtoM(int rst) {
        if(rst >= M) {
            for(int i : num) sb.append(i).append(' ');
            sb.append('\n');
            return;
        }
        for(int i = 1; i <= N; i++) {
            num[rst] = i;
            NtoM(rst+1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[M];

        NtoM(0);
        System.out.print(sb);
    }
}

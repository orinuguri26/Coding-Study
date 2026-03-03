import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    //15666번 N과 M(12)
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] num, result;
    static public void NtoM(int idx, int rst) {
        if(rst == M) {
            for(int i : result) sb.append(i).append(' ');
            sb.append('\n');
            return;
        }
        int prev = 0;
        for(int i = idx; i < N; i++) {
            if(num[i] == prev) continue;
            result[rst] = num[i];
            prev = num[i];
            NtoM(i, rst + 1);
        }
    }
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        num = new int[N];
        result = new int[M];
        for(int i = 0; i < N; i++) num[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(num);

        NtoM(0,0);
        System.out.print(sb);
    }
}

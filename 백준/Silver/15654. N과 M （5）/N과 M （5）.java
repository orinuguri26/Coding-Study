import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    //15654번 N과 M(5)
    static int N, M;
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static boolean[] used = new boolean[10001];
    static int[] num;
    static int[] result;
    static void per(int idx, int rst) {
        if(rst == M) {
            for(int i : result) sb.append(i).append(' ');
            sb.append('\n');
            return;
        }
        for(int i = idx; i < N; i++) {
            if(!used[num[i]]) continue;
            result[rst] = num[i];
            used[num[i]] = false;
            per(idx, rst+1);
            used[num[i]] = true;
        }
    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[N];
        result = new int[M];
        Arrays.fill(used, false);

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int t = Integer.parseInt(st.nextToken());
            num[i] = t;
            used[t] = true;
        }
        Arrays.sort(num);

        per(0, 0);
        System.out.print(sb);
    }
}

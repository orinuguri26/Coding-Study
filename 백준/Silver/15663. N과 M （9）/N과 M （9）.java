import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    //15663번 N과 M (9)
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] num, result;
    static boolean[] visited;
    static public void NtoM(int rst) {
        if(rst == M) {
            for(int i : result) sb.append(i).append(' ');
            sb.append('\n');
            return;
        }
        int prev = 0;
        for(int i = 0; i < N; i++) {
            if(visited[i] || prev == num[i]) continue;
            visited[i] = true;
            result[rst] = num[i];
            prev = num[i];
            NtoM(rst + 1);
            visited[i] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        num = new int[N];
        result = new int[M];
        visited = new boolean[N];
        Arrays.fill(visited, false);
        for(int i = 0; i < N; i++) num[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(num);
        NtoM(0);
        System.out.print(sb);
    }
}

import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    //10974번 모든 순열
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static boolean[] visited;
    static int[] num;
    public static void per(int rst) {
        if(rst == N) {
            for(int i : num) sb.append(i).append(' ');
            sb.append('\n');
            return;
        }
        for(int i = 1; i <= N; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            num[rst] = i;
            per(rst+1);
            visited[i] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        visited = new boolean[N+1];
        Arrays.fill(visited, false);
        per(0);
        System.out.print(sb);
    }
}

import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    //10971번 외판원 순회 2
    static int N;
    static int[][] cost;
    static int[] result;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;
    static void Salesman(int start,int prev, int total, int rst) {
        if(rst == N - 1) {
            if(cost[prev][start] == 0) return;
            answer = Math.min(answer, total + cost[prev][start]);
            return;
        }
        for(int i = 1; i <= N; i++) {
            if(visited[i]) continue;
            if(cost[prev][i] == 0) continue;
            visited[i] = true;
            Salesman(start, i, total + cost[prev][i],rst + 1);
            visited[i] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        cost = new int[N+1][N+1];
        result = new int[N];
        visited = new boolean[N+1];
        Arrays.fill(visited, false);

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) cost[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= N; i++) {
            visited[i] = true;
            Salesman(i, i, 0, 0);
            visited[i] = false;
        }
        System.out.print(answer);
    }
}
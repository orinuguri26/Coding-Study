import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    //10819번 차이를 최대로
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] num, result;
    static boolean[] visited;
    static int Max = -1;
    static public void A(int rst) {
        if(rst == N) {
            int sum = 0;
            for(int i = 0; i < N - 1; i++) sum += Math.abs(result[i] - result[i+1]);
            Max = Math.max(Max, sum);
            return;
        }
        for(int i = 0; i < N; i++) {
            if(visited[i]) continue;
            result[rst] = num[i];
            visited[i] = true;
            A(rst + 1);
            visited[i] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        result = new int[N];
        visited = new boolean[N];
        Arrays.fill(visited, false);
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) num[i] = Integer.parseInt(st.nextToken());
        A(0);
        System.out.print(Max);
    }
}

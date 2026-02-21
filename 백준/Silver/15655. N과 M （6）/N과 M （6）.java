import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    //28278번 스택 2
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] result;
    static int[] num;
    static void NtoM(int idx, int rst) {
        if(rst == M) {
            for(int i : result) sb.append(i).append(' ');
            sb.append('\n');
            return;
        }
        for(int i = idx; i < N; i++) {
            result[rst] = num[i];
            NtoM(i+1, rst+1);
        }
    }
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[N];
        result = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) num[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(num);

        NtoM(0, 0);
        System.out.print(sb);
    }
}

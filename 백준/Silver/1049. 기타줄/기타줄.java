import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    //1049번 기타줄
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] num;
    static int rst = 0;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[M*2];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            num[i * 2] = Integer.parseInt(st.nextToken());
            num[i * 2 + 1] = Integer.parseInt(st.nextToken());
        }

        while(N > 0) {
            int Min = 1001;
            int n = N;
            if(N >= 6) n = 6;
            for (int i = 0; i < num.length; i++) {
                if (i % 2 != 0) Min = Math.min(Min, num[i] * n);
                else Min = Math.min(Min, num[i]);
            }
            rst += Min;
            N -= n;
        }
        System.out.print(rst);
    }
}

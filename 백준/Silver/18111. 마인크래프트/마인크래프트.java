import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    //18111번 마인크래프트
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M, B;
    static int[][] ground;
    static int Min = Integer.MAX_VALUE;
    static int Max = 0;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        ground = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                ground[i][j] = Integer.parseInt(st.nextToken());
                Min = Math.min(Min, ground[i][j]);
                Max = Math.max(Max, ground[i][j]);
            }
        }
        int rstT = Integer.MAX_VALUE;
        int rstH = 0;
        for(int h = Min; h <= Max; h++) {
            int pb = 0;
            int mb = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(ground[i][j] < h) pb += h - ground[i][j];
                    else if(ground[i][j] > h) mb += ground[i][j] - h;
                }
            }
            if(pb > mb + B) continue;
            int time = mb * 2 + pb;
            if(rstT > time) {
                rstT = time;
                rstH = h;
            }
            else if(rstT == time) rstH = Math.max(rstH, h);
        }
        System.out.print(rstT + " " + rstH);
    }
}

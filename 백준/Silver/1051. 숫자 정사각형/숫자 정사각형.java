import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    //1051번 숫자 정사각형
    static int N,M;
    static int[][] square;
    static int rst = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        square = new int[N][M];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) square[i][j] = str.charAt(j) - '0';
        }

        if(N == 1 || M == 1) {
            System.out.print(rst);
            System.exit(0);
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                for(int t = j; t < M; t++) {
                    if(j == t) continue;
                    if(square[i][j] != square[i][t]) continue;
                    int dist = t - j;
                    int ni = i + dist;
                    if(ni >= N) continue;
                    if(square[i][j] == square[ni][j] && square[i][j] == square[ni][t]) {
                        rst = Math.max(rst, (dist+1) * (dist + 1));
                    }
                }
            }
        }
        System.out.print(rst);
    }
}
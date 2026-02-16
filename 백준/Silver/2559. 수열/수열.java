import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    //2559번 수열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] num = new int[N+1];
        int[] rst = new int[N-K+2];
        num[0] = rst[0] = 0;
        for(int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            if(i <= K) rst[1] += num[i];
        }
        int Max = rst[1];
        for(int i = 2; i <= N-K+1; i++){
            rst[i] = rst[i-1] - num[i-1] + num[i-1+K];
            Max=  Math.max(Max, rst[i]);
        }
        System.out.print(Max);
    }
}

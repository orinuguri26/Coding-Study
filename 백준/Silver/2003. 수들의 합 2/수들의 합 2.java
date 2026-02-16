import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    //2003번 수들의 합2
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] sum = new int[N+1];
        int[] num = new int[N+1];
        sum[0] = num[0] = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i-1] + num[i];
        }
        int left = sum.length-2;
        int right = sum.length-1;
        int rst = 0;
        while(left >= 0) {
            int diff = sum[right] - sum[left];
            if(diff < M) {
                left--;
                continue;
            }
            if(diff == M) rst++;
            right--;
        }
        System.out.print(rst);
    }
}

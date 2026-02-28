import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    //2512번 예산
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] money = new int[N];
        st = new StringTokenizer(br.readLine());
        int exp = 0;
        int sum = 0;
        for(int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(st.nextToken());
            sum += money[i];
            exp = Math.max(money[i], exp);
        }
        int Max = Integer.parseInt(br.readLine());
        if(sum <= Max) System.out.print(exp);
        else {
            int left = Max / N;
            int right = exp;
            int mid;
            while(left <= right){
                sum = 0;
                mid = (left + right) / 2;
                for(int i = 0; i < N; i++) {
                    sum += Math.min(money[i], mid);
                }
                if(sum <= Max) left = mid + 1;
                else right = mid - 1;
            }
            System.out.print(right);
         }
    }
}

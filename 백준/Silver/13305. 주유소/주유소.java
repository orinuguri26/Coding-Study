import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    //13305번 주유소
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] dist = new int[N];
        int[] fuel = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N; i++) dist[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) fuel[i] = Integer.parseInt(st.nextToken());

        int cost = 0;
        int prev = fuel[0];
        for(int i = 1; i < N; i++) {
            cost += prev * dist[i];
            if(fuel[i] < prev) prev = fuel[i];
        }
        System.out.print(cost);
    }
}

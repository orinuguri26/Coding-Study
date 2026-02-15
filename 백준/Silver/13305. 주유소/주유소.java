import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    //13305번 주유소
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        long[] dist = new long[N];
        long[] fuel = new long[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N; i++) dist[i] = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) fuel[i] = Long.parseLong(st.nextToken());

        long cost = 0;
        long prev = fuel[0];
        for(int i = 1; i < N; i++) {
            cost += prev * dist[i];
            if(fuel[i] < prev) prev = fuel[i];
        }
        System.out.print(cost);
    }
}

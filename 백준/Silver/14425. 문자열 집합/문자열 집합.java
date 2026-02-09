import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    //14425번 문자열 집합
    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> m = new HashMap<>();

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            m.put(str, 1);
        }
        int cnt = 0;
        for(int i = 0; i < M; i++) {
            String str = br.readLine();
            if(m.containsKey(str)) cnt++;
        }
        System.out.print(cnt);
    }
}

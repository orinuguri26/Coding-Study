import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    //17219번 비밀번호 찾기
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Map<String, String> Memo = new HashMap<>();
        while(N-->0) {
            st = new StringTokenizer(br.readLine());
            String site = st.nextToken();
            String pw = st.nextToken();

            Memo.put(site, pw);
        }
        while(M-->0) {
            String fsite = br.readLine();
            sb.append(Memo.get(fsite)).append('\n');
        }
        System.out.print(sb);
    }
}

import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    //1021번 회전하는 큐
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 1; i <= N; i++) dq.offer(i);

        st = new StringTokenizer(br.readLine());
        int rst = 0;
        for(int i = 0; i < M; i++) {
            int t = Integer.parseInt(st.nextToken());

            int cmd = 0;
            while(dq.getFirst() != t) {
                cmd++;
                dq.offerLast(dq.pollFirst());
            }
            cmd = Math.min(cmd, dq.size()-cmd);
            dq.pollFirst();
            rst += cmd;
        }
        System.out.print(rst);
    }
}

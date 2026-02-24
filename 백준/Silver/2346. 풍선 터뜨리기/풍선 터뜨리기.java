import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    //2346번 풍선 터뜨리기
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Deque<int[]> dq = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) dq.offer(new int[]{i, Integer.parseInt(st.nextToken())});

        int[] fdq = dq.pollFirst();
        sb.append(fdq[0]).append(' ');
        while(!dq.isEmpty()) {
            if(fdq[1] < 0) {
                for(int i = 0; i < Math.abs(fdq[1]); i++) dq.offerFirst(dq.pollLast());
            }
            else if(fdq[1] > 0) {
                for(int i = 0; i < Math.abs(fdq[1]) - 1; i++) dq.offerLast(dq.pollFirst());
            }
            fdq = dq.pollFirst();
            sb.append(fdq[0]).append(' ');
        }
        System.out.print(sb);
    }
}

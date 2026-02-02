import java.io.*;
import java.util.*;
import java.lang.*;

public class Main
{
    //1158 요세푸스 문제
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Deque<Integer> dq = new ArrayDeque<>();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= N; i++) dq.add(i);

        int cnt = 0;
        sb.append("<");
        while(!dq.isEmpty()) {
            if(dq.size() == 1) {
                sb.append(dq.pop()).append(">");
                break;
            }
            for(int i = 0; i < K-1; i++) dq.addLast(dq.pollFirst());
            sb.append(dq.pollFirst()).append(", ");
        }
        System.out.print(sb);
    }
}
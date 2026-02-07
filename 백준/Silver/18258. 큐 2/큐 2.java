import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    //18258번 큐2
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> q = new LinkedList<>();

        while(N--> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int x = 0;
            if(st.hasMoreTokens()) x = Integer.parseInt(st.nextToken());
            switch(cmd) {
                case "push" :
                    q.offer(x);
                    break;

                case "pop" :
                    if(q.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(q.poll()).append('\n');
                    break;

                case "size" :
                    sb.append(q.size()).append('\n');
                    break;

                case "empty" :
                    if(q.isEmpty()) sb.append(1).append('\n');
                    else sb.append(0).append('\n');
                    break;

                case "front" :
                    if(q.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(q.getFirst()).append('\n');
                    break;

                case "back" :
                    if(q.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(q.getLast()).append('\n');
            }
        }
        System.out.print(sb);
    }
}

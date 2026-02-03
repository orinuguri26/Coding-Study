import java.io.*;
import java.util.*;
import java.lang.*;

public class Main
{
    //10866번 덱
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new ArrayDeque<>();
        while(N-->0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if(cmd.equals("push_front")){
                dq.addFirst(Integer.parseInt(st.nextToken()));
            }
            else if(cmd.equals("push_back")){
                dq.addLast(Integer.parseInt(st.nextToken()));
            }
            else if(cmd.equals("pop_front")){
                if(dq.isEmpty()) sb.append(-1).append('\n');
                else sb.append(dq.pollFirst()).append('\n');
            }
            else if(cmd.equals("pop_back")){
                if(dq.isEmpty()) sb.append(-1).append('\n');
                else sb.append(dq.pollLast()).append('\n');
            }
            else if(cmd.equals("size")){
                sb.append(dq.size()).append('\n');
            }
            else if(cmd.equals("empty")){
                if(dq.isEmpty()) sb.append(1).append('\n');
                else sb.append(0).append('\n');
            }
            else if(cmd.equals("front")){
                if(dq.isEmpty()) sb.append(-1).append('\n');
                else sb.append(dq.getFirst()).append('\n');
            }
            else {
                if(dq.isEmpty()) sb.append(-1).append('\n');
                else sb.append(dq.getLast()).append('\n');
            }
        }
        System.out.print(sb);
    }
}
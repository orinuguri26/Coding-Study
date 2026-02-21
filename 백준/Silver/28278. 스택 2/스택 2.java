import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    //28278번 스택2
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();
        while(N-->0) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int X = 0;
            if(st.hasMoreTokens()) X = Integer.parseInt(st.nextToken());
            switch(cmd) {
                case 1:
                    s.add(X);
                    break;
                case 2:
                    if(s.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(s.pop()).append('\n');
                    break;
                case 3:
                    sb.append(s.size()).append('\n');
                    break;
                case 4:
                    if(s.isEmpty()) sb.append(1).append('\n');
                    else sb.append(0).append('\n');
                    break;
                case 5:
                    if(s.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(s.peek()).append('\n');
                    break;
                default:
                    break;
            }
        }
        System.out.print(sb);
    }
}

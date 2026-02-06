import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    //1002 터렛
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T--> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            double dis = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
            int sum = (r1 + r2) * (r1 + r2);
            int diff = (r1 - r2) * (r1 - r2);

            if(dis == 0 && r1 == r2) sb.append(-1).append('\n');

            else if(dis > sum || dis < diff) sb.append(0).append('\n');
            else if(dis == sum || dis == diff) sb.append(1).append('\n');
            else sb.append(2).append('\n');
        }
        System.out.print(sb);
    }
}
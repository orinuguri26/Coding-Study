import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    //1004번 어린 왕자
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int x1, x2, y1, y2, n, cx, cy, r;
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
            int cnt = 0;
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(br.readLine());
            while(n-- > 0) {
                st = new StringTokenizer(br.readLine());
                cx = Integer.parseInt(st.nextToken());
                cy = Integer.parseInt(st.nextToken());
                r = Integer.parseInt(st.nextToken());

                int start = (cx - x1) * (cx - x1) + (cy - y1) * (cy - y1);
                int end = (cx - x2) * (cx - x2) + (cy - y2) * (cy - y2);
                int r2 = r * r;
                if(start < r2 || end < r2) {
                    if (start < r2 && end < r2) continue;
                    cnt++;
                }
            }
            sb.append(cnt).append('\n');
        }
        System.out.print(sb);
    }
}

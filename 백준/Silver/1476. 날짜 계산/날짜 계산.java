import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    //1476번 날짜 계산
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int e = 1, s = 1, m = 1, rst = 1;
        while(e != E || s != S || m != M) {
            e++;
            s++;
            m++;
            if(e > 15) e = 1;
            if(s > 28) s = 1;
            if(m > 19) m = 1;
            rst++;
        }
        System.out.print(rst);
    }
}

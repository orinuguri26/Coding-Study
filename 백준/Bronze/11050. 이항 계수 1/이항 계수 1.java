import java.io.*;
import java.util.*;
import java.lang.*;

public class Main
{
    //11050번 이항계수1
    static int N, K;
    static int cnt = 0;
    static void num(int idx, int rst)
    {
        if(rst >= K)
        {
            cnt++;
            return;
        }
        for(int i = idx; i <= N; i++) num(i+1, rst+1);
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        num(1, 0);
        System.out.println(cnt);
    }
}
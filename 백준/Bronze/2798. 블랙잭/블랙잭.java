import java.io.*;
import java.util.*;
import java.lang.*;

public class Main
{
    //2798번 블랙잭
    static int Max, N, M;
    static int[] card;

    public static void BJ(int idx, int sum, int cnt)
    {
        if(cnt >= 3)
        {
            if(sum <= M) Max = Math.max(Max, sum);
            return;
        }

        for(int i = idx; i < N; i++)
        {
            sum += card[i];
            BJ(i+1, sum, cnt+1);
            sum -= card[i];
        }

    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        card = new int[N];
        for(int i = 0; i < N; i++) card[i] = Integer.parseInt(st.nextToken());

        BJ(0,0,0);
        System.out.println(Max);
    }
}
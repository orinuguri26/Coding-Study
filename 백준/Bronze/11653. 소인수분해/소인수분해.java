import java.io.*;
import java.util.*;
import java.lang.*;

public class Main
{
    //11653번 소인수분해
    static boolean prime(int n)
    {
        if(n < 2) return false;
        for(int i = 2; i * i <= n; i++) if(n % i == 0) return false;
        return true;
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(N > 1)
        {
            if(prime(N)) //소수면
            {
                sb.append(N).append('\n');
                N /= N;
                continue;
            }
            for(int i = 2; i <= N; i++)
            {
                if(N % i == 0)
                {
                    sb.append(i).append('\n');
                    N /= i;
                    break;
                }
            }
        }
        System.out.print(sb);
    }
}
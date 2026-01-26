import java.io.*;
import java.util.*;
import java.lang.*;

public class Main
{
    //1009번 분산처리
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(T-->0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int num = a % 10;
            if(num == 0)
            {
                sb.append(10).append('\n');
                continue;
            }
            if(num == 1 || num == 5 || num == 6) sb.append(num).append('\n');
            else
            {
                int end = (b-1) % 4;
                for(int i = 0; i < end; i++) num = (num * a) % 10;
                sb.append(num).append('\n');
            }
        }
        System.out.print(sb);
    }
}
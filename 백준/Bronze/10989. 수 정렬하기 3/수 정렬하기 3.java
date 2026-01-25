import java.io.*;
import java.util.*;
import java.lang.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[10_001];

        for(int i = 0; i < N; i++) num[Integer.parseInt(br.readLine())]++;

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < num.length; i++)
        {
            if(num[i] == 0) continue;
            while(num[i] -- > 0) sb.append(i).append('\n');
        }
        System.out.print(sb);
    }
}
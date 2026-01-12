import java.io.*;
import java.util.*;
import java.lang.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        int rst = N * M;
        for(int i = 0; i < 3; i++)
        {
            int t = M % 10;
            M = M / 10;
            sb.append(N * t);
            sb.append("\n");
        }
        sb.append(rst);
        System.out.print(sb);
    }
}

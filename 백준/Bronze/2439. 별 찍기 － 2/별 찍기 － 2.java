import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int t = 1; t <= N; t++)
        {
            for(int i = 0; i+t < N; i++) sb.append(' ');
            for(int i = 0; i < t; i++) sb.append('*');
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
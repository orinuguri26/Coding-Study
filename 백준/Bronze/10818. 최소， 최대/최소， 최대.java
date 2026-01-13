import java.io.*;
import java.util.*;
import java.lang.*;

public class Main
{
    //10818번 최소, 최대
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int Max = -1_000_000;
        int Min = 1_000_000;

        for(int i = 0; i < N; i++)
        {
            int tmp = Integer.parseInt(st.nextToken());
            Max = Math.max(Max, tmp);
            Min = Math.min(Min, tmp);
        }
        bw.write(Min + " ");
        bw.write(Max + "\n");
        bw.flush();
        bw.close();
    }
}
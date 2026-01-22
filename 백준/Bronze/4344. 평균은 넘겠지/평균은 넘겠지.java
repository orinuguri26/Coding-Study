import java.io.*;
import java.util.*;
import java.lang.*;

public class Main
{
    //4344번 평균은 넘겠지
    static int C, N;
    static int[] score;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        C = Integer.parseInt(br.readLine());

        while(C-->0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            score = new int[N];
            
            double sum = 0, avg;
            for(int i = 0; i < N; i++) sum += score[i] = Integer.parseInt(st.nextToken());
            avg = sum / N;

            int cnt = 0;
            for(int i : score) if(i > avg) cnt++;

            sb.append(String.format("%.3f%%\n", cnt * 100.0 / N));
        }
        System.out.print(sb);
    }
}

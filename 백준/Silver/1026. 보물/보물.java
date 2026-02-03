import java.io.*;
import java.util.*;
import java.lang.*;

public class Main
{
    //1026번 보물
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N], B = new int[N];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) A[i] = Integer.parseInt(st1.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) B[i] = Integer.parseInt(st2.nextToken());

        Arrays.sort(A);
        Arrays.sort(B);
        int sum = 0;
        for(int i = 0; i< N; i++) sum += A[i] * B[N-1-i];
        System.out.print(sum);
    }
}
import java.io.*;
import java.util.*;
import java.lang.*;

public class Main
{
    //10989번 수 정렬하기 3
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];

        for(int i = 0; i < N; i++) num[i] = Integer.parseInt(br.readLine());
        Arrays.sort(num);
        
        StringBuilder sb = new StringBuilder();
        for(int a : num) sb.append(a).append('\n');
        
        System.out.print(sb);
    }
}
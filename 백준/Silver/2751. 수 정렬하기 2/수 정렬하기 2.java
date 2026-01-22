import java.io.*;
import java.util.*;
import java.lang.*;

public class Main
{
    //2751번 수 정렬하기 2
    static int N;
    static int[] num;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        num = new int[N];
        for(int i = 0; i < N; i++) num[i] = Integer.parseInt(br.readLine());
        Arrays.sort(num);

        StringBuilder sb = new StringBuilder();
        for(int a : num) sb.append(a).append('\n');

        System.out.print(sb);
    }
}

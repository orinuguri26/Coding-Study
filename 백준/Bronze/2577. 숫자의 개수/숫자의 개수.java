import java.io.*;
import java.util.*;
import java.lang.*;

public class Main
{
    //2577번 숫자의 개수
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        String str = Integer.toString(A*B*C);
        //or String.valueOf(A*B*C) 사용

        int[] num = new int[10];
        Arrays.fill(num, 0);
        for(int i = 0; i < str.length(); i++) num[str.charAt(i) - '0']++;

        for(int a : num)  sb.append(a).append('\n');
        System.out.print(sb);
    }
}

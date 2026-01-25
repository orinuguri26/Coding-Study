import java.io.*;
import java.util.*;
import java.lang.*;

public class Main
{
    //1712번 손익분기점
    static int A, B, C;
    static int calc(int b, int c)
    {
        if(b == c) return -1;
        int rst = b > c ? -A / (b-c) + 1 : A / (c-b) + 1;
        return rst > 0 ? rst : -1;
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        System.out.print(calc(B,C));
    }
}
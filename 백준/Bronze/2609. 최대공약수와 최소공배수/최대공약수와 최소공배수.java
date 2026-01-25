import java.io.*;
import java.util.*;
import java.lang.*;

public class Main
{
    //2609번 최대공약수와 최소공배수
    public static void GCD(int a, int b)
    {
        int mul = a * b;
        if(a < b)
        {
            int tmp = a;
            a = b;
            b = tmp;
        }

        while(b > 0)
        {
            int r = a % b;
            a = b;
            b = r;
        }
        System.out.println(a + "\n" + mul / a);
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        GCD(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

    }
}
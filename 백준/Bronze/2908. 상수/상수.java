import java.io.*;
import java.util.*;
import java.lang.*;

public class Main
{
    //2908번 상수
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s1 = st.nextToken();
        String s2 = st.nextToken();

        String ns1 = "";
        String ns2 = "";

        for (int j = 2; j >= 0; j--)
        {
            ns1 += s1.charAt(j);
            ns2 += s2.charAt(j);
        }
        int Max = Math.max(Integer.parseInt(ns1), Integer.parseInt(ns2));
        System.out.println(Max);
    }
}
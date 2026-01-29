import java.io.*;
import java.util.*;
import java.lang.*;

public class Main
{
    //2748번 피보나치 수 2
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] fiv = new long[91];
        fiv[0] = 0;
        fiv[1] = 1;
        for(int i = 2; i < fiv.length; i++) fiv[i] = fiv[i-2]+fiv[i-1];
        System.out.print(fiv[n]);
    }
}
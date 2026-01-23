import java.io.*;
import java.util.*;
import java.lang.*;

public class Main
{
    //2292번 벌집
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int i = 1, num = 1;
        while(N - num > 0)
        {
            N -= num;
            i++;
            num = 6 * (i - 1);
        }
        System.out.println(i);
    }
}

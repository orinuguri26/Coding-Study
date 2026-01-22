import java.io.*;
import java.util.*;
import java.lang.*;

public class Main
{
    //2869번 달팽이는 올라가고 싶다
    static int A, B, V;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        int days = (V - A) / (A - B) + 1;
        if((V - A) % (A - B) != 0) days += 1;

        System.out.println(days);
    }
}

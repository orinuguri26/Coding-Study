import java.io.*;
import java.util.*;
import java.lang.*;

public class Main
{
    //2525번 오븐시계
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(br.readLine());

        M += T;
        H += M / 60;
        if(H >= 24) H -= 24;
        M %= 60;

        System.out.println(H + " " + M + "\n");
    }
}

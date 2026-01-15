import java.io.*;
import java.util.*;
import java.lang.*;

public class Main
{
    //1152번 단어의 개수
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = 0;
        while(st.hasMoreTokens())
        {
            String str = st.nextToken();
            cnt++;
        }
        System.out.println(cnt);
    }
}
import java.io.*;
import java.util.*;
import java.lang.*;

public class Main
{
    //8958번 OX퀴즈
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        while(N-- > 0)
        {
            String str = br.readLine();
            int score = 0;
            int tmp = 0;

            for(int i = 0; i < str.length(); i++)
            {
                if(str.charAt(i) != 'O')
                {
                    tmp = 0;
                    continue;
                }
                score += (tmp += 1);
            }
            System.out.println(score);
        }

    }
}
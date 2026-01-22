import java.io.*;
import java.util.*;
import java.lang.*;

public class Main
{
    //1316번 그룹 단어 체커
    static boolean[] alpha = new boolean[26];
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        for(int j = 0; j < N; j++)
        {
            Arrays.fill(alpha, false);
            String str = br.readLine();

            char prev = '\0';
            for(int i = 0; i < str.length(); i++)
            {
                if(str.charAt(i) != prev) //직전문자랑 다른데
                {
                    if(alpha[str.charAt(i) - 'a'])
                    {
                        cnt++;
                        break; //나온적 있는 문자
                    }
                    alpha[str.charAt(i)-'a'] = true;
                    prev = str.charAt(i);
                }
            }
        }
        System.out.println(N-cnt);
    }
}

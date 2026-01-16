import java.io.*;
import java.util.*;
import java.lang.*;

public class Main
{
    //10809번 알파벳 찾기
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        int[] alpha = new int[26];
        Arrays.fill(alpha, -1);

        for(int i = 0; i < S.length(); i++)
        {
            int idx = S.charAt(i) - 'a';
            if(alpha[idx] == -1) alpha[idx] = i;
        }

        for(int i : alpha) System.out.print(i + " ");
    }
}
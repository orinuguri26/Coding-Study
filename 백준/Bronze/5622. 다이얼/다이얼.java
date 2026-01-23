import java.io.*;
import java.util.*;
import java.lang.*;

public class Main
{
    //5622번 다이얼
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dial = new int[26];
        int idx = 0;
        for(int i = 2; i <= 9; i++)
        {
            int n = 3;
            if(i == 7 || i == 9) n = 4;
            for(int j = 0; j < n; j++)
            {
                dial[idx] = i;
                idx++;
            }
        }
        int sum = 0;
        String str = br.readLine();
        for(int i = 0; i < str.length(); i++) sum += dial[str.charAt(i) - 'A'] + 1;
        System.out.println(sum);
    }
}
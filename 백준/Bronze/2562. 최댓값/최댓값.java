import java.io.*;
import java.util.*;
import java.lang.*;

public class Main
{
    //2562번 최대값
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int Max = 0;
        int idx = 0;
        for(int i = 1; i <= 9; i++)
        {
            int tmp = Integer.parseInt(br.readLine());
            if(tmp > Max)
            {
                Max = tmp;
                idx = i;
            }
        }
        bw.write(Max + "\n");
        bw.write(idx + "\n");
        bw.flush();
        bw.close();
    }
}
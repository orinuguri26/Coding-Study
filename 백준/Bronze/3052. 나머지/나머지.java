import java.io.*;
import java.util.*;
import java.lang.*;
public class Main
{
    //3052번 나머지
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> num = new HashMap<>();
        for (int i = 0; i < 10; i++)
        {
            int N = Integer.parseInt(br.readLine());
            if(num.containsKey(N % 42))
            {
                num.put(N % 42, num.get(N%42) + 1);
                continue;
            }
            num.put(N % 42, 1);
        }
        System.out.println(num.size());
    }
}
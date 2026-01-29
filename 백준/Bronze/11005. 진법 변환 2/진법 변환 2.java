import java.io.*;
import java.util.*;
import java.lang.*;

public class Main
{
    //11005번 진법 변환2
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        ArrayList<Integer> num = new ArrayList<>();
        while(N > 0)
        {
            num.add(N % B);
            N /= B;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = num.size()-1; i >= 0; i--)
        {
            if(num.get(i) < 10)
            {
                sb.append((char)('0'+ num.get(i)));
                continue;
            }
            sb.append((char)('A' + (num.get(i)- 10)));
        }
        System.out.print(sb);
    }
}
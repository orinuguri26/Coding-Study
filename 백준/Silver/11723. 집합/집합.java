import java.io.*;
import java.util.*;
import java.lang.*;

public class Main
{
    //11723번 집합
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> S = new HashMap<>();
        int M = Integer.parseInt(br.readLine());
        while(M-->0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if(cmd.equals("all")) for(int i = 1; i <= 20; i++) S.put(i, 1);
            else if(cmd.equals("empty")) S.clear();
            else
            {
                int x = Integer.parseInt(st.nextToken());
                switch (cmd) {
                    case "add" :
                        if (!S.containsKey(x)) S.put(x, 1);
                        break;
                    case "remove" :
                        if (S.containsKey(x)) S.remove(x);
                        break;
                    case "check" :
                        if(S.containsKey(x)) sb.append(1).append('\n');
                        else sb.append(0).append('\n');
                        break;
                    case "toggle" :
                        if(S.containsKey(x)) S.remove(x);
                        else S.put(x, 1);
                        break;
                }
            }
        }
        System.out.print(sb);
    }
}
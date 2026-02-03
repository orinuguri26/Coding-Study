import java.io.*;
import java.util.*;
import java.lang.*;

public class Main
{
    //1966번 프린터 큐
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st1.nextToken());
            int M = Integer.parseInt(st1.nextToken());
            Queue<Integer> q = new LinkedList<>();
            TreeMap<Integer, Integer> pri = new TreeMap<>();

            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int rst = 0;
            for(int i = 0; i < N; i++) {
                int tmp = Integer.parseInt(st2.nextToken());
                q.offer(tmp);
                pri.put(tmp, pri.getOrDefault(tmp,0) + 1);
                if(i == M) rst = tmp;
            }

            int cnt = 0;
            while(true){
                if(q.peek().equals(pri.lastKey()))
                {
                    cnt += 1;
                    if(M == 0) {
                        System.out.println(cnt);
                        break;
                    }
                    int t = q.peek();
                    q.poll();
                    M-=1;
                    pri.put(pri.lastKey(), pri.getOrDefault(pri.lastKey(), 0) -1);
                    if(pri.get(t) == 0) pri.remove(t);
                }
                else
                {
                    if(M == 0) M = q.size() - 1;
                    else M -= 1;
                    q.offer(q.poll());
                }
            }
        }
    }
}
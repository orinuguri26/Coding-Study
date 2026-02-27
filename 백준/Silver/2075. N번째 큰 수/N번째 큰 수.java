import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    //2075번 N번째 큰 수
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                if(pq.size() < N) pq.offer(Integer.parseInt(st.nextToken()));
                else {
                    int num = Integer.parseInt(st.nextToken());
                    if(pq.peek() < num) {
                        pq.poll();
                        pq.offer(num);
                    }
                }
            }
        }
        System.out.print(pq.peek());
    }
}

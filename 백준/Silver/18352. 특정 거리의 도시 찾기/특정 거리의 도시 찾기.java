import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    //18352번 특정 거리의 도시 찾기
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M, K, X;
    static List<List<int[]>> city;
    static int[] dist;
    static void BFS(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        dist[start] = 0;
        pq.add(new int[]{start, 0});

        while(!pq.isEmpty()) {
            int[] f = pq.poll();
            int fdot = f[0];
            int fcost = f[1];

            if(dist[fdot] < fcost) continue;

            for(int[] i : city.get(fdot)) {
                int ndot = i[0];
                int ncost = i[1];

                if(dist[ndot] > fcost + ncost) {
                    dist[ndot] = fcost + ncost;
                    pq.add(new int[]{ndot, dist[ndot]});
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        city = new ArrayList<>();
        for(int i = 0; i <= N; i++) city.add(new ArrayList<>());
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            city.get(Integer.parseInt(st.nextToken())).add(new int[]{Integer.parseInt(st.nextToken()), 1});
        }
        BFS(X);
        for(int i = 1; i <= N; i++) {
            if(dist[i] == K) sb.append(i).append('\n');
        }
        if(sb.length() == 0) sb.append(-1);
        System.out.print(sb);
    }
}
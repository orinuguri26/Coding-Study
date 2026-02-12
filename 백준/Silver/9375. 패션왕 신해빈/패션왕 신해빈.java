import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    //9375번 패션왕 신해빈
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while(T-->0) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) {
                sb.append(0).append('\n');
                continue;
            }
            Map<String, Integer> cloth = new HashMap<>();
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String kind = st.nextToken();
                cloth.put(kind, cloth.getOrDefault(kind, 0) + 1);
            }
            int rst = 1;
            for(int i : cloth.values()) rst *= (i+1);
            sb.append(rst-1).append('\n');
        }
        System.out.print(sb);
    }
}

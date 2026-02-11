import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    //2217번 로프
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Long> rope = new ArrayList<>();

        for(int i = 0; i < N; i++) rope.add(Long.parseLong(br.readLine()));
        rope.sort(Collections.reverseOrder());
        long max = 0;
        for(int i = 0; i < rope.size(); i++) {
            max = Math.max(max, rope.get(i) * (i+1));
        }
        System.out.print(max);
    }
}

import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    //3273번 두 수의 합
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, x;
    public static void main(String[] args) throws IOException {
    n = Integer.parseInt(br.readLine());
    int[] num = new int[n];
    Set<Integer> s = new HashSet<>();
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < n; i++) {
        num[i] = Integer.parseInt(st.nextToken());
        s.add(num[i]);
    }
    x = Integer.parseInt(br.readLine());

    int cnt = 0;
    for(int i : num) if(s.contains(x-i) && x-i > 0) cnt++;
    System.out.print(cnt / 2);
    }
}

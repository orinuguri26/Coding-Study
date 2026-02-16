import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    //1269번 대칭 차집합
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Set<Integer> A = new HashSet<>();
        Set<Integer> B = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++)
            A.add(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++)
            B.add(Integer.parseInt(st.nextToken()));

        Set<Integer> Atmp = new HashSet<>(A);
        Set<Integer> Btmp = new HashSet<>(B);
        Atmp.removeAll(B);
        Btmp.removeAll(A);
        System.out.print(Atmp.size()+Btmp.size());
    }
}

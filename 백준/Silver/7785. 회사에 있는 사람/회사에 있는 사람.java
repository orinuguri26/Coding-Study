import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    //7785번 회사에 있는 사람
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> m = new TreeMap<>(Collections.reverseOrder());

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String cmd = st.nextToken();

            if(cmd.equals("leave")) {
                m.remove(name);
                continue;
            }
            m.put(name, 1);
        }
        int cnt = 0;
        for(String key : m.keySet()) System.out.print(key + '\n');
    }
}

import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    //1789번 수들의 합
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());

        int cnt = 0;
        for(int i = 1; i <= S; i++) {
            if(S - i > i) {
                cnt++;
                S -= i;
                continue;
            }
            cnt++;
            break;
        }
        System.out.print(cnt);
    }
}

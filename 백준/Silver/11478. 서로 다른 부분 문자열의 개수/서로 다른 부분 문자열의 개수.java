import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    //11478번 서로 다른 부분 문자열의 개수
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        Set<String> s = new HashSet<>();
        String S = br.readLine();
        String str;
        int cnt = 0;
        for(int i = 1; i <= S.length(); i++) {
            for(int j = 0; j < S.length(); j++) {
                if(j + i > S.length()) break;
                str = S.substring(j, j+i);
                if(!s.contains(str)) {
                    s.add(str);
                    cnt++;
                }
            }
        }
        System.out.print(cnt);
    }
}

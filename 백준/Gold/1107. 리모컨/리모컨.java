import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    //1107번 리모컨
    static int N, M;
    static boolean[] valid = new boolean[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        Arrays.fill(valid, true);

        int rst = Math.abs(N- 100); //100번에서 +,-로 왔다갔다 하는걸 초기값
        if(rst == 0) { //시작부터 목표채널이면 0번 끝
            System.out.print(rst);
            System.exit(0);
        }
        if(M != 0) { //고장난 번호 있으면 입력받아 저장
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) valid[Integer.parseInt(st.nextToken())] = false;
        }
        for(int i = 0; i < 1000000; i++) {
            String n = i + "";
            boolean invalid = false;
            for(int j = 0; j < n.length(); j++) {
                if(!valid[n.charAt(j) - '0']) {
                    invalid = true;
                    break;
                }
            }
            if(invalid) continue;
            rst = Math.min(rst, n.length() + Math.abs(N-i));}
        System.out.print(rst);
    }
}
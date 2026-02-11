import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    //1475번 방 번호
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] num = new int[10];
        for(int i = 0; i < s.length(); i++) num[s.charAt(i) - '0']++;
        int max = 0;
        for(int i = 0; i < num.length; i++) {
            if(i == 6 || i == 9) continue;
            max = Math.max(max, num[i]);
        }
        if(max * 2 >= num[6] + num[9]) System.out.print(max);
        else  System.out.print((num[6] + num[9] - 1) / 2 + 1);
    }
}

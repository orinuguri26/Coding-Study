import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    //17413번 단어 뒤집기2
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        boolean tag = false;
        Stack<Character> s = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '<') {
                if(!s.isEmpty()) while(!s.isEmpty()) sb.append(s.pop());
                tag = true;
                sb.append(str.charAt(i));
                continue;
            }
            if(str.charAt(i) == '>') {
                sb.append(str.charAt(i));
                tag = false;
                continue;
            }
            if(!tag) {
                if(str.charAt(i) == ' ') {
                    while(!s.isEmpty()) sb.append(s.pop());
                    sb.append(' ');
                }
                else s.push(str.charAt(i));
            }
            if(tag) sb.append(str.charAt(i));
        }
        while(!s.isEmpty()) sb.append(s.pop());
        System.out.print(sb);
    }
}

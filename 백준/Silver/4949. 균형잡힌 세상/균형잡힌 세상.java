import java.io.*;
import java.util.*;
import java.lang.*;

public class Main
{
    //4949번 균형잡힌 세상
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String str = br.readLine();
            if(str.equals(".")) break;
            boolean valid = true;
            Stack<Character> s = new Stack<>();

            for(int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if(c == '(' || c == '[') s.push(c);

                else if(c == ')') {
                    if(s.empty() || s.peek() != '(') { //큐가 비거나, top()이 같지 않으면
                        sb.append("no").append('\n');
                        valid = false;
                        break;
                    }
                    s.pop(); //큐가 안비었는데 top이 같다면
                }
                else if (c == ']') {
                    if (s.empty() || s.peek() != '[') {
                        sb.append("no").append('\n');
                        valid = false;
                        break;
                    }
                    s.pop();
                }
            }
            if(valid) sb.append(s.empty() ? "yes" : "no").append('\n');
        }
        System.out.print(sb);
    }
}
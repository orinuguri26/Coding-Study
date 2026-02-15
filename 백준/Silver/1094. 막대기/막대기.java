import javax.swing.plaf.basic.BasicBorders;
import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    //1094번 막대기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        System.out.println(Integer.bitCount(X));
    }
}

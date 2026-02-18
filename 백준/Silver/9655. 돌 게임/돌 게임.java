import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    //9655번 돌 게임
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    public static void main(String[] args) throws IOException {
    N = Integer.parseInt(br.readLine());
    if(N % 2 != 0) System.out.print("SK");
    else System.out.print("CY");
    }
}

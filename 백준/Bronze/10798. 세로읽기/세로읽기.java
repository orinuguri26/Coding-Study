import java.io.*;
import java.util.*;
import java.lang.*;

public class Main
{
    //10798번 세로 읽기
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<ArrayList<Character>> ch = new ArrayList<>();

        for(int i = 0; i < 15; i++) ch.add(new ArrayList<>());
        for(int i = 0; i < 5; i++)
        {
            String str = br.readLine();
            for(int j = 0; j < str.length(); j++) ch.get(j).add(str.charAt(j));
        }
        StringBuilder sb = new StringBuilder();
        for(ArrayList<Character> al : ch) for(char c : al) sb.append(c);

        System.out.print(sb);
    }
}
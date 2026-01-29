import java.io.*;
import java.util.*;
import java.lang.*;

public class Main
{
    //25206번 너의 평점은
    static final Map<String, Double> grade = new HashMap<>();
    static
    {
        grade.put("A+", 4.5);
        grade.put("A0", 4.0);
        grade.put("B+", 3.5);
        grade.put("B0", 3.0);
        grade.put("C+", 2.5);
        grade.put("C0", 2.0);
        grade.put("D+", 1.5);
        grade.put("D0", 1.0);
        grade.put("F", 0.0);
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double sum = 0, sumgd = 0;
        for(int i = 0; i < 20; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            double num = Double.parseDouble(st.nextToken());
            String str = st.nextToken();

            if(str.equals("P")) continue;

            double gd = grade.get(str);
            sum += num;
            sumgd += num * gd;
        }
        System.out.printf("%.6f", sumgd/sum);
    }
}
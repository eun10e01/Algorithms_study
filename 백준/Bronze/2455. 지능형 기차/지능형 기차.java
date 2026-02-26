import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int people[][] = new int[4][2];
        int count = 0;
        int max = 0;

        for(int i = 0; i < 4; i++)
        {
            st = new StringTokenizer(br.readLine());

            people[i][0] = Integer.parseInt(st.nextToken());
            count -= people[i][0];

            people[i][1] = Integer.parseInt(st.nextToken());
            count += people[i][1];

            max = Math.max(count, max);
        }

        System.out.println(max);
    }
}
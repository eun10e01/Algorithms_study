import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int xmin = Integer.MAX_VALUE;
        int ymin = Integer.MAX_VALUE;
        int xmax = Integer.MIN_VALUE;
        int ymax = Integer.MIN_VALUE;

        for(int i = 0; i < N; i++)
        {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            xmin = Math.min(x, xmin);
            ymin = Math.min(y, ymin);
            xmax = Math.max(x, xmax);
            ymax = Math.max(y, ymax);
        }

        System.out.println((xmax - xmin) * (ymax - ymin));
    }
}
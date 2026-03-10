import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int J = Integer.parseInt(br.readLine());

        int left = 1;
        int right = M;
        int move = 0;

        for(int i = 0; i < J; i++)
        {
            int apple = Integer.parseInt(br.readLine());

            if(apple > right)
            {
                move += apple - right;
                right = apple;
                left = right - M + 1;
            }
            else if(apple < left)
            {
                move += left - apple;
                left = apple;
                right = left + M - 1;
            }
        }

        System.out.println(move);
    }
}